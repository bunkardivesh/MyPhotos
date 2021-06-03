package com.divesh.myphotos

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ServiceApi {

    companion object{
        const val BASE_URL = "https://api.thedogapi.com/"
    }

    @GET("v1/images/search")
    fun getImagesFromWeb(
        @Query("page") page: Int,
        @Query("limit") limit:Int
    ): Call<ArrayList<Dogs>>
}