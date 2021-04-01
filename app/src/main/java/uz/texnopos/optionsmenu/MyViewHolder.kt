package uz.texnopos.optionsmenu

import android.app.Activity
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item.view.*

class MyViewHolder(itemView: View, private val onItemClick: (model: Model) -> Unit, private val activity: MainActivity) : RecyclerView.ViewHolder(itemView) {
    fun populateModel(model: Model) {
        itemView.tvTitle.text = model.title

        itemView.setOnClickListener {
            onItemClick.invoke(model)
        }

        itemView.optionsMenu.setOnClickListener {
            activity.onMenuItemClick(itemView.optionsMenu, model)
        }
    }
}