package chatter.chatter.artifacts.holders

import android.view.View
import chatter.chatter.artifacts.BaseModel
import chatter.chatter.artifacts.BaseViewHolder
import chatter.chatter.artifacts.models.Header
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.header_holder.*

/**
 * Chatter
 *
 * Created by bedoy on 5/7/18.
 */
class HeaderHolder(override val containerView: View?) : BaseViewHolder(containerView) {
    override fun reloadData(model: BaseModel) {

        model as Header

        header_holder_nickname.text = model.nickname
        header_holder_email.text = model.email

        Glide.with(containerView?.context).load(model.avatar).into(header_holder_avatar)
    }

}