package smile.algeria.khadamet.movieapp.data.repository

import smile.algeria.khadamet.movieapp.data.remote.ApiService
import javax.inject.Inject

class TVsRepository
@Inject constructor(private val remote: ApiService){

    fun getTVs(pageNumber: Int){

    }

    fun getTV(tvId: Int){

    }

    fun getSimilarTVs(tvId: Int){

    }

    fun getRecommendationTVs(tvId: Int){

    }
}