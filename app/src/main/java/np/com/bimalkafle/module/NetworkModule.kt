package np.com.bimalkafle.module

import dagger.Module
import dagger.Provides
import np.com.bimalkafle.api.ApiService
import np.com.bimalkafle.api.RetrofitHelper
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {

    @Singleton
    @Provides
    fun providesRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(RetrofitHelper.BASE_URL)
            .client(OkHttpClient.Builder().addInterceptor { chain ->
                val originalRequest = chain.request()
                val newUrl = originalRequest.url().newBuilder()
                    .addQueryParameter("key", RetrofitHelper.API_KEY)
                    .build()
                val newRequest = originalRequest.newBuilder().url(newUrl).build()
                chain.proceed(newRequest)
            }.build())
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    }

    @Singleton
    @Provides
    fun providesApiService( retrofit: Retrofit) :ApiService{
        return retrofit.create(ApiService::class.java);
    }
}