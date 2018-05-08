package chatter.chatter.artifacts.holders

import android.view.View
import chatter.chatter.artifacts.BaseModel
import chatter.chatter.artifacts.BaseViewHolder
import chatter.chatter.artifacts.models.Action
import kotlinx.android.synthetic.main.action_holder.*

/**
 * Chatter
 *
 * Created by bedoy on 5/7/18.
 */
class ActionHolder(override val containerView: View?) : BaseViewHolder(containerView) {

    override fun reloadData(model: BaseModel) {

        model as Action

        action_holder_button.setOnClickListener(model.listener)

        if(model.backgroundColor != null)
            action_holder_button.setBackgroundColor(model.backgroundColor!!)

        if(model.textColor != null)
            action_holder_button.setTextColor(model.textColor!!)

        if (model.title != null)
            action_holder_button.setText(model.title!!)

    }
}