package smile.algeria.khadamet.movieapp.view.mapper

import smile.algeria.khadamet.movieapp.data.entities.TVEntity
import smile.algeria.khadamet.movieapp.view.mappers.MapFromEntityToUi
import smile.algeria.khadamet.movieapp.view.uimodel.TVUiModel


/**
 * Created at Tito on 3/16/19
 */

class TVMapper : MapFromEntityToUi<TVEntity, TVUiModel> {

    override fun mapToUiModel(model: TVEntity): TVUiModel {
        with(model) {
            return TVUiModel(
                id,
                name,
                overview,
                originalName,
                originalLanguage,
                posterPath,
                voteCount
            )
        }
    }

    override fun mapToUiModelList(model: List<TVEntity>): List<TVUiModel> {
        return model.map {
            with(it) {
                TVUiModel(
                    id,
                    name,
                    overview,
                    originalName,
                    originalLanguage,
                    posterPath,
                    voteCount
                )
            }
        }
    }

}