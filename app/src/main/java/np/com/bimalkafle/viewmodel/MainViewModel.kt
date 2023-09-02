package np.com.bimalkafle.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import np.com.bimalkafle.api.ApiResponse
import np.com.bimalkafle.model.current.CurrentWeatherModel
import np.com.bimalkafle.repository.WeatherRepository
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val weatherRepository: WeatherRepository) :ViewModel() {

     fun getCurrentWeather( query : String){
        viewModelScope.launch(Dispatchers.IO) {
            weatherRepository.getCurrentWeather(query)
        }
    }

    val currentWeather : LiveData<ApiResponse<CurrentWeatherModel>>
        get() {
           return weatherRepository.currentWeather
        }
}