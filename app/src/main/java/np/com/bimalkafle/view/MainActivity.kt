package np.com.bimalkafle.view

import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.GONE
import android.view.View.INVISIBLE
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.SearchView.OnQueryTextListener
import android.widget.SearchView.VISIBLE
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import np.com.bimalkafle.R
import np.com.bimalkafle.api.ApiResponse
import np.com.bimalkafle.api.ApiService
import np.com.bimalkafle.api.RetrofitHelper
import np.com.bimalkafle.databinding.ActivityMainBinding
import np.com.bimalkafle.repository.WeatherRepository
import np.com.bimalkafle.util.UiUtil
import np.com.bimalkafle.viewmodel.MainViewModel
import np.com.bimalkafle.viewmodel.MainViewModelFactory
import okhttp3.OkHttpClient
import okhttp3.Request
import java.net.URL

class MainActivity : AppCompatActivity() {

    lateinit var mainViewModel: MainViewModel
    lateinit var binding : ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.mainParentLayout.setBackgroundResource(R.color.primary)


        val apiService = RetrofitHelper.getInstance().create(ApiService::class.java)
        val repo = WeatherRepository(apiService)
        mainViewModel =
            ViewModelProvider(this, MainViewModelFactory(repo))[MainViewModel::class.java]

        mainViewModel.getCurrentWeather("Kathmandu")

        mainViewModel.currentWeather.observe(this, Observer {
            when(it){
                is ApiResponse.ApiLoading ->{
                    binding.progressIndicator.visibility = VISIBLE
                }
                is ApiResponse.ApiError ->{
                    binding.progressIndicator.visibility = INVISIBLE
                    UiUtil.showToast(this,it.message?: getString(R.string.something_went_wrong))
                }
                is ApiResponse.ApiSuccess ->{
                    binding.progressIndicator.visibility = INVISIBLE
                    Glide.with(this).load("https:"+it.data?.current?.condition?.icon).into(binding.imageView)
                    binding.placeTextview.text = it.data?.location?.name
                    binding.temperatureCelsiusTextview.text =
                        getString(R.string.unit_degree_celsius, it.data?.current?.temp_c.toString())
                    binding.humidityTextview.text = getString(R.string.unit_percent, it.data?.current?.humidity.toString())
                    binding.windSpeedTextview.text = getString(R.string.unit_kph, it.data?.current?.wind_kph.toString())
                }

            }
        })

        binding.searchView.setOnQueryTextListener( object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                mainViewModel.getCurrentWeather(query?:"Kathmandu")
                binding.searchView.clearFocus()
                return true;
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return true;
            }

        })
    }
}


