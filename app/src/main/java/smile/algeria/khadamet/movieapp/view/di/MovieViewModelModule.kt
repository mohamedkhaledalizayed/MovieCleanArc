package smile.algeria.khadamet.movieapp.view.di

import androidx.lifecycle.ViewModel
import com.ahmedadel.robustandroid.core.di.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import smile.algeria.khadamet.movieapp.view.ui.homescreen.HomeViewModel

@Module
abstract class MovieViewModelModule {


    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    abstract fun bindPostsViewModel(viewModel: HomeViewModel): ViewModel
}