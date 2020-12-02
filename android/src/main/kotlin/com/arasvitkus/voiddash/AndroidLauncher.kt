package com.arasvitkus.voiddash

import com.badlogic.gdx.backends.android.AndroidApplication
import android.os.Bundle
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration
import com.arasvitkus.voiddash.VoidDash

/** Launches the Android application.  */
class AndroidLauncher : AndroidApplication() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initialize(VoidDash(), AndroidApplicationConfiguration())
    }
}