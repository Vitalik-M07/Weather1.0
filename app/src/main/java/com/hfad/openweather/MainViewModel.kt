package com.hfad.openweather

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hfad.openweather.adapters.WeatherModel

class MainViewModel: ViewModel() {
     val liveDataCurrent = MutableLiveData<WeatherModel>()
     val liveDataList = MutableLiveData<List<WeatherModel> >()
}