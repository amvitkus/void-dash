package com.arasvitkus.voiddash.screen

import com.arasvitkus.voiddash.UNIT_SCALE
import com.arasvitkus.voiddash.VoidDash
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Input
import com.badlogic.gdx.Screen
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.Sprite
import com.badlogic.gdx.utils.viewport.FitViewport
import ktx.app.KtxScreen
import ktx.graphics.use
import ktx.log.Logger
import ktx.log.debug
import ktx.log.logger

private val LOG: Logger = logger<GameScreen>()

class GameScreen(game: VoidDash) : VoidDashScreen(game) {
    private val viewport = FitViewport(9f, 16f)
    private val texture = Texture(Gdx.files.internal("graphics/ship_base.png"))
    private val sprite = Sprite(texture).apply {
        setSize(1f, 1f)
    }//Sprite doesn't need to be disposed.

    override fun show() {
        LOG.debug { "Game screen is showing" }
        sprite.setPosition(1f, 1f)//0,0 coordinate bottom left of screen
    }

    override fun resize(width: Int, height: Int) {
        viewport.update(width, height, true)
    }

    override fun render(delta: Float) {
        viewport.apply()
        batch.use(viewport.camera.combined) {
            sprite.draw(it)
        }

        //uiViewport.apply()... UI rendering
    }

    override fun dispose() {
        texture.dispose()
    }
}