package smile.algeria.khadamet.movieapp.data.mapper


import smile.algeria.khadamet.movieapp.data.entities.MovieEntity
import smile.algeria.khadamet.movieapp.data.local.MovieLocal
import smile.algeria.khadamet.movieapp.data.models.movie.MovieRemote
import smile.algeria.khadamet.movieapp.view.mappers.MapFromRemoteToEntity

/**
 * Created at Tito on 3/15/19
 */

class MovieMapper : MapFromRemoteToEntity<MovieRemote, MovieLocal, MovieEntity> {

    override fun mapFromRemoteToEntity(model: MovieRemote): MovieEntity {
        with(model) {
            return MovieEntity(
                id = id,
                overview = overview,
                originalLanguage = originalLanguage,
                originalTitle = originalTitle,
                title = title,
                posterPath = posterPath,
                releaseDate = releaseDate,
                popularity = popularity,
                voteAverage = voteAverage,
                isAdult = isAdult,
                voteCount = voteCount
            )
        }
    }

    override fun mapFromLocalToEntity(model: MovieLocal): MovieEntity {
        with(model) {
            return MovieEntity(
                id = id,
                overview = overview,
                originalLanguage = originalLanguage,
                originalTitle = originalTitle,
                title = title,
                posterPath = posterPath,
                releaseDate = releaseDate,
                popularity = popularity,
                voteAverage = voteAverage
            )
        }
    }

    override fun mapFromRemoteToLocal(model: MovieRemote): MovieLocal {
        with(model) {
            return MovieLocal(
                id = id,
                overview = overview,
                originalLanguage = originalLanguage,
                originalTitle = originalTitle,
                video = isVideo,
                title = title,
                posterPath = posterPath,
                backdropPath = backdropPath,
                releaseDate = releaseDate,
                popularity = popularity,
                voteAverage = voteAverage,
                adult = isAdult,
                voteCount = voteCount
            )
        }
    }

}