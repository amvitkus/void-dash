package com.arasvitkus.voiddash.screen

import com.arasvitkus.voiddash.VoidDash
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Input
import com.badlogic.gdx.Screen
import ktx.app.KtxScreen
import ktx.log.Logger
import ktx.log.debug
import ktx.log.logger

private val LOG: Logger = logger<FirstScreen>()

class FirstScreen(game: VoidDash) : VoidDashScreen(game) {
    override fun show() {
        LOG.debug { "First screen is showing" }
    }

    override fun render(delta: Float) {
        if(Gdx.input.isKeyJustPressed(Input.Keys.NUM_2)) {
            game.setScreen<SecondScreen>()
        }
    }
}

