package chatter.chatter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import chatter.chatter.artifacts.BaseModel
import chatter.chatter.artifacts.BaseViewHolder
import chatter.chatter.artifacts.holders.ActionHolder
import chatter.chatter.artifacts.holders.BuddyHolder
import chatter.chatter.artifacts.holders.ChannelHolder

/**
 * Chatter
 *
 * Created by bedoy on 5/7/18.
 */
class ChatterAdapter(private val dataModel: ArrayList<BaseModel>) : RecyclerView.Adapter<BaseViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return when (viewType) {
            BaseModel.TYPE.ACTION.value -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.action_holder, parent, false)

                ActionHolder(view)
            }
            BaseModel.TYPE.CHANNEL.value -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.channel_holder, parent, false)

                ChannelHolder(view)
            }
            BaseModel.TYPE.BUDDY.value -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.buddy_holder, parent, false)

                BuddyHolder(view)
            }
            else -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.action_holder, parent, false)

                ActionHolder(view)
            }
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