package chatter.chatter.core

import chatter.chatter.artifacts.models.User
import chatter.chatter.utils.BuddiesProvider
import com.google.gson.JsonElement
import com.pubnub.api.PNConfiguration
import com.pubnub.api.PubNub
import com.pubnub.api.callbacks.PNCallback
import com.pubnub.api.callbacks.SubscribeCallback
import com.pubnub.api.enums.PNLogVerbosity
import com.pubnub.api.models.consumer.PNPublishResult
import com.pubnub.api.models.consumer.PNStatus
import com.pubnub.api.models.consumer.PNTimeResult
import com.pubnub.api.models.consumer.history.PNHistoryResult
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
        pnConfiguration.logVerbosity = PNLogVerbosity.BODY

        pubNub = PubNub(pnConfiguration)
    }

    fun registerUser(user : User){
        pubNub?.configuration?.uuid = user.identifier
    }

    fun subscribeToChannel(channel: String?){

        if (channel != null) {
            val channels = Arrays.asList(channel)

            pubNub?.subscribe()?.channels(channels)?.execute()
        }
    }

    fun unsubscribeFromChannel(channel: String?){
        if (channel != null) {
            val channels = Arrays.asList(channel)

            pubNub?.unsubscribe()?.channels(channels)?.execute()
        }
    }

    fun sendMessageToChannel(channel: String, messageText: String, from : String, callback : PNCallback<PNPublishResult>){

        val fakeBuddies = BuddiesProvider.fakeBuddies()
        val nextInt = Random().nextInt(fakeBuddies.size)

        val message = HashMap<String, Any>()
        message["raw_message"] = messageText
        message["date"] = Date()
        message["uuid"] = UUID.randomUUID()
        message["from"] = from
        message["avatar"] = fakeBuddies[nextInt].avatar.toString()
        message["nickname"] = fakeBuddies[nextInt].nickname.toString()
        pubNub?.publish()?.channel(channel)?.message(message)?.shouldStore(true)?.usePOST(true)?.async(callback)
    }

    fun requestHistory(channel: String?, callback : PNControllerHistoryCallback){
        if (channel != null) {
            pubNub?.history()?.channel(channel)?.async(object  : PNCallback<PNHistoryResult>(){
                override fun onResponse(result: PNHistoryResult?, status: PNStatus?) {
                    if (status != null){
                        if (!status.isError){
                            val messages : ArrayList<JsonElement> = ArrayList()

                            val rawMessages = result?.messages
                            rawMessages?.forEach {
                                if (it.entry != null)
                                    messages.add(it.entry)
                            }

                            callback.onLoadedMessages(messages)
                        }else{
                            callback.onLoadedMessages(ArrayList())
                        }
                    }else{
                        callback.onLoadedMessages(ArrayList())
                    }
                }
            })
        }else{
            callback.onLoadedMessages(ArrayList())
        }
    }

    fun verifyClientConnectivity(){
        pubNub?.time()?.async(object : PNCallback<PNTimeResult>() {
            override fun onResponse(result: PNTimeResult?, status: PNStatus?) {

            }
        })
    }

    fun addSubscribeCallback(subscribeCallback: SubscribeCallback) {
        pubNub?.addListener(subscribeCallback)
    }

    fun removeSubscribeCallback(subscribeCallback: SubscribeCallback){
        pubNub?.removeListener(subscribeCallback)
    }

    fun destroy() {
        pubNub?.destroy()
    }

    interface PNControllerHistoryCallback{
        fun onLoadedMessages(messages: ArrayList<JsonElement>)
    }
}