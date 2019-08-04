package smile.algeria.khadamet.movieapp.data.models.tv

import com.ahmedadel.robustandroid.models.remote.tv.TVRemote
import com.squareup.moshi.Json

data class TVListRemote(

    @Json(name = "page")
    val page: Int = 0,

    @Json(name = "total_pages")
    val totalPages: Int = 0,

    @Json(name = "results")
    val tVs: List<TVRemote>? = null,

    @Json(name = "total_results")
    val totalResults: Int = 0

)