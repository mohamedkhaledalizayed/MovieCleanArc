package smile.algeria.khadamet.movieapp.domain.usecase

import smile.algeria.khadamet.movieapp.data.repository.TVsRepository
import javax.inject.Inject

class TVsUseCase
@Inject constructor(private val repository: TVsRepository){

    fun getTVs(pageNumber: Int) = repository.getTVs(pageNumber)

    fun getTV(tvId: Int) = repository.getTV(tvId)

    fun getSimilarTVs(tvId: Int) = repository.getSimilarTVs(tvId)

    fun getRecommendationTVs(tvId: Int) = repository.getRecommendationTVs(tvId)

}