package chatter.chatter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import chatter.chatter.artifacts.BaseModel
import chatter.chatter.artifacts.BaseViewHolder

/**
 * Chatter
 *
 * Created by bedoy on 5/7/18.
 */
class ChatterAdapter(private val dataModel: ArrayList<BaseModel>) : RecyclerView.Adapter<BaseViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        if (viewType == BaseModel.TYPE.ACTION.value){
            val view = LayoutInflater.from(parent.context).inflate(R.layout.action_holder, parent, false)

            Action
        }
    }

    override fun getItemCount(): Int {
        return dataModel.size
    }

    override fun getItemViewType(position: Int): Int {
        return dataModel[position].getType()
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        holder.reloadData(dataModel[position])
    }

}