package np.com.bimalkafle.view

import android.content.res.Configuration
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
     var isDark = false;


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        when(resources.configuration.uiMode and
//                Configuration.UI_MODE_NIGHT_MASK){
//            Configuration.UI_MODE_NIGHT_YES -> isDark = true
//            Configuration.UI_MODE_NIGHT_NO -> isDark = false
//            Configuration.UI_MODE_NIGHT_UNDEFINED -> isDark = false
//            else -> isDark = false
//        }
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
                    if(it.data?.current?.is_day==0){
                        binding.mainParentLayout.setBackgroundResource(R.color.primary_dark)
                    }else{
                        binding.mainParentLayout.setBackgroundResource(R.color.primary)
                    }

                    binding.progressIndicator.visibility = INVISIBLE
                    Glide.with(this).load("https:"+it.data?.current?.condition?.icon).into(binding.imageView)
                    binding.dateTextview.text = it.data?.location?.localtime?.split(" ")?.get(0)
                    binding.timeTextview.text = it.data?.location?.localtime?.split(" ")?.get(1)
                    binding.placeTextview.text = it.data?.location?.name
                    binding.conditionTextview.text = it.data?.current?.condition?.text
                    binding.uvTextview.text = it.data?.current?.uv.toString()
                    binding.percipationTextview.text =getString(R.string.unit_precipitation, it.data?.current?.precip_mm.toString())

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


