package smile.algeria.khadamet.movieapp.view.di


import android.app.Application
import com.alexfacciorusso.daggerviewmodel.DaggerViewModelInjectionModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import smile.algeria.khadamet.movieapp.view.MovieApp
import javax.inject.Singleton

@Singleton
@Component(
        modules = [AndroidSupportInjectionModule::class, DaggerViewModelInjectionModule::class,
            ActivityBuildersModule::class, AppModule::class, RemoteModule::class
            ]
)
interface AppComponent : AndroidInjector<MovieApp> {


    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }
}