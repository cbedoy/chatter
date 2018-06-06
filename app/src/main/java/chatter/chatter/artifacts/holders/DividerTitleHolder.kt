package chatter.chatter.artifacts.holders

import android.view.View
import chatter.chatter.artifacts.BaseModel
import chatter.chatter.artifacts.BaseViewHolder
import chatter.chatter.artifacts.models.DividerTitle
import kotlinx.android.synthetic.main.divider_title_holder.*

/**
 * Chatter
 *
 * Created by bedoy on 6/6/18.
 */
class DividerTitleHolder(override val containerView: View?) : BaseViewHolder(containerView) {
    override fun reloadData(model: BaseModel) {
        model as DividerTitle

        divider_title_title_view.text = model.title
    }
}