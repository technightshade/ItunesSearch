package com.sample.itunessample.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sample.itunessample.databinding.ItemItunesAlbumBinding
import com.sample.itunessample.model.ItunesDataItem
import com.sample.itunessample.viewholder.CartViewHolder
import com.sample.itunessample.viewholder.SearchResultViewHolder

class CartSummaryAdapter(val ctx:Context): RecyclerView.Adapter<CartViewHolder>()  {

    private val mContext=ctx

    private lateinit var mDataList:List<ItunesDataItem>

    fun updateDataList(newDataList:List<ItunesDataItem>){
        mDataList=newDataList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        return CartViewHolder(
            ItemItunesAlbumBinding.
        inflate(LayoutInflater.from(parent.context), parent, false)
            ,mContext)
    }

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        holder.addDataItem(mDataList.get(position))
    }

    override fun getItemCount(): Int {
        return mDataList.size
    }
}