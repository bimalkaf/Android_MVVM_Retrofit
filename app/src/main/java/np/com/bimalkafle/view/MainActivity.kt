package np.com.bimalkafle.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import np.com.bimalkafle.R
import np.com.bimalkafle.api.ApiService
import np.com.bimalkafle.api.RetrofitHelper
import np.com.bimalkafle.repository.WeatherRepository
import np.com.bimalkafle.viewmodel.MainViewModel
import np.com.bimalkafle.viewmodel.MainViewModelFactory
import okhttp3.OkHttpClient
import okhttp3.Request
import java.net.URL

class MainActivity : AppCompatActivity() {

    lateinit var mainViewModel: MainViewModel

    lateinit var helloWorld: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        helloWorld = findViewById(R.id.hello_world)
        val apiService = RetrofitHelper.getInstance().create(ApiService::class.java)
        val repo = WeatherRepository(apiService)
        mainViewModel =
            ViewModelProvider(this, MainViewModelFactory(repo))[MainViewModel::class.java]

        mainViewModel.getCurrentWeather()

        mainViewModel.currentWeather.observe(this, Observer {
            helloWorld.setText(it.toString())
        })
    }
}
