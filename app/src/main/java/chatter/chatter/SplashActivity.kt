package chatter.chatter

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.splash_view_controller.*

/**
 * Chatter
 *
 * Created by bedoy on 5/7/18.
 */
class SplashActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_view_controller)

        val codeFormat = String.format("%s\nRelease %s (%s)", BuildConfig.RELEASE_NAME, BuildConfig.VERSION_NAME, BuildConfig.VERSION_CODE)

        splash_view_controller_version.text = codeFormat

        Handler().postDelayed({
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }, 1000)
    }
}