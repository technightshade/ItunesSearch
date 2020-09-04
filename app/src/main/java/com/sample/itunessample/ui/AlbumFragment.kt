package com.sample.itunessample.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.sample.itunessample.R
import com.sample.itunessample.adapter.ItunesResultDataAdapter
import com.sample.itunessample.databinding.FragmentAlbumBinding
import com.sample.itunessample.model.ItunesDataItem
import com.sample.itunessample.viewmodel.ItunesDataViewModel

class AlbumFragment : Fragment() {

    lateinit var iTunesSearchViewModel: ItunesDataViewModel
    lateinit var dataAdapter: ItunesResultDataAdapter

    val selectedCountLiveData: MutableLiveData<Int> = MutableLiveData()
    var selectedCount:Int=0

    private var _binding: FragmentAlbumBinding? = null
    private val binding get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAlbumBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        iTunesSearchViewModel= ViewModelProviders.of(activity!!).get(ItunesDataViewModel::class.java)

        val recyclerViewImg=_binding!!.activityMainSearchRecyclerView
        val albumSelectedCount=_binding!!.fragmentAlbumSelectedCount
        dataAdapter= ItunesResultDataAdapter(activity!!,registerItemClick())
        val layoutManagerImgDemo = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        recyclerViewImg.layoutManager = layoutManagerImgDemo

        recyclerViewImg.adapter=dataAdapter

        val searchEditTextView=_binding!!.fragmentAlbumSearchEditText

        _binding!!.fragmentAlbumSearchIcon.setOnClickListener {
            if (searchEditTextView.text.trim().isEmpty()) {
                Toast.makeText(activity!!, "Please Enter Search Text", Toast.LENGTH_SHORT).show()
            } else {
                iTunesSearchViewModel.searchForKeyword(searchEditTextView.text.toString().toLowerCase())
            }
        }

        _binding!!.fragmentAlbumCheckout.setOnClickListener{v ->

            if(selectedCount==0){
                Toast.makeText(activity!!, "Please select albums", Toast.LENGTH_SHORT).show()
            }else{
            val transaction: FragmentTransaction =activity!!.supportFragmentManager.beginTransaction()
            transaction.add(R.id.fragmentHolder,
                CartFragment.newInstance(), "Cart Fragment")
            transaction.addToBackStack(null)
            transaction.commit()
            }
        }


        iTunesSearchViewModel.iTunesResultLiveData.observe(this,{ resultData ->
            // update list get here //
            dataAdapter.updateDataList(resultData)
        })


        selectedCountLiveData.observe(this,{ totalSelected ->
            albumSelectedCount.text="$totalSelected albums selected"
            dataAdapter.notifyDataSetChanged()
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        @JvmStatic
        fun newInstance() = AlbumFragment()
    }



    private fun registerItemClick(): ItunesResultDataAdapter.ItemClickListener {
        return object: ItunesResultDataAdapter.ItemClickListener {
            override fun onItemClick(view: View, dataItem: ItunesDataItem) {
                if(dataItem.isItemSelected)
                    selectedCount += 1
                else
                    selectedCount -= 1


                selectedCountLiveData.value=selectedCount
            }
        }
    }
}