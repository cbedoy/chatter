package chatter.chatter.artifacts.models

import android.view.View
import chatter.chatter.artifacts.BaseModel

/**
 * Chatter
 *
 * Created by bedoy on 5/7/18.
 */
class Buddy : BaseModel {


    var identifier: String? = null
    var nickname: String? = null
    var textColor: Int? = null
    var listener: View.OnClickListener? = null
    var avatar: String? = null
    var online : Boolean = false

    override fun getType(): Int {
        return BaseModel.TYPE.BUDDY.value
    }

    override fun getId(): String {
        if (identifier == null){
            throw Exception("Identifier can't be null")
        }
        return identifier as String
    }
}