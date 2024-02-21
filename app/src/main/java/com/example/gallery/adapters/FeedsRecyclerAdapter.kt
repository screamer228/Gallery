package com.example.gallery.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.gallery.databinding.ItemFeedsBinding

class FeedsRecyclerAdapter(private val dataList: List<String>)
    : RecyclerView.Adapter<FeedsRecyclerAdapter.ViewHolder>() {

    class ViewHolder(
        private val binding: ItemFeedsBinding,
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: String) {
            binding.itemFeedsImage.load(item)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemFeedsBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = dataList[position]
        holder.bind(item)
    }
    override fun getItemCount(): Int {
        return dataList.size
    }

//    fun updateList(charactersList: List<CharacterResultEntity>){
//        dataList = charactersList.toMutableList()
//        notifyDataSetChanged()
//    }
}