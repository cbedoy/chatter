package chatter.chatter.artifacts.holders

import android.view.View
import chatter.chatter.artifacts.BaseModel
import chatter.chatter.artifacts.BaseViewHolder
import chatter.chatter.artifacts.models.Buddy
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.buddy_holder.*

/**
 * Chatter
 *
 * Created by bedoy on 5/7/18.
 */
class BuddyHolder(override val containerView: View?) : BaseViewHolder(containerView) {
    override fun reloadData(model: BaseModel) {
        model as Buddy

        Glide.with(itemView?.context).load(model.avatar).into(buddy_holder_avatar)

        buddy_holder_title.text = model.nickname
        buddy_holder_online.visibility = if(model.online) View.VISIBLE else View.INVISIBLE
    }
}