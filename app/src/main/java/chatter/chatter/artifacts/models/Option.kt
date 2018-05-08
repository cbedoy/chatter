package chatter.chatter.artifacts.models

import android.view.View
import chatter.chatter.artifacts.BaseModel

/**
 * Chatter
 *
 * Created by bedoy on 5/7/18.
 */
class Option : BaseModel{
    override fun getType(): Int {
        return BaseModel.TYPE.OPTION.value
    }

    var title : String? = null
    var listener : View.OnClickListener? = null
    var resource : Int? = null

    override fun getId(): String {
        if (resource == null){
            throw Exception("Identifier can't be null")
        }
        return resource as String
    }
}