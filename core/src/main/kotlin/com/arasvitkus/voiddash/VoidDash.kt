package com.arasvitkus.voiddash


import com.arasvitkus.voiddash.screen.GameScreen
import com.arasvitkus.voiddash.screen.VoidDashScreen
import com.badlogic.ashley.core.Engine
import com.badlogic.ashley.core.PooledEngine
import com.badlogic.gdx.Application.LOG_DEBUG
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.g2d.Batch
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import ktx.app.KtxGame
import ktx.app.KtxScreen
import ktx.log.Logger
import ktx.log.debug
import ktx.log.logger

const val UNIT_SCALE = 1 / 16f
private val LOG: Logger = logger<VoidDash>()

class VoidDash : KtxGame<VoidDashScreen>() {
    val batch: Batch by lazy { SpriteBatch() }//By lazy gets initialized the first time when I do something with the batch.
    val engine: Engine by lazy { PooledEngine() }

    override fun create() {
        Gdx.app.logLevel = LOG_DEBUG
        LOG.debug { "Create game instance" }
        addScreen(GameScreen(this))
        setScreen<GameScreen>()
    }

    //Releases resources, saves memory
    override fun dispose() {
        super.dispose()
        LOG.debug { "Sprites in batch: ${(batch as SpriteBatch).maxSpritesInBatch}" }
        batch.dispose()
    }
}