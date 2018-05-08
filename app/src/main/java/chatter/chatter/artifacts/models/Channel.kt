package chatter.chatter.artifacts.models

import android.view.View
import chatter.chatter.artifacts.BaseModel
import java.util.*

/**
 * Chatter
 *
 * Created by bedoy on 5/7/18.
 */
class Channel : BaseModel{

    var identifier : String? = null
    var name : String? = null
    var lastMessage : String? = null
    var listener : View.OnClickListener? = null
    var avatar : String? = null

    override fun getType(): Int {
        return BaseModel.TYPE.CHANNEL.value
    }

    override fun getId(): String {
        if (identifier == null){
            return UUID.nameUUIDFromBytes(name!!.toByteArray()).toString()
        }
        return identifier as String
    }
}