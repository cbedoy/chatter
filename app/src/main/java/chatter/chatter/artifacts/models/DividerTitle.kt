package chatter.chatter.artifacts.models

import chatter.chatter.artifacts.BaseModel
import java.util.*

/**
 * Chatter
 *
 * Created by bedoy on 6/6/18.
 */
class DividerTitle: BaseModel {
    var title : String? = null

    override fun getType(): Int {
        return BaseModel.TYPE.DIVIDER_TITLE.value
    }

    override fun getId(): String {
        return UUID.randomUUID().toString()
    }



}