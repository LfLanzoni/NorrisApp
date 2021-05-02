package ar.android.lflanzoni.norrisapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ar.android.lflanzoni.norrisapp.databinding.RowCategoryBinding
import java.util.*

class RvAdapter(private val categories: ArrayList<String>,private var listener: OnCategoryClickListener) : RecyclerView.Adapter<RvAdapter.RvViewHolder?>() {

    interface OnCategoryClickListener {
        fun onCategoryClick(category: String)
    }

    override fun onCreateViewHolder(parent: ViewGroup, i: Int): RvViewHolder {
       val binding = RowCategoryBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        val holder = RvViewHolder(binding)
        binding.root.setOnClickListener {
            val position = holder.adapterPosition
            listener.onCategoryClick(categories[position])
        }
        return holder
    }

    override fun onBindViewHolder(rvViewHolder: RvViewHolder, i: Int) {
        rvViewHolder.bind(categories[i])
    }

    override fun getItemCount(): Int = categories.size

    class RvViewHolder(private val binding: RowCategoryBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(item: String){
            binding.tvCategory.text = item
        }
    }
}