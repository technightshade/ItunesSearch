package com.sample.itunessample.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.ViewModelProviders
import com.sample.itunessample.R
import com.sample.itunessample.viewmodel.ItunesDataViewModel


class MainActivity : AppCompatActivity() {

    lateinit var iTunesSearchViewModel: ItunesDataViewModel



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        iTunesSearchViewModel=ViewModelProviders.of(this).get(ItunesDataViewModel::class.java)
        iTunesSearchViewModel.readDataFromJson(assets.open("1.txt"))


        val transaction: FragmentTransaction=supportFragmentManager.beginTransaction()
        transaction.add(R.id.fragmentHolder,
            AlbumFragment.newInstance(), "Album Fragment")
        transaction.addToBackStack(null)
        transaction.commit()
    }





}