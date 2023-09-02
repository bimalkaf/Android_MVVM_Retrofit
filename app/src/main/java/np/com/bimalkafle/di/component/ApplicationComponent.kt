package np.com.bimalkafle.di.component
import dagger.Component
import np.com.bimalkafle.di.module.NetworkModule
import np.com.bimalkafle.view.MainActivity
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule :: class])
interface ApplicationComponent{
    fun inject(activity : MainActivity)
}