package smile.algeria.khadamet.movieapp.data.repository

import io.reactivex.Flowable
import io.reactivex.Single
import smile.algeria.khadamet.movieapp.data.entities.MovieEntity
import smile.algeria.khadamet.movieapp.data.local.MovieDao
import smile.algeria.khadamet.movieapp.data.mapper.MovieMapper
import smile.algeria.khadamet.movieapp.data.remote.ApiService
import javax.inject.Inject

class MovieRepository
@Inject
constructor(
    private val local: MovieDao,
    private val remote: ApiService,
    private val mapper: MovieMapper

){

    fun getMovies(pageNumber: Int): Flowable<List<MovieEntity>?> {

        val localMovie =
            local.getMovies.map { movieLocalList ->
                movieLocalList.map { movieLocal ->
                    mapper.mapFromLocalToEntity(movieLocal)
                }
            }

        val remoteMovie = if (pageNumber == 1) {
            remote.getMovies(pageNumber).map { getMovieResponse ->
                getMovieResponse.movies?.map { movieRemote ->
//                    local.insertMovie(mapper.mapFromRemoteToLocal(movieRemote))
                    mapper.mapFromRemoteToEntity(movieRemote)
                }
            }
        } else {
            remote.getMovies(pageNumber).map { getMovieResponse ->
                getMovieResponse.movies?.map { movieRemote ->
                    mapper.mapFromRemoteToEntity(movieRemote)
                }
            }
        }

        if (pageNumber == 1)
            return Single.concat<List<MovieEntity>>(localMovie, remoteMovie)

        return remoteMovie.toFlowable()
    }


    fun getMovie(movieId: Int){

    }

    fun getSimilarMovies(movieId: Int){

    }

    fun getRecommendationMovies(movieId: Int){

    }
}

