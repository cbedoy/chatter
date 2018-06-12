package chatter.chatter

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import chatter.chatter.artifacts.models.Channel
import chatter.chatter.backend.BaseViewController
import chatter.chatter.backend.ChatViewController
import java.util.*

/**
 * Chatter
 *
 *
 * Created by bedoy on 6/6/18.
 */
class ChatActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val channel = Channel()

        val userId = UUID.nameUUIDFromBytes("Carlos Bedoy".toByteArray()).toString()

        channel.avatar = intent.getStringExtra("channel_avatar")
        channel.name = intent.getStringExtra("channel_name")
        channel.identifier = intent.getStringExtra("channel_identifier")

        val chatViewController = ChatViewController()
        chatViewController.channel = channel
        chatViewController.userId = userId


        setContentView(R.layout.chat_activity)

        showViewController(chatViewController)
    }

    private fun showViewController(viewController: BaseViewController?){

        if (viewController != null) {
            val fragmentTransaction = supportFragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.content_frame, viewController)
            fragmentTransaction.commit()
        }
    }
}
