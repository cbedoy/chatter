package chatter.chatter.artifacts.models

import android.view.View
import chatter.chatter.artifacts.BaseModel

/**
 * Chatter
 *
 * Created by bedoy on 5/7/18.
 */
class Action : BaseModel{

    var identifier : String? = null
    var title : Int? = null
    var backgroundColor : Int? = null
    var textColor : Int? = null
    var listener : View.OnClickListener? = null

    override fun getType(): Int {
        return BaseModel.TYPE.ACTION.value
    }
}