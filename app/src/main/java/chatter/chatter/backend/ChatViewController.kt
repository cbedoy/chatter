package chatter.chatter.backend

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import chatter.chatter.R
import chatter.chatter.artifacts.BaseModel
import chatter.chatter.artifacts.models.Channel
import chatter.chatter.artifacts.models.ChatMessage
import chatter.chatter.core.PNController
import com.google.gson.Gson
import com.google.gson.JsonElement
import com.pubnub.api.PubNub
import com.pubnub.api.callbacks.PNCallback
import com.pubnub.api.callbacks.SubscribeCallback
import com.pubnub.api.enums.PNStatusCategory
import com.pubnub.api.models.consumer.PNPublishResult
import com.pubnub.api.models.consumer.PNStatus
import com.pubnub.api.models.consumer.pubsub.PNMessageResult
import com.pubnub.api.models.consumer.pubsub.PNPresenceEventResult
import kotlinx.android.synthetic.main.chat_view_controller.*
import timber.log.Timber
import java.util.*
import kotlin.collections.ArrayList


/**
 * Chatter
 *
 * Created by bedoy on 6/6/18.
 */
class ChatViewController : BaseTableViewController(){

    var channel : Channel? = null
    var userId : String? = null
    var elements : ArrayList<BaseModel> = ArrayList()
    var gson = Gson()
    private var subscribeCallback: SubscribeCallback = object : SubscribeCallback() {
        override fun status(pubnub: PubNub, status: PNStatus) {
            when {
                status.category == PNStatusCategory.PNUnexpectedDisconnectCategory -> // internet got lost, do some magic and call reconnect when ready
                    pubnub.reconnect()
                status.category == PNStatusCategory.PNTimeoutCategory -> // do some magic and call reconnect when ready
                    pubnub.reconnect()
                else -> Timber.e("${status.statusCode}")
            }
        }

        override fun message(pubnub: PubNub, message: PNMessageResult) {
            Timber.d("on message")

            val jsonElement = message.message

            prepareMessage(jsonElement)
        }

        override fun presence(pubnub: PubNub, presence: PNPresenceEventResult) {
            Timber.d("on presence")
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.chat_view_controller, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val layoutManager = LinearLayoutManager(context, LinearLayout.VERTICAL, false)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        layoutManager.stackFromEnd = true
        layoutManager.reverseLayout = false

        chat_view_controller_recycler_view.layoutManager = layoutManager
        chat_view_controller_recycler_view.adapter = chatterAdapter
        chat_view_controller_edit_text.setText("")
        chat_view_controller_edit_text.addTextChangedListener(object : TextWatcher{
            override fun afterTextChanged(p0: Editable?) {

            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(text: CharSequence?, p1: Int, p2: Int, p3: Int) {
                chat_view_controller_action_view.visibility = if(text?.length!! > 0) View.VISIBLE else View.GONE
            }
        })
        chat_view_controller_action_view.visibility = if(chat_view_controller_edit_text.text?.length!! > 0) View.VISIBLE else View.GONE

        chat_view_controller_action_view.setOnClickListener {
            val messageText = chat_view_controller_edit_text.text.toString()

            processSendMessage(messageText)

            chat_view_controller_edit_text.setText("")
        }
    }

    override fun onResume() {
        super.onResume()

        PNController.addSubscribeCallback(subscribeCallback)
        PNController.subscribeToChannel(channel?.identifier)

        runOnAsync("requestHistory", object  : IAsyncProcess{
            override fun runOnAsync() {
                PNController.requestHistory(channel?.identifier, object : PNController.PNControllerHistoryCallback{
                    override fun onLoadedMessages(messages: ArrayList<JsonElement>) {
                        messages.forEach {
                            prepareMessage(it)
                        }
                    }
                })
            }
        })
    }

    override fun onPause() {
        super.onPause()
        PNController.removeSubscribeCallback(subscribeCallback)
        PNController.unsubscribeFromChannel(channel?.identifier)
    }

    private fun prepareMessage(jsonMessage: JsonElement?){

        if (jsonMessage != null) {
            var metadata: Map<String, Any> = HashMap()
            metadata = gson.fromJson(jsonMessage, metadata.javaClass)

            val chatMessage = ChatMessage()
            chatMessage.identifier = metadata["uuid"].toString()
            chatMessage.message = metadata["raw_message"].toString()
            chatMessage.from = metadata["from"].toString()
            chatMessage.avatar = metadata["avatar"].toString()
            chatMessage.nickname = metadata["nickname"].toString()

            elements.add(0, chatMessage)

            addElements(elements)
        }
    }

    private fun processSendMessage(messageText : String){
        if (channel?.identifier != null && messageText.isNotEmpty()) {
            PNController.sendMessageToChannel(channel?.identifier!!, messageText, userId!!, object : PNCallback<PNPublishResult>() {
                override fun onResponse(result: PNPublishResult?, status: PNStatus?) {
                    if (status != null){
                        if (!status.isError){

                        }
                    }
                }
            })
        }
    }
}