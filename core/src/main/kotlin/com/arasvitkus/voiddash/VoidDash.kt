package com.arasvitkus.voiddash

import com.arasvitkus.voiddash.screen.FirstScreen
import com.arasvitkus.voiddash.screen.SecondScreen
import com.badlogic.gdx.Application.LOG_DEBUG
import com.badlogic.gdx.Gdx
import ktx.app.KtxGame
import ktx.app.KtxScreen
import ktx.log.Logger
import ktx.log.debug
import ktx.log.logger

private val LOG: Logger = logger<VoidDash>()

class VoidDash : KtxGame<KtxScreen>() {
    override fun create() {
        Gdx.app.logLevel = LOG_DEBUG
        LOG.debug { "Create game instance" }
        addScreen(FirstScreen(this))
        addScreen(SecondScreen(this))
        setScreen<FirstScreen>()
    }
}