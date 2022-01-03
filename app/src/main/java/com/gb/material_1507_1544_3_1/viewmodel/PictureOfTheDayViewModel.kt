package com.gb.material_1507_1544_3_1.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gb.material_1507_1544_3_1.repository.PictureOfTheDayResponseData
import com.gb.material_1507_1544_3_1.repository.PictureOfTheDayRetrofitImpl
import com.gb.material_1507_1544_3_1.BuildConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PictureOfTheDayViewModel(
    private val liveDataForViewToObserve: MutableLiveData<PictureOfTheDayState> = MutableLiveData(),
    private val retrofitImpl: PictureOfTheDayRetrofitImpl = PictureOfTheDayRetrofitImpl()
) : ViewModel() {
    fun getData(): LiveData<PictureOfTheDayState> {
        return liveDataForViewToObserve
    }

    fun sendServerRequest() {
        liveDataForViewToObserve.value = PictureOfTheDayState.Loading(0)
        val apiKey: String = BuildConfig.NASA_API_KEY
        if (apiKey.isBlank()) {
            liveDataForViewToObserve.value = PictureOfTheDayState.Error(Throwable("wrong key"))
        } else {
            retrofitImpl.getRetrofitImpl().getPictureOfTheDay(apiKey).enqueue(callback)
        }
    }

    fun sendServerRequest(date:String) {
        liveDataForViewToObserve.value = PictureOfTheDayState.Loading(0)
        val apiKey: String = BuildConfig.NASA_API_KEY
        if (apiKey.isBlank()) {
            liveDataForViewToObserve.value = PictureOfTheDayState.Error(Throwable("wrong key"))
        } else {
            retrofitImpl.getRetrofitImpl().getPictureOfTheDay(apiKey,date).enqueue(callback)
        }
    }

    private val callback = object : Callback<PictureOfTheDayResponseData>{
        override fun onResponse(
            call: Call<PictureOfTheDayResponseData>,
            response: Response<PictureOfTheDayResponseData>
        ) {
            if(response.isSuccessful&&response.body()!=null){
                liveDataForViewToObserve.value = PictureOfTheDayState.Success(response.body()!!)
            }else{
                liveDataForViewToObserve.value = PictureOfTheDayState.Error(IllegalStateException("Ошибка"))
            }
        }

        //https://material.io/components/bottom-navigation/android#theming-a-bottom-navigation-bar
        override fun onFailure(call: Call<PictureOfTheDayResponseData>, t: Throwable) {
            liveDataForViewToObserve.value = PictureOfTheDayState.Error(IllegalStateException("onFailure"))
        }

    }
}