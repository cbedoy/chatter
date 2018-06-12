package chatter.chatter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import chatter.chatter.artifacts.BaseModel
import chatter.chatter.artifacts.BaseViewHolder
import chatter.chatter.artifacts.holders.*

/**
 * Chatter
 *
 * Created by bedoy on 5/7/18.
 */
class ChatterAdapter(private val dataModel: ArrayList<BaseModel>) : RecyclerView.Adapter<BaseViewHolder>() {

    var chatterAdapterListener : ChatterAdapterListener ? = null

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
            BaseModel.TYPE.OPTION.value -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.option_holder, parent, false)

                OptionHolder(view)
            }
            BaseModel.TYPE.HEADER.value -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.header_holder, parent, false)

                HeaderHolder(view)
            }
            BaseModel.TYPE.DIVIDER.value -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.divider_holder, parent, false)

                DividerHolder(view)
            }
            BaseModel.TYPE.DIVIDER_TITLE.value -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.divider_title_holder, parent, false)

                DividerTitleHolder(view)
            }
            BaseModel.TYPE.MESSAGE.value -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.chat_message_view, parent, false)

                ChatMessageHolder(view)
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

        holder.itemView.setOnClickListener {
            chatterAdapterListener?.onClickElement(dataModel[position])
        }
    }

    interface ChatterAdapterListener{
        fun onClickElement(element : BaseModel)
    }

}