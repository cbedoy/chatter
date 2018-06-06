package chatter.chatter.artifacts.models

import chatter.chatter.artifacts.BaseModel

/**
 * Chatter
 *
 * Created by bedoy on 5/8/18.
 */
class Message : BaseModel{

    private var identifier : String? = null
    private var content : String? = null

    override fun getType(): Int {
        return BaseModel.TYPE.MESSAGE.value
    }

    override fun getId(): String {
        return identifier.toString()
    }

}