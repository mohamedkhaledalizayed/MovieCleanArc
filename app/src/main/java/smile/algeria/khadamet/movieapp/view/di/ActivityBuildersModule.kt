package smile.algeria.khadamet.movieapp.view.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import smile.algeria.khadamet.movieapp.view.ui.homescreen.HomeActivity

@Module
abstract class ActivityBuildersModule {

    @ContributesAndroidInjector
    abstract fun contributeMainActivity(): HomeActivity


}