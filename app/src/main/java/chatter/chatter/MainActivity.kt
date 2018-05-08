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
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val arrayList = ArrayList<BaseModel>()

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
