package chatter.chatter.backend

import android.content.Intent
import android.os.Bundle
import android.view.View
import chatter.chatter.ChatActivity
import chatter.chatter.ChatterAdapter
import chatter.chatter.artifacts.BaseModel
import chatter.chatter.artifacts.models.Channel
import chatter.chatter.artifacts.models.Divider
import chatter.chatter.artifacts.models.DividerTitle
import chatter.chatter.core.PNController
import kotlinx.android.synthetic.main.recycler_view_controller.*
import java.util.*
import java.util.UUID.nameUUIDFromBytes



/**
 * Chatter
 *
 * Created by bedoy on 5/7/18.
 */
class ChannelsViewController : BaseTableViewController() {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val elements = ArrayList<BaseModel>()

        var dividerTitle = DividerTitle()
        dividerTitle.title = "Favorite Channels"
        elements.add(dividerTitle)

        var channel = Channel()
        channel.avatar = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSW8BTg3EbOhd-73dN59-KppA23tsFHRNflrJeKxFwiW5b2X87e"
        channel.name = "Testing"
        channel.identifier = UUID.nameUUIDFromBytes(channel.name?.toByteArray()).toString()
        elements.add(channel)
        elements.add(Divider())

        dividerTitle = DividerTitle()
        dividerTitle.title = "Channels"
        elements.add(dividerTitle)


        addElements(elements)

        chatterAdapter?.chatterAdapterListener = object : ChatterAdapter.ChatterAdapterListener{
            override fun onClickElement(element: BaseModel) {

                if (element::class.java == Channel::class.java) {
                    element as Channel

                    val intent = Intent(context, ChatActivity::class.java)
                    intent.putExtra("channel_avatar", element.avatar)
                    intent.putExtra("channel_name", element.name)
                    intent.putExtra("channel_identifier", element.identifier)
                    activity?.startActivity(intent)
                }
            }
        }
    }
}