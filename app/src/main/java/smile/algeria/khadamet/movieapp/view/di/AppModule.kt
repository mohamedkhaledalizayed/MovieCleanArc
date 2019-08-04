package smile.algeria.khadamet.movieapp.view.di

import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import smile.algeria.khadamet.movieapp.data.remote.ApiService
import smile.algeria.khadamet.movieapp.view.ui.homescreen.ActorsAdapter
import smile.algeria.khadamet.movieapp.view.ui.homescreen.MovieAdapter
import smile.algeria.khadamet.movieapp.view.ui.homescreen.TvAdapter
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    @Singleton
    fun provideMovieAdapter(): MovieAdapter = MovieAdapter()

    @Provides
    @Singleton
    fun providePersonAdapter(): ActorsAdapter = ActorsAdapter()

    @Provides
    @Singleton
    fun provideTVAdapter(): TvAdapter = TvAdapter()

    @Singleton
    @Provides
    internal fun provideMainApi(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }

}