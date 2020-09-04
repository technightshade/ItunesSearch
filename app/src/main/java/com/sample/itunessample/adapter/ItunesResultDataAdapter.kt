package com.sample.itunessample.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sample.itunessample.viewholder.SearchResultViewHolder
import com.sample.itunessample.databinding.ItemItunesAlbumBinding
import com.sample.itunessample.model.ItunesDataItem

class ItunesResultDataAdapter(ctx: Context,val itemClickListener: ItemClickListener):
    RecyclerView.Adapter<SearchResultViewHolder>() {

    private val mContext=ctx

    private lateinit var mDataList:List<ItunesDataItem>

    fun updateDataList(newDataList:List<ItunesDataItem>){
        mDataList=newDataList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchResultViewHolder {
        return SearchResultViewHolder(ItemItunesAlbumBinding.
        inflate(LayoutInflater.from(parent.context), parent, false)
            ,mContext,itemClickListener)
    }

    override fun onBindViewHolder(holder: SearchResultViewHolder, position: Int) {
        holder.addDataItem(mDataList.get(position))
    }

    override fun getItemCount(): Int {
        return mDataList.size
    }


    interface ItemClickListener {
        fun onItemClick(view: View, dataItem:ItunesDataItem)
    }
}