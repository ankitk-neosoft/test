package com.example.mytest.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView
import com.example.mytest.databinding.ItemListViewBinding
import com.example.mytest.modal.SublistItems


class SubListAdapter(private var sublistItems: MutableList<SublistItems> ) :
    RecyclerView.Adapter<SubListAdapter.HomeViewHolder>(),
    Filterable {
    private lateinit var context: Context
    private var filteredImages: MutableList<SublistItems> =
        mutableListOf<SublistItems>().apply {
            addAll(sublistItems)
        }

    inner class HomeViewHolder(private val binding: ItemListViewBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: SublistItems) {
            binding.tvItemName.text = data.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        context = parent.context
        val inflater = LayoutInflater.from(context)
        val binding = ItemListViewBinding.inflate(inflater, parent, false)
        return HomeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.bind(filteredImages[position])
    }

    override fun getItemCount(): Int = filteredImages.size

    override fun getFilter(): Filter = FilterData()


    inner class FilterData : Filter() {
        override fun performFiltering(constraint: CharSequence?): FilterResults {

            filteredImages = if (constraint == null || constraint.isEmpty()) {
                sublistItems
            } else {
                val newList = mutableListOf<SublistItems>()
                sublistItems.filter {
                    it.name.lowercase().contains(constraint.toString().lowercase())
                }.forEach {
                    newList.add(it)
                }
                newList
            }

            return FilterResults().apply { values = filteredImages }
        }

        override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
            filteredImages =
                if (results?.values == null) mutableListOf() else results.values as MutableList<SublistItems>
            notifyDataSetChanged()
        }
    }

    fun updateList(newImages: MutableList<SublistItems>) {
        sublistItems.clear()
        filteredImages.clear()
        sublistItems.addAll(newImages)
        filteredImages.addAll(sublistItems)
        notifyDataSetChanged()
    }
}