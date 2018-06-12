package chatter.chatter.backend

import android.os.Bundle
import android.view.View
import chatter.chatter.ChatterAdapter
import chatter.chatter.artifacts.BaseModel
import chatter.chatter.artifacts.models.Buddy
import chatter.chatter.utils.BuddiesProvider
import java.util.*

/**
 * Chatter
 *
 * Created by bedoy on 5/7/18.
 */
class BuddiesViewController: BaseTableViewController() {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val elements = ArrayList<BaseModel>()

        elements.addAll(BuddiesProvider.fakeBuddies())

        val categorizedElements = categorizeElements(elements)

        addElements(categorizedElements)

        chatterAdapter?.chatterAdapterListener = object : ChatterAdapter.ChatterAdapterListener{
            override fun onClickElement(element: BaseModel) {

            }
        }
    }
}