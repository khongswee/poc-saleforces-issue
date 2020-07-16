package com.example.saleforcesmanager

import android.app.Application
import com.thunderhead.OneModes
import com.thunderhead.android.api.oneConfigure
import java.net.URI

class App : Application() {

    companion object {
        const val SITE_KEY = ""
        const val API_KEY = ""
        const val SHARED_SECRET = ""
        const val USER_ID = ""
        const val HOST = ""
        const val TOUCHPOINT = ""
    }

    override fun onCreate() {
        super.onCreate()
        oneConfigure {
            siteKey = SITE_KEY
            apiKey = API_KEY
            sharedSecret = SHARED_SECRET
            userId = USER_ID
            host = URI(HOST)
            touchpoint = URI(TOUCHPOINT)
            mode = OneModes.ADMIN_MODE
        }
    }

}