package chatter.chatter.artifacts.models

import chatter.chatter.artifacts.BaseModel
import java.util.*

/**
 * Chatter
 *
 * Created by bedoy on 6/7/18.
 */
class ChatMessage : BaseModel {

    var identifier : String? = null
    var message : String? = null
    var nickname : String? = null
    var from : String? = null
    var avatar : String? = null
    var date : String? = null

    override fun getType(): Int {
        return BaseModel.TYPE.MESSAGE.value
    }

    override fun getId(): String {
        return identifier!!
    }

}