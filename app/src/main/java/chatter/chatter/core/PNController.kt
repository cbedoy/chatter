package chatter.chatter.core

import com.pubnub.api.PNConfiguration
import com.pubnub.api.PubNub
import com.pubnub.api.callbacks.PNCallback
import com.pubnub.api.callbacks.SubscribeCallback
import com.pubnub.api.enums.PNStatusCategory
import com.pubnub.api.models.consumer.PNPublishResult
import com.pubnub.api.models.consumer.PNStatus
import com.pubnub.api.models.consumer.PNTimeResult
import com.pubnub.api.models.consumer.history.PNHistoryResult
import com.pubnub.api.models.consumer.pubsub.PNMessageResult
import com.pubnub.api.models.consumer.pubsub.PNPresenceEventResult
import timber.log.Timber
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap


/**
 * Chatter
 *
 * Created by bedoy on 5/8/18.
 */


object PNController {

    private val TAG = "PNController"
    private var pubNub : PubNub?= null

    fun init(){
        val pnConfiguration = PNConfiguration()
        pnConfiguration.subscribeKey = "sub-c-d3aea19c-4894-11e8-ba5f-36600805f352"
        pnConfiguration.publishKey = "pub-c-c4e86432-b754-4913-864a-4ef778860ec0"
        pnConfiguration.isSecure = false

        pubNub = PubNub(pnConfiguration)
        pubNub?.addListener(object : SubscribeCallback() {
            override fun status(pubnub: PubNub?, status: PNStatus?) {
                if (status?.category === PNStatusCategory.PNUnexpectedDisconnectCategory) {
                    // This event happens when radio / connectivity is lost
                } else if (status?.category === PNStatusCategory.PNConnectedCategory) {

                    // Connect event. You can do stuff like publish, and know you'll get it.
                    // Or just use the connected event to confirm you are subscribed for
                    // UI / internal notifications, etc

                    if (status.category === PNStatusCategory.PNConnectedCategory) {
                        /*
                        pubnub?.publish()?.channel("chatter")?.message("hello!!")?.async(object : PNCallback<PNPublishResult>() {
                            override fun onResponse(result: PNPublishResult, status: PNStatus) {
                                // Check whether request successfully completed or not.
                                if (!status.isError) {

                                    // Message successfully published to specified channel.

                                    Timber.tag(TAG).d("MESSAGE SENT")
                                } else {

                                    // Handle message publish error. Check 'category' property to find out possible issue
                                    // because of which request did fail.
                                    //
                                    // Request can be resent using: [status retry];

                                    Timber.tag(TAG).d("MESSAGE NO SENT")

                                }// Request processing failed.
                            }
                        })
                        */
                    }
                } else if (status?.category === PNStatusCategory.PNReconnectedCategory) {

                    // Happens as part of our regular operation. This event happens when
                    // radio / connectivity is lost, then regained.
                } else if (status?.category === PNStatusCategory.PNDecryptionErrorCategory) {

                    // Handle message decryption error. Probably client configured to
                    // encrypt messages and on live data feed it received plain text.
                }
            }

            override fun presence(pubnub: PubNub?, presence: PNPresenceEventResult?) {

            }

            override fun message(pubnub: PubNub?, message: PNMessageResult?) {
                // Handle new message stored in message.message
                if (message?.channel != null) {
                    // Message has been received on channel group stored in
                    // message.getChannel()
                }
                else {
                    // Message has been received on channel stored in
                    // message.getSubscription()
                }

                Timber.tag(TAG).d("Message ${message?.message}")
                Timber.tag(TAG).d("Message ${message?.subscription}")
                Timber.tag(TAG).d("Message ${message?.timetoken}")

                /*
                    log the following items with your favorite logger
                        - message.getMessage()
                        - message.getSubscription()
                        - message.getTimetoken()
                */
            }
        })
    }

    fun subscribeToChannel(channel: String?){

        if (channel != null) {
            val channels = Arrays.asList(channel)

            pubNub?.subscribe()?.channels(channels)?.execute()
        }
    }

    fun unsubscribeFromChannel(channel: String){

        val channels = Arrays.asList(channel)

        pubNub?.unsubscribe()?.channels(channels)?.execute()
    }

    fun sendMessageToChannel(channel: String, message: String){

        pubNub?.publish()?.channel(channel)?.message(message)?.async(object : PNCallback<PNPublishResult>(){
            override fun onResponse(result: PNPublishResult?, status: PNStatus?) {
                if (status?.isError!!){
                    Timber.e("Message Not Sent")
                }
            }
        })
    }

    fun sendMessageToChannel(channel: String, message: String, store: Boolean, post: Boolean){
        val map = HashMap<String, Any>()
        map["raw_message"] = message
        map["date"] = Date()
        map["uuid"] = UUID.randomUUID()
        map["length"] = message.length
        pubNub?.publish()?.channel(channel)?.message(message)?.meta(map)?.shouldStore(store)?.usePOST(post)?.async(object : PNCallback<PNPublishResult>(){
            override fun onResponse(result: PNPublishResult?, status: PNStatus?) {
                if (status?.isError!!){
                    Timber.e("Message Not Sent")
                }
            }
        })
    }

    fun requestHistory(channel: String, callback : PNControllerHistoryCallback){
        pubNub?.history()?.channel(channel)?.includeTimetoken(true)?.async(object : PNCallback<PNHistoryResult>() {
            override fun onResponse(result: PNHistoryResult?, status: PNStatus?) {
                val rawMessages = result?.messages

                val messages = ArrayList<Any>()

                rawMessages?.forEach {
                    messages.add(it)
                }

                callback.onLoadedMessages(messages)
            }
        })
    }

    fun verifyClientConnectivity(){
        pubNub?.time()?.async(object : PNCallback<PNTimeResult>() {
            override fun onResponse(result: PNTimeResult?, status: PNStatus?) {

            }
        })
    }

    interface PNControllerHistoryCallback{
        fun onLoadedMessages(messages: List<Any>)
    }
}