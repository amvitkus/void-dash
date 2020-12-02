package com.arasvitkus.voiddash

import com.badlogic.gdx.Game

/** [com.badlogic.gdx.ApplicationListener] implementation shared by all platforms.  */
class VoidDash : Game() {
    override fun create() {
        setScreen(FirstScreen())
    }
}