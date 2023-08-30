package np.com.bimalkafle.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import np.com.bimalkafle.model.current.CurrentWeatherModel
import np.com.bimalkafle.repository.WeatherRepository
import okhttp3.Interceptor

class MainViewModel(private val weatherRepository: WeatherRepository) :ViewModel() {


     fun getCurrentWeather(){
        viewModelScope.launch(Dispatchers.IO) {
            weatherRepository.getCurrentWeather("Kathmandu")
        }
    }

    val currentWeather : LiveData<CurrentWeatherModel>
        get() {
           return weatherRepository._currentWeather
        }
}