package chatter.chatter.artifacts.models

import chatter.chatter.artifacts.BaseModel

/**
 * Chatter
 *
 * Created by bedoy on 5/7/18.
 */
class Header : BaseModel{

    var identifier : String? = null
    var avatar : String? = null
    var nickname : String? = null
    var email : String? = null

    override fun getType(): Int {
        return BaseModel.TYPE.HEADER.value
    }

    override fun getId(): String {
        if (identifier == null){
            throw Exception("Identifier can't be null")
        }
        return identifier as String
    }

}