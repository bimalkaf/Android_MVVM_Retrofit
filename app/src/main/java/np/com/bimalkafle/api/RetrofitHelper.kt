package np.com.bimalkafle.api

import android.util.Log
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {
    private const val BASE_URL = "https://api.weatherapi.com/v1/";
    private const val API_KEY = "YOUR_API_KEY"

    private val apiKeyInterceptor = Interceptor { chain ->
        val originalRequest = chain.request()
        val newUrl = originalRequest.url().newBuilder()
            .addQueryParameter("key", API_KEY)
            .build()
        val newRequest = originalRequest.newBuilder().url(newUrl).build()
        chain.proceed(newRequest)
    }
     fun getInstance() : Retrofit{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(OkHttpClient.Builder().addInterceptor(apiKeyInterceptor).build())
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    }
}