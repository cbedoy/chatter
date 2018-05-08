package chatter.chatter.artifacts.models

import chatter.chatter.artifacts.BaseModel
import java.util.*

/**
 * Chatter
 *
 * Created by bedoy on 5/8/18.
 */
class Divider : BaseModel{
    override fun getType(): Int {
        return BaseModel.TYPE.DIVIDER.value
    }

    override fun getId(): String {
        return UUID.randomUUID().toString()
    }

}