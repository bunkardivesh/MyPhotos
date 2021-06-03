package com.divesh.myphotos

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GalleryViewModel: ViewModel() {

   val dogsList = MutableLiveData<ArrayList<Dogs>>()

   init {
       makeApiCall()
   }

   fun makeApiCall(){

      val retroInstance = RetroInstance.getRetrofit().create(ServiceApi::class.java)

      val call = retroInstance.getImagesFromWeb(1,20)

      call.enqueue(object: Callback<ArrayList<Dogs>>{
         override fun onResponse(call: Call<ArrayList<Dogs>>, response: Response<ArrayList<Dogs>>) {
            if (response.isSuccessful){
               dogsList.postValue(response.body())
               Log.i("OnResponse: ",response.body().toString())
            }
         }

         override fun onFailure(call: Call<ArrayList<Dogs>>, t: Throwable) {
            Log.e("onResponseFailure: ",t.message.toString())
         }
      })

   }

}