package np.com.bimalkafle.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import np.com.bimalkafle.api.ApiService
import np.com.bimalkafle.model.current.CurrentWeatherModel

class WeatherRepository(private val apiService: ApiService) {

    private val currentWeatherLiveData = MutableLiveData<CurrentWeatherModel>()
    val _currentWeather : LiveData<CurrentWeatherModel>
        get() {
           return currentWeatherLiveData
        }

    suspend fun getCurrentWeather(query: String) {
        val result  = apiService.getCurrent(query);
        currentWeatherLiveData.postValue(result.body())
    }
}