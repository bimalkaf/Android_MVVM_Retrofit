package np.com.bimalkafle

import android.app.Application
import dagger.Component
import np.com.bimalkafle.module.NetworkModule
import np.com.bimalkafle.view.MainActivity
import javax.inject.Singleton

@Singleton
@Component (modules = [NetworkModule :: class])
interface ApplicationComponent{
    fun inject(activity : MainActivity)
}

class WeatherApplication : Application() {
    val applicationComponent: ApplicationComponent = DaggerApplicationComponent.create()
}