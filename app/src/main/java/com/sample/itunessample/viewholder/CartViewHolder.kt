package com.sample.itunessample.viewholder

import android.content.Context
import android.view.View
import android.view.View.GONE
import androidx.recyclerview.widget.RecyclerView
import com.sample.itunessample.R
import com.sample.itunessample.databinding.ItemItunesAlbumBinding
import com.sample.itunessample.model.ItunesDataItem
import com.squareup.picasso.Picasso

class CartViewHolder(val inflater: ItemItunesAlbumBinding,val ctx: Context): RecyclerView.ViewHolder(inflater.root) {

    fun addDataItem(dataItem: ItunesDataItem){

        Picasso.with(ctx).load(dataItem.artworkUrl100).fit().into(inflater.itemItunesAlbumImage)
        inflater.itemItunesAlbumArtistName.text=dataItem.artistName
        inflater.itemItunesAlbumTrackName.text=dataItem.trackName


        inflater.itemItunesAlbumAddToCart.visibility=GONE
    }

}