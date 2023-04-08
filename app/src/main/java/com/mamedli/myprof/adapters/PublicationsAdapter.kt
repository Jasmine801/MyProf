package com.mamedli.myprof.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*
import com.google.firebase.database.ktx.getValue
import com.mamedli.myprof.R
import com.mamedli.myprof.databinding.PublicationListItemBinding
import com.mamedli.myprof.entities.PublicationsItem

class PublicationsAdapter(private val publicationList: ArrayList<PublicationsItem>) :
    RecyclerView.Adapter<PublicationsAdapter.ItemHolder>() {


    class ItemHolder(view: View) : RecyclerView.ViewHolder(view){
        private var binding = PublicationListItemBinding.bind(view)

        fun setData(publicationItem: PublicationsItem?) = with(binding){
            tvTitle.text = publicationItem?.title
            tvDescription.text = publicationItem?.description
            tvCommentCount.text = publicationItem?.allCommentCount
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

        holder.setData(publicationList[position])

    }


    override fun getItemCount(): Int {
        return publicationList.size
    }
}