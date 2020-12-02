package com.arasvitkus.voiddash

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration

/** Launches the desktop (LWJGL3) application.  */

    fun main() {
    Lwjgl3Application(VoidDash(), Lwjgl3ApplicationConfiguration().apply {
        setTitle("Void Dash")
        setWindowedMode(640, 480)
        setWindowIcon("libgdx128.png", "libgdx64.png", "libgdx32.png", "libgdx16.png")
    })
}

