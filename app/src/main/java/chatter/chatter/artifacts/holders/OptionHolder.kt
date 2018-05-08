package chatter.chatter.artifacts.holders

import android.view.View
import chatter.chatter.artifacts.BaseModel
import chatter.chatter.artifacts.BaseViewHolder
import chatter.chatter.artifacts.models.Option
import kotlinx.android.synthetic.main.option_holder.*

/**
 * Chatter
 *
 * Created by bedoy on 5/7/18.
 */
class OptionHolder(override val containerView: View?) : BaseViewHolder(containerView) {
    override fun reloadData(model: BaseModel) {
        model as Option

        option_holder_title.text = model.title

        if (model.resource != null){
            option_holder_resource.setImageResource(model.resource!!)
        }

    }
}