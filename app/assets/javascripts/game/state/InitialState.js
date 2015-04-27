define(["utils/Config", "game/state/GameState", "game/state/LoadingScreen"], function (cfg, GameState, LoadingScreen) {
  "use strict";

  function InitialState(game) {
    GameState.call(this, 'initial', game);
  }

  InitialState.prototype = Object.create(GameState.prototype);
  InitialState.prototype.constructor = InitialState;

  InitialState.prototype.create = function() {
    GameState.prototype.create.apply(this, arguments);

    var loadingScreen = new LoadingScreen(this.game);
    this.game.state.add('loading', loadingScreen);

    this.game.time.advancedTiming = true;

    this.game.scale.scaleMode = Phaser.ScaleManager.NO_SCALE;
    var g = this.game;
    var resize = function() {
      g.state.getCurrentState().resize();
    };
    window.addEventListener("resize", function() {
      g.scale.setGameSize(window.innerWidth, window.innerHeight);
      if(g.playmat !== undefined) {
        setTimeout(resize, 100);
      }
    });

    if(typeof Phaser.Plugin.Debug === 'function') {
      this.game.add.plugin(Phaser.Plugin.Debug);
    }

    this.game.send("GetVersion", {});
    this.game.state.start('loading');
  };

  return InitialState;
});
