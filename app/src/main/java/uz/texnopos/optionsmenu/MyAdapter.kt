package uz.texnopos.optionsmenu

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(private val activity: MainActivity) : RecyclerView.Adapter<MyViewHolder>() {
    var models = listOf<Model>()
    set(value) {
        field = value
        notifyDataSetChanged()
    }

    private var onItemClick : (model: Model) -> Unit = {}

    fun setOnItemClickListener(onItemClick: (model: Model) -> Unit) {
        this.onItemClick = onItemClick
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView: View = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return MyViewHolder(itemView, onItemClick, activity)
    }

    override fun getItemCount() = models.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.populateModel(models[position])
    }


}