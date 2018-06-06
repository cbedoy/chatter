package chatter.chatter.backend

import android.os.Bundle
import android.view.View
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
        channel.avatar = "https://fa707ec5abab9620c91c-e087a9513984a31bae18dd7ef8b1f502.ssl.cf1.rackcdn.com/19886625_jailbait-the-appeal-of-barely-legal_t3379742e.jpg"
        channel.name = "Having fun here!"
        channel.identifier = UUID.nameUUIDFromBytes(channel.name?.toByteArray()).toString()
        elements.add(channel)
        elements.add(Divider())

        channel = Channel()
        channel.avatar = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR1luOKyA4g-aupZ5Hz_g-gVsIuTabHoK9QKi5uBGXQt8rFoFqI2A"
        channel.name = "One more rep"
        channel.lastMessage = "Do something today that your future self will thank you for \uD83D\uDCAA"
        channel.identifier = UUID.nameUUIDFromBytes(channel.name?.toByteArray()).toString()
        elements.add(channel)
        elements.add(Divider())

        channel = Channel()
        channel.avatar = "https://www.kopatech.com/images/mobile/android-app-development.png"
        channel.name = "Mobile Development"
        channel.identifier = UUID.nameUUIDFromBytes(channel.name?.toByteArray()).toString()
        elements.add(channel)
        elements.add(Divider())

        channel = Channel()
        channel.avatar = "http://www.peency.com/images/2015/08/11/fitness-girl-body.jpg"
        channel.name = "Fitness Life"
        channel.identifier = UUID.nameUUIDFromBytes(channel.name?.toByteArray()).toString()
        elements.add(channel)
        elements.add(Divider())

        dividerTitle = DividerTitle()
        dividerTitle.title = "Channels"
        elements.add(dividerTitle)

        channel = Channel()
        channel.avatar = "https://centrestage.org/wp-content/uploads/2016/03/2ffd0ae4-4d21-4aef-9186-de97ca38af0c.jpg"
        channel.name = "Underoath & cool stuff"
        channel.identifier = UUID.nameUUIDFromBytes(channel.name?.toByteArray()).toString()
        elements.add(channel)
        elements.add(Divider())

        channel = Channel()
        channel.avatar = "http://media-room5.trivago.com/wp-content/uploads/2017/11/14082328/hotel-rancho-encantado-laguna-bacalar.jpg"
        channel.name = "Bacall M4gic place"
        channel.lastMessage = "Población del escudo mexican de Quintana Roo, situada en el sur de su territories a unis 40 km al north de la capital, Chessman."
        channel.identifier = UUID.nameUUIDFromBytes(channel.name?.toByteArray()).toString()
        elements.add(channel)
        elements.add(Divider())

        addElements(elements)

        chatterAdapter?.chatterAdapterListener = object : ChatterAdapter.ChatterAdapterListener{
            override fun onClickElement(element: BaseModel) {
                if (element::class.java == Channel::class.java){
                    element as Channel

                    PNController.subscribeToChannel(element.identifier)
                }
            }
        }
    }
}