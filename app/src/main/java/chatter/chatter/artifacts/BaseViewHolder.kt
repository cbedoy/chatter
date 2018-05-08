package chatter.chatter.artifacts

import android.support.v7.view.menu.ActionMenuItemView
import android.support.v7.widget.RecyclerView
import android.view.View
import kotlinx.android.extensions.LayoutContainer

/**
 * Chatter
 *
 * Created by bedoy on 5/7/18.
 */
abstract class BaseViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView), LayoutContainer {
    abstract fun reloadData(model : BaseModel)
}