package chatter.chatter

import android.annotation.SuppressLint
import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.BaseAdapter
import android.widget.LinearLayout.VERTICAL
import android.widget.Toast
import chatter.chatter.artifacts.BaseModel
import chatter.chatter.artifacts.BaseViewHolder
import chatter.chatter.artifacts.models.*
import chatter.chatter.backend.BaseViewController
import chatter.chatter.backend.BuddiesViewController
import chatter.chatter.backend.ChannelsViewController
import chatter.chatter.core.PNController
import com.pubnub.api.PubNub
import kotlinx.android.synthetic.main.activity_main.*
import timber.log.Timber
import java.util.*
import android.hardware.usb.UsbDevice.getDeviceId
import android.content.Context.TELEPHONY_SERVICE
import android.provider.Settings
import android.telephony.TelephonyManager
import android.provider.Settings.Secure





class MainActivity : AppCompatActivity() {

    private val viewControllers = HashMap<String, BaseViewController>()

    @SuppressLint("HardwareIds")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        viewControllers["channels"] = ChannelsViewController()
        viewControllers["buddies"] = BuddiesViewController()

        val arrayList = ArrayList<BaseModel>()

        val header = Header()
        header.avatar = "https://scontent.fmex4-1.fna.fbcdn.net/v/t1.0-1/c4.0.320.320/p320x320/33748331_2486054888087528_1948593341838917632_n.jpg?_nc_cat=0&oh=d8c82668fefa54002a4299b2cdaab295&oe=5BC0B669"
        header.email = "carlos.bedoy@gmail.com"
        header.nickname = "#iambedoy"

        val androidId = Settings.Secure.getString(contentResolver, Settings.Secure.ANDROID_ID)

        val user = User()
        user.avatar = header.avatar
        user.nickname = "Carlos Bedoy"
        user.identifier = UUID.nameUUIDFromBytes(androidId?.toByteArray()).toString()


        PNController.registerUser(user)

        arrayList.add(header)

        var option = Option()

        option.title = getString(R.string.channels)
        option.resource = R.drawable.ic_action_channels
        option.listener = View.OnClickListener {
            if (viewControllers.containsKey("channels")){
                showViewController(viewControllers["channels"])
            }
        }
        arrayList.add(option)

        option = Option()
        option.title = getString(R.string.buddies)
        option.resource = R.drawable.ic_action_buddies
        option.listener = View.OnClickListener {
            if (viewControllers.containsKey("buddies")){
                showViewController(viewControllers["buddies"])
            }
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
            drawer_layout.closeDrawers()
        }
        arrayList.add(action)

        val adapter = ChatterAdapter(arrayList)

        val layoutManager = LinearLayoutManager(this, VERTICAL, false)

        navigation_drawer_recycler_view.adapter = adapter
        navigation_drawer_recycler_view.layoutManager = layoutManager
        navigation_drawer_recycler_view.setHasFixedSize(true)

        drawer_layout.addDrawerListener(object  : DrawerLayout.DrawerListener{
            override fun onDrawerStateChanged(newState: Int) {

            }

            override fun onDrawerSlide(drawerView: View, slideOffset: Float) {
                Timber.d("onDrawerSlide -> $slideOffset")
            }

            override fun onDrawerClosed(drawerView: View) {

            }

            override fun onDrawerOpened(drawerView: View) {

            }

        })

        if (viewControllers.containsKey("channels")){
            showViewController(viewControllers["channels"])
        }
    }

    private fun showViewController(viewController: BaseViewController?){

        if (viewController != null) {
            val fragmentTransaction = supportFragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.content_frame, viewController)
            fragmentTransaction.commit()
        }

        drawer_layout.closeDrawers()
    }
}
