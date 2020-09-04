package com.sample.itunessample.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.gson.Gson
import com.sample.itunessample.model.ItunesData
import com.sample.itunessample.model.ItunesDataItem
import kotlinx.coroutines.launch
import java.io.*
import java.text.SimpleDateFormat
import java.util.*


class ItunesDataViewModel:ViewModel() {

    val iTunesResultLiveData:MutableLiveData<List<ItunesDataItem>> by lazy {
        MutableLiveData()
    }

    val iTunesCartLiveData:MutableLiveData<List<ItunesDataItem>> by lazy {
        MutableLiveData()
    }

    lateinit var mDataItemList:List<ItunesDataItem>


    fun readDataFromJson(ipStream: InputStream) {

        viewModelScope.launch {
            var reader: BufferedReader? = null
            try {
                reader = BufferedReader(InputStreamReader(ipStream))
                val inputString = reader.use { it.readText() }
                val exp = Gson().fromJson(inputString, ItunesData::class.java)

                // sort by releasedDate in ascending order //
                val DATE_FORMAT="yyyy-MM-dd'T'HH:mm:ss'Z'"

                val dateTimeStrToLocalDateTime: (ItunesDataItem) -> Date? = {
                    SimpleDateFormat(DATE_FORMAT).parse(it.releaseDate!!)
                }
                var iTunesDataItems=exp.results.sortedBy(dateTimeStrToLocalDateTime)


                iTunesDataItems=iTunesDataItems.sortedByDescending { it.collectionName}
                .sortedByDescending { it.trackName}
                .sortedByDescending { it.artistName}
                .sortedByDescending { it.collectionPrice}


                mDataItemList=iTunesDataItems

                iTunesResultLiveData.postValue(iTunesDataItems)
            } catch (e: IOException) {
                e.printStackTrace()
            } finally {
                if (reader != null)
                    try {
                        reader.close()
                    } catch (e: IOException) {

                    }
            }

        }
    }

    fun searchForKeyword(searchText: String) {
        viewModelScope.launch {
            val searchResultDataList = ArrayList<ItunesDataItem>()
            for (dataItem in mDataItemList) {
                if (dataItem.artistName.toLowerCase(Locale.getDefault()).contains(searchText)) {
                    searchResultDataList.add(dataItem)
                    continue
                }
                if (dataItem.trackName.toLowerCase(Locale.getDefault()).contains(searchText)) {
                    searchResultDataList.add(dataItem)
                }

            }
            iTunesResultLiveData.postValue(searchResultDataList)
        }
    }


    fun computeCheckoutList(){
        val cartDataList=ArrayList<ItunesDataItem>()
        for(dataItem in mDataItemList){
            if(dataItem.isItemSelected)
                cartDataList.add(dataItem)
        }

        iTunesCartLiveData.value=cartDataList
    }

}