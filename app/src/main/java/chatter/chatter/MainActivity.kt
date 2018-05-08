package chatter.chatter

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.BaseAdapter
import android.widget.LinearLayout.VERTICAL
import android.widget.Toast
import chatter.chatter.artifacts.BaseModel
import chatter.chatter.artifacts.BaseViewHolder
import chatter.chatter.artifacts.models.Action
import chatter.chatter.artifacts.models.Channel
import chatter.chatter.artifacts.models.Header
import chatter.chatter.artifacts.models.Option
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val arrayList = ArrayList<BaseModel>()

        /*
        var channel = Channel()
        channel.avatar = "https://ae01.alicdn.com/kf/HTB1mB2BQFXXXXcfXVXXq6xXFXXX8/Full-Swimsuit-Stripe-Open-Hot-Sexy-Girl-Swimwear-Summer-Biki-M17072.jpg_640x640.jpg"
        channel.name = "Sexy girls"
        channel.lastMessage = "Traje de baño completo abierto caliente sexy chica traje de baño verano biki m17072"
        arrayList.add(channel)

        channel = Channel()
        channel.avatar = "http://infinigeek.com/assets/Looking-to-teh-future-of-gamming-1-680x453.jpg?x17756"
        channel.name = "Gaming"
        arrayList.add(channel)

        channel = Channel()
        channel.avatar = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRHg35FcS4RI8O_lckszIJ_D-Vis6FyaKV8rKW857NhtOC7Pk5x"
        channel.name = "Xiami"
        arrayList.add(channel)

        */

        val header = Header()
        header.avatar = "https://scontent.fntr2-1.fna.fbcdn.net/v/t1.0-1/p480x480/31947993_2450363504990000_8814635117579337728_n.jpg?_nc_cat=0&oh=fab6659e1faad208e444175fc2a8ecd7&oe=5B5ABE92"
        header.email = "carlos.bedoy@gmail.com"
        header.nickname = "#iambedoy"
        arrayList.add(header)

        var option = Option()

        option.title = getString(R.string.channels)
        option.resource = R.drawable.ic_action_channels
        option.listener = View.OnClickListener {

        }
        arrayList.add(option)

        option = Option()
        option.title = getString(R.string.buddies)
        option.resource = R.drawable.ic_action_buddies
        option.listener = View.OnClickListener {

        }
        arrayList.add(option)

        option = Option()
        option.title = getString(R.string.settings)
        option.resource = R.drawable.ic_action_settings
        option.listener = View.OnClickListener {

        }
        arrayList.add(option)


        val action = Action()
        action.title = R.string.logout
        action.backgroundColor = ContextCompat.getColor(this, android.R.color.transparent)
        action.textColor = ContextCompat.getColor(this, R.color.colorAccent)
        action.listener = View.OnClickListener {
            Toast.makeText(this, "Hey", Toast.LENGTH_LONG).show()
        }
        arrayList.add(action)

        val adapter = ChatterAdapter(arrayList)

        val layoutManager = LinearLayoutManager(this, VERTICAL, false)

        navigation_drawer_recycler_view.adapter = adapter
        navigation_drawer_recycler_view.layoutManager = layoutManager
        navigation_drawer_recycler_view.setHasFixedSize(true)

    }
}
