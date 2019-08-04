package smile.algeria.khadamet.movieapp.data.models.movie

import com.squareup.moshi.Json
import smile.algeria.khadamet.movieapp.data.models.movie.MovieRemote

data class MovieListRemote(

    @Json(name = "page")
    val page: Int = 0,

    @Json(name = "total_pages")
    val totalPages: Int = 0,

    @Json(name = "results")
    val movies: List<MovieRemote>? = null,

    @Json(name = "total_results")
    val totalResults: Int = 0

)