package services.email

import models.audit.{Metric, UserFeedback}
import org.apache.commons.mail.EmailException
import java.time.LocalDate
import play.api.i18n.Messages
import play.api.libs.mailer._
import services.audit.DailyMetricService
import util.{Config, DateUtils, Logging}

@javax.inject.Singleton
class EmailService @javax.inject.Inject() (mailerClient: MailerClient, config: Config) extends Logging {
  private[this] val adminFrom = "Solitaire.gg <solitaire@solitaire.gg>"
  private[this] val adminTextMessage = "You should really use HTML mail."

  def sendWelcomeMessage(toName: String, toAddress: String)(implicit messages: Messages) = {
    val to = s"$toName <$toAddress>"
    val textTemplate = views.html.email.welcomeText()
    val htmlTemplate = views.html.email.welcomeHtml().toString()
    val welcomeSubject = Messages("email.welcome.subject", Config.projectName)
    sendMessage(Messages("email.from"), Seq(to), welcomeSubject, textTemplate.toString(), htmlTemplate)
  }

  def feedbackSubmitted(fb: UserFeedback)(implicit messages: Messages) = {
    val text = "You should really use HTML mail."
    val html = views.html.email.feedbackHtml(fb).toString
    sendMessage(Messages("email.from"), config.adminEmail, s"${Config.projectName} user feedback from [${fb.deviceId}]", text, html)
  }

  def sendDailyReport(d: LocalDate, metrics: Map[Metric, Long], totals: Map[Metric, Long], counts: Seq[(String, Long)]) = {
    val html = views.html.admin.report.emailReport(d, metrics, totals, counts).toString
    sendMessage(adminFrom, config.adminEmail, s"${Config.projectName} report for [$d]", adminTextMessage, html)
    val ret = DailyMetricService.setMetric(d, Metric.ReportSent, 1L)
    log.info(s"Sent email report for [$d] to [${config.adminEmail}].")
    ret
  }

  def sendError(msg: String, ctx: String, ex: Option[Throwable]) = {
    val html = views.html.email.severeErrorHtml(msg, ctx, ex, DateUtils.now).toString
    sendMessage(adminFrom, config.adminEmail, s"${Config.projectName} error for [$ctx].", adminTextMessage, html)
  }

  def sendMessage(from: String, to: Seq[String], subject: String, textMessage: String, htmlMessage: String): Unit = {
    val email = Email(subject = subject, from = from, to = to, bodyText = Some(textMessage), bodyHtml = Some(htmlMessage))
    try {
      mailerClient.send(email)
    } catch {
      case e: EmailException => log.error("Could not send email.", e)
    }
  }
}
