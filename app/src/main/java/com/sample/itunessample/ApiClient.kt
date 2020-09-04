package com.sample.itunessample

import com.sample.itunessample.model.ItunesData
import okhttp3.OkHttpClient
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.simplexml.SimpleXmlConverterFactory
//import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiClient {


//    @GET("?method=flickr.photos.search&api_key=3189212285dcb4cf5b2f044edcb0544e&tags=happy")
    @GET("search?term=all")
    suspend fun getMatchingImages(): Response<ItunesData>

    object ApiAdapter {
        val apiClient: ApiClient = Retrofit.Builder()
            .baseUrl("https://itunes.apple.com/")
            .client(OkHttpClient())
            .addConverterFactory(SimpleXmlConverterFactory.create())
            .build()
            .create(ApiClient::class.java)
    }
}