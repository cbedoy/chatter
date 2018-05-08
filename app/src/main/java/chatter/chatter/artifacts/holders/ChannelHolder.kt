package chatter.chatter.artifacts.holders

import android.view.View
import chatter.chatter.artifacts.BaseModel
import chatter.chatter.artifacts.BaseViewHolder
import chatter.chatter.artifacts.models.Channel
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.channel_holder.*

/**
 * Chatter
 *
 * Created by bedoy on 5/7/18.
 */
class ChannelHolder(override val containerView: View?) : BaseViewHolder(containerView) {
    override fun reloadData(model: BaseModel) {
        model as Channel

        Glide.with(itemView?.context).load(model.avatar).into(channel_holder_avatar)

        channel_holder_title.text = model.name
        channel_holder_description.text = if (model.lastMessage == null) "No messages..." else model.lastMessage
    }
}