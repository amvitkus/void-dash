package com.arasvitkus.voiddash.screen

import com.arasvitkus.voiddash.VoidDash
import com.badlogic.gdx.graphics.g2d.Batch
import ktx.app.KtxScreen

abstract class VoidDashScreen(val game: VoidDash, val batch: Batch= game.batch) : KtxScreen
