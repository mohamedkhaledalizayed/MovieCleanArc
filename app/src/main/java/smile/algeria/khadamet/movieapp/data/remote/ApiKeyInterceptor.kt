package smile.algeria.khadamet.movieapp.data.remote

import okhttp3.Interceptor
import okhttp3.Response

/**
 *
 * An Interceptor class that making some automation by sending api_key to every api request by default.
 */

class ApiKeyInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val original = chain.request()
        val originalHttpUrl = original.url()

        val url = originalHttpUrl.newBuilder()
            .addQueryParameter("api_key", "BuildConfig.API_KEY")
            .build()

        val requestBuilder = original.newBuilder().url(url)

        val request = requestBuilder.build()
        return chain.proceed(request)
    }
}