package chatter.chatter.artifacts.holders

import android.view.View
import chatter.chatter.artifacts.BaseModel
import chatter.chatter.artifacts.BaseViewHolder
import chatter.chatter.artifacts.models.ChatMessage
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.chat_message_view.*

/**
 * Chatter
 *
 * Created by bedoy on 6/7/18.
 */
class ChatMessageHolder(override val containerView: View?) : BaseViewHolder(containerView){
    override fun reloadData(model: BaseModel) {
        model as ChatMessage

        Glide.with(containerView?.context).load(model.avatar).into(chat_message_avatar)
        chat_message_description.text = model.message
        chat_message_title.text = model.nickname
        if (model.nickname != null)
            chat_message_online.visibility = if(model.nickname!![0].toInt() % 2 == 0 ) View.VISIBLE  else View.INVISIBLE
        else {
            chat_message_online.visibility = View.INVISIBLE
            chat_message_title.text = "No name"
        }
    }
}