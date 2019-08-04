package smile.algeria.khadamet.movieapp.domain.usecase

import smile.algeria.khadamet.movieapp.data.repository.MovieRepository
import javax.inject.Inject


class MovieUseCase
@Inject
constructor(private val repository: MovieRepository) {

    fun getMovies(pageNumber: Int) = repository.getMovies(pageNumber)

    fun getMovie(movieId: Int) = repository.getMovie(movieId)

    fun getSimilarMovies(movieId: Int) = repository.getSimilarMovies(movieId)

    fun getRecommendationMovies(movieId: Int) = repository.getRecommendationMovies(movieId)

}