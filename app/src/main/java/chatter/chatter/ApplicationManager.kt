package chatter.chatter

import android.app.Application
import chatter.chatter.core.PNController

/**
 * Chatter
 *
 * Created by bedoy on 5/8/18.
 */
class ApplicationManager : Application() {
    override fun onCreate() {
        super.onCreate()

        PNController.init()
    }
}