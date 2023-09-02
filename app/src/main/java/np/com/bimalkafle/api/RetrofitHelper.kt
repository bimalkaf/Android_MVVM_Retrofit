package np.com.bimalkafle.api

import android.util.Log
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {
    const val BASE_URL = "https://api.weatherapi.com/v1/";
    const val API_KEY = "YOUR_API_KEY"
}