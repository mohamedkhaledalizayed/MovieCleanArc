package smile.algeria.khadamet.movieapp.view.mapper

import smile.algeria.khadamet.movieapp.data.entities.MovieEntity
import smile.algeria.khadamet.movieapp.view.mappers.MapFromEntityToUi
import smile.algeria.khadamet.movieapp.view.uimodel.MovieUiModel


/**
 * Created at Tito on 3/16/19
 */

class MovieMapper : MapFromEntityToUi<MovieEntity, MovieUiModel> {

    override fun mapToUiModel(model: MovieEntity): MovieUiModel {
        with(model) {
            return MovieUiModel(
                id = id,
                title = title,
                overview = overview,
                originalLanguage = originalLanguage,
                originalTitle = originalTitle,
                posterPath = posterPath,
                releaseDate = releaseDate,
                voteAverage = voteAverage,
                isAdult = isAdult
            )
        }
    }

    override fun mapToUiModelList(model: List<MovieEntity>): List<MovieUiModel> {
        return model.map {
            with(it) {
                MovieUiModel(
                    id = id,
                    title = title,
                    overview = overview,
                    originalLanguage = originalLanguage,
                    originalTitle = originalTitle,
                    posterPath = posterPath,
                    releaseDate = releaseDate,
                    voteAverage = voteAverage,
                    isAdult = isAdult
                )
            }
        }
    }

}