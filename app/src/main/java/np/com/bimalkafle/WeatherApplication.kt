package np.com.bimalkafle

import android.app.Application
import dagger.Component
import dagger.hilt.android.HiltAndroidApp
import np.com.bimalkafle.di.module.NetworkModule
import np.com.bimalkafle.view.MainActivity
import javax.inject.Singleton

@HiltAndroidApp
class WeatherApplication : Application() {
}