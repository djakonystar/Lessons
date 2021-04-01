package uz.texnopos.optionsmenu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.PopupMenu
import androidx.recyclerview.widget.DividerItemDecoration
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val models = mutableListOf<Model>()
    private val stateModels = mutableListOf<Model>()
    private val adapter = MyAdapter(this)
    private var addItemFrom = models.size

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView.adapter = adapter
        recyclerView.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        setData(0, 1)
    }

    private fun setData(size: Int, count: Int) {
        for (i in size + 1 .. size + count) {
            models.add(Model("Item Number: $i"))
            stateModels.add(Model("Item Number: $i"))
        }
        adapter.models = models
    }

    private fun onItemClick(size: Int, count: Int) {
        setData(size, count)
    }

    fun onMenuItemClick(view: View, model: Model) {
        val optionsMenu = PopupMenu(this, view)
        val menuInflater = optionsMenu.menuInflater
        menuInflater.inflate(R.menu.menu_options_item, optionsMenu.menu)
        optionsMenu.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.add -> {
                    val count = stateModels.indexOf(model) + 1
                    onItemClick(stateModels.size, count)
                }

                R.id.delete -> {
                    val index = models.indexOf(model)
                    models.removeAt(index)
                    adapter.notifyItemRemoved(index)
                }
            }
            return@setOnMenuItemClickListener true
        }
        optionsMenu.show()
    }
}