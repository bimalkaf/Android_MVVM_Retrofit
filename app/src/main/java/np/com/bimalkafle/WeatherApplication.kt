package np.com.bimalkafle

import android.app.Application
import np.com.bimalkafle.di.component.ApplicationComponent
import np.com.bimalkafle.di.component.DaggerApplicationComponent


class WeatherApplication : Application() {
    val applicationComponent: ApplicationComponent = DaggerApplicationComponent.create()
}