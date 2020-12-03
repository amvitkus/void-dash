package com.arasvitkus.voiddash.screen

import com.arasvitkus.voiddash.VoidDash
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Input
import ktx.app.KtxScreen
import ktx.log.Logger
import ktx.log.debug
import ktx.log.logger

private val LOG: Logger = logger<SecondScreen>()

class SecondScreen(game: VoidDash) : VoidDashScreen(game) {
    override fun show() {
        LOG.debug { "Second screen is showing" }
    }

    override fun render(delta: Float) {
        if(Gdx.input.isKeyJustPressed(Input.Keys.NUM_1)) {
            game.setScreen<FirstScreen>()
        }
    }
}