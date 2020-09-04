package com.sample.itunessample.viewholder

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import com.sample.itunessample.R
import com.sample.itunessample.adapter.ItunesResultDataAdapter
import com.sample.itunessample.databinding.ItemItunesAlbumBinding
import com.sample.itunessample.model.ItunesDataItem
import com.squareup.picasso.Picasso

class SearchResultViewHolder(
    val inflater: ItemItunesAlbumBinding,
    val ctx: Context,
    val itemClickListener: ItunesResultDataAdapter.ItemClickListener
)
    :RecyclerView.ViewHolder(inflater.root) {


    fun addDataItem(dataItem:ItunesDataItem){

        Picasso.with(ctx).load(dataItem.artworkUrl100).fit().into(inflater.itemItunesAlbumImage)
        inflater.itemItunesAlbumArtistName.text=dataItem.artistName
        inflater.itemItunesAlbumTrackName.text=dataItem.trackName


        if(dataItem.isItemSelected) {
            inflater.itemItunesAlbumAddToCart.text = ctx.getString(R.string.remove_from_cart)
        }else
            inflater.itemItunesAlbumAddToCart.text=ctx.resources.getString(R.string.add_to_cart)

        inflater.itemItunesAlbumAddToCart.setOnClickListener { v ->
            dataItem.setIsSelected(!dataItem.isItemSelected)
            itemClickListener.onItemClick(inflater.root,dataItem)
        }
    }
}