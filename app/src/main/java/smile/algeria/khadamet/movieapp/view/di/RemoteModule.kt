package smile.algeria.khadamet.movieapp.view.di

import android.app.Application
import com.github.simonpercic.oklog3.OkLogInterceptor
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import smile.algeria.khadamet.movieapp.BuildConfig
import smile.algeria.khadamet.movieapp.data.remote.ApiKeyInterceptor
import smile.algeria.khadamet.movieapp.data.remote.ApiService
import java.io.File
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

/**
 * Created at Tito on 3/15/19
 *
 * Dagger Module that provides Remote stuff like Retrofit, ApiKeyInterceptor and OkLog.
 */

@Module
class RemoteModule {

    @Provides
    @Singleton
    fun provideOkHttpClient(interceptor: HttpLoggingInterceptor, apiKeyInterceptor: ApiKeyInterceptor, cache: Cache): OkHttpClient {
        return OkHttpClient.Builder()
            .writeTimeout(15, TimeUnit.SECONDS)
            .readTimeout(15, TimeUnit.SECONDS)
            .connectTimeout(15, TimeUnit.SECONDS)
            .cache(cache)
            .addInterceptor(apiKeyInterceptor)
            .addInterceptor(interceptor)
            .build()
    }

    @Provides
    @Singleton
    internal fun provideApiKeyInterceptor() = ApiKeyInterceptor()

    @Provides
    @Singleton
    fun getGson(): Gson {
        return GsonBuilder().create()
    }

    @Provides
    @Singleton
    fun getCache(file: File): Cache{
        return Cache(file, (10 * 1000 * 1000).toLong())  // 10 MiB cache
    }

    @Provides
    @Singleton
    fun getFile(application: Application): File {
        val file = File(application.filesDir, "cache_dir")
        if (!file.exists())
            file.mkdirs()
        return file
    }

    @Provides
    @Singleton
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        val logging = HttpLoggingInterceptor()
        logging.level =
            if (BuildConfig.DEBUG)
                HttpLoggingInterceptor.Level.BODY
            else
                HttpLoggingInterceptor.Level.NONE
        return logging
    }

    @Provides
    @Singleton
    fun provideOkLogInterceptor(): Interceptor {
        return OkLogInterceptor.builder().build()
    }

    @Provides
    @Singleton
    fun provideMoshi(): Moshi = Moshi.Builder().build()

    @Provides
    @Singleton
    fun provideRetrofit(moshi: Moshi, client: OkHttpClient): ApiService {
        return Retrofit.Builder()
            .baseUrl("BuildConfig.BASE_API_URL")
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(client)
            .build()
            .create(ApiService::class.java)
    }
}