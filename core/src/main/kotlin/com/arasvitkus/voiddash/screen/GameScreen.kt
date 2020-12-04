package com.arasvitkus.voiddash.screen

import com.arasvitkus.voiddash.VoidDash
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Input
import com.badlogic.gdx.Screen
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.Sprite
import ktx.app.KtxScreen
import ktx.graphics.use
import ktx.log.Logger
import ktx.log.debug
import ktx.log.logger

private val LOG: Logger = logger<GameScreen>()

class GameScreen(game: VoidDash) : VoidDashScreen(game) {
    private val texture = Texture(Gdx.files.internal("graphics/ship_base.png"))
    private val sprite = Sprite(texture)//Sprite doesn't need to be disposed.

    override fun show() {
        LOG.debug { "First screen is showing" }
        sprite.setPosition(1f, 1f)//0,0 coordinate bottom left of screen
    }

    override fun render(delta: Float) {
        batch.use {
            sprite.draw(it)
        }
    }

    override fun dispose() {
        texture.dispose()
    }
}