package np.com.bimalkafle.api

import np.com.bimalkafle.model.current.CurrentWeatherModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
   @GET("current.json")
    suspend fun getCurrent(@Query ("q") query : String) : Response<CurrentWeatherModel>
}