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
import kotlinx.android.synthetic.main.recycler_view_controller.*

/**
 * Chatter
 *
 * Created by bedoy on 5/7/18.
 */
abstract class BaseTableViewController : BaseViewController(){

    private val dataModel : ArrayList<BaseModel> = ArrayList()
    private val keyDataModel : ArrayList<String> = ArrayList()
    private var chatterAdapter : ChatterAdapter? = null

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
}