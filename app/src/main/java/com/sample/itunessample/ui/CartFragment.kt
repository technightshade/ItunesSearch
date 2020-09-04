package com.sample.itunessample.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.sample.itunessample.R
import com.sample.itunessample.adapter.CartSummaryAdapter
import com.sample.itunessample.adapter.ItunesResultDataAdapter
import com.sample.itunessample.databinding.FragmentAlbumBinding
import com.sample.itunessample.databinding.FragmentCartBinding
import com.sample.itunessample.viewmodel.ItunesDataViewModel


class CartFragment : Fragment() {


    private var _binding: FragmentCartBinding? = null
    private val binding get() = _binding!!
    lateinit var dataAdapter: CartSummaryAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCartBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val iTunesSearchViewModel= ViewModelProviders.of(activity!!).get(ItunesDataViewModel::class.java)
        iTunesSearchViewModel.computeCheckoutList()

        dataAdapter= CartSummaryAdapter(activity!!)
        val recyclerViewImg=_binding!!.fragmentCartRecyclerView

        val layoutManagerImgDemo = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        recyclerViewImg.layoutManager = layoutManagerImgDemo

        recyclerViewImg.adapter=dataAdapter

        iTunesSearchViewModel.iTunesCartLiveData.observe(this, Observer {
            checkoutItems ->
            dataAdapter.updateDataList(checkoutItems)
        })
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            CartFragment()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding=null
    }
}