package chatter.chatter.artifacts.models

import chatter.chatter.artifacts.BaseModel

/**
 * Chatter
 *
 * Created by bedoy on 5/7/18.
 */
class Header : BaseModel{

    var avatar : String? = null
    var nickname : String? = null
    var email : String? = null

    override fun getType(): Int {
        return BaseModel.TYPE.HEADER.value
    }

}