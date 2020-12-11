package com.arasvitkus.voiddash.screen

import com.arasvitkus.voiddash.UNIT_SCALE
import com.arasvitkus.voiddash.VoidDash
import com.arasvitkus.voiddash.ecs.component.GraphicComponent
import com.arasvitkus.voiddash.ecs.component.TransformComponent
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Input
import com.badlogic.gdx.Screen
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.Sprite
import com.badlogic.gdx.utils.viewport.FitViewport
import ktx.app.KtxScreen
import ktx.ashley.entity
import ktx.ashley.get
import ktx.ashley.with
import ktx.graphics.use
import ktx.log.Logger
import ktx.log.debug
import ktx.log.logger

private val LOG: Logger = logger<GameScreen>()

class GameScreen(game: VoidDash) : VoidDashScreen(game) {
    private val viewport = FitViewport(9f, 16f)
    private val playerTexture = Texture(Gdx.files.internal("graphics/ship_base.png"))

    private val player = engine.entity {
        with<TransformComponent> {
            position.set(1f, 1f, 0f)
        }
        with<GraphicComponent> {
            sprite.run {
                setRegion(playerTexture)
                setSize(texture.width * UNIT_SCALE, texture.height * UNIT_SCALE)
                setOriginCenter()
            }
        }
    }

    override fun show() {
        LOG.debug { "Game screen is showing" }
    }

    override fun resize(width: Int, height: Int) {
        viewport.update(width, height, true)
    }

    override fun render(delta: Float) {
        engine.update(delta)

        viewport.apply() //Video 7 created this code with errors
        batch.use(viewport.camera.combined) {
            player[GraphicComponent.mapper]?.let {
                player[TransformComponent.mapper]?.let {
                    graphic.sprite.run {
                        rotation = transform.rotationDeg
                        setBounds(transform.position.x, transform.position.y, transform.size.x, transform.size.y)
                        draw(batch)

                    }
                }
            }
        }
    }

    override fun dispose() {
        playerTexture.dispose()
    }
}