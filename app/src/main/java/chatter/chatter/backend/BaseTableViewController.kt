package chatter.chatter.backend

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import chatter.chatter.ChatterAdapter
import chatter.chatter.R
import chatter.chatter.artifacts.BaseModel
import chatter.chatter.artifacts.models.Buddy
import chatter.chatter.artifacts.models.Divider
import chatter.chatter.artifacts.models.DividerTitle
import kotlinx.android.synthetic.main.recycler_view_controller.*
import java.util.*
import kotlin.collections.ArrayList

/**
 * Chatter
 *
 * Created by bedoy on 5/7/18.
 */
abstract class BaseTableViewController : BaseViewController(){

    private val dataModel : ArrayList<BaseModel> = ArrayList()
    private val keyDataModel : ArrayList<String> = ArrayList()
    var chatterAdapter : ChatterAdapter? = null

    init {
        chatterAdapter = ChatterAdapter(dataModel)
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.recycler_view_controller, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val layoutManager = LinearLayoutManager(context, LinearLayout.VERTICAL, false)

        recycler_view_controller_recycler_view.layoutManager = layoutManager
        recycler_view_controller_recycler_view.adapter = chatterAdapter
    }

    fun addElements(elements : ArrayList<BaseModel>){
        activity?.runOnUiThread {
            elements.forEach {
                if (!keyDataModel.contains(it.getId())){
                    keyDataModel.add(it.getId())

                    dataModel.add(it)

                    chatterAdapter?.notifyItemInserted(dataModel.indexOf(it))
                }else{
                    val indexOf = dataModel.indexOf(it)

                    dataModel[indexOf] = it

                    chatterAdapter?.notifyItemChanged(indexOf)
                }
            }
        }
    }

    fun categorizeElements(elements: ArrayList<BaseModel>) : ArrayList<BaseModel>{

        val result = ArrayList<BaseModel>()
        val directory = TreeMap<String, List<Buddy>>()
        var key = ""

        if (elements.isNotEmpty()) {
            val buddy = elements[0] as Buddy

            val nickname = buddy.nickname
            val charAt = nickname?.get(0)

            key = charAt.toString().toUpperCase()
        }

        for (element in elements) {

            val buddy = element as Buddy

            val valueOf = buddy.nickname?.get(0)?.toUpperCase().toString()

            if (key != valueOf)
                key = valueOf

            var users: MutableList<Buddy>? = directory[key]?.toMutableList()

            if (users == null) {
                users = ArrayList()
                users.add(buddy)
            } else {
                users.add(buddy)
            }

            directory[key] = users
        }

        result.add(Divider())
        directory.forEach {
            val dividerTitle = DividerTitle()
            dividerTitle.title = it.key

            result.add(dividerTitle)

            it.value.forEach {
                result.add(it)
            }
        }

        return result
    }
}