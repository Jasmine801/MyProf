package com.mamedli.myprof.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.mamedli.myprof.R
import com.mamedli.myprof.databinding.PublicationListItemBinding
import com.mamedli.myprof.entities.PublicationsItem

class PublicationsAdapter : ListAdapter<PublicationsItem, PublicationsAdapter.ItemHolder>(ItemComparator()) {

    class ItemHolder(view: View) : RecyclerView.ViewHolder(view){
        private var binding = PublicationListItemBinding.bind(view)

        fun setData(publicationItem: PublicationsItem) = with(binding){
            tvTitle.text = publicationItem.title
            tvDescription.text = publicationItem.description
        }

        companion object{
            fun create(parent: ViewGroup) : ItemHolder{
                return ItemHolder(
                    LayoutInflater.from(parent.context)
                        .inflate(R.layout.publication_list_item, parent, false))
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        return ItemHolder.create(parent)
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        holder.setData(getItem(position))
    }


    class ItemComparator() : DiffUtil.ItemCallback<PublicationsItem>(){
        override fun areItemsTheSame(
            oldItem: PublicationsItem,
            newItem: PublicationsItem
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: PublicationsItem,
            newItem: PublicationsItem
        ): Boolean {
            return oldItem == newItem
        }

    }
}