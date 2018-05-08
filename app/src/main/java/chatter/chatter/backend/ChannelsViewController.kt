package chatter.chatter.backend

import android.os.Bundle
import android.view.View
import chatter.chatter.artifacts.BaseModel
import chatter.chatter.artifacts.models.Channel
import chatter.chatter.artifacts.models.Divider

/**
 * Chatter
 *
 * Created by bedoy on 5/7/18.
 */
class ChannelsViewController : BaseTableViewController() {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val elements = ArrayList<BaseModel>()

        var channel = Channel()
        channel.avatar = "https://fa707ec5abab9620c91c-e087a9513984a31bae18dd7ef8b1f502.ssl.cf1.rackcdn.com/19886625_jailbait-the-appeal-of-barely-legal_t3379742e.jpg"
        channel.name = "Jailbait: The Appeal of Barely Legal Teen Porn"
        channel.lastMessage = "Porn sites are like a buffet, if you expect your buffet to be dripping in jizz that is. There are millions and millions of clips uploaded every year in all kinds of categories--from hentai to threesomes, and everything in between. "
        elements.add(channel)
        elements.add(Divider())

        channel = Channel()
        channel.avatar = "http://assets.rebelcircus.com/blog/wp-content/uploads/2018/04/3123.jpg"
        channel.name = "Exploring the World of S&M for Feminists: One Woman’s Journey to Be Both a Dominatrix and a Feminist"
        channel.lastMessage = "It can be difficult to find someone you really like with compatible kinks, so enjoy it"
        elements.add(channel)
        elements.add(Divider())

        channel = Channel()
        channel.avatar = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRHg35FcS4RI8O_lckszIJ_D-Vis6FyaKV8rKW857NhtOC7Pk5x"
        channel.name = "Xiami"
        elements.add(channel)
        elements.add(Divider())

        addElements(elements)
    }
}