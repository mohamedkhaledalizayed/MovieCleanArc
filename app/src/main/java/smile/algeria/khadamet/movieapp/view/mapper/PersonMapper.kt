package smile.algeria.khadamet.movieapp.view.mapper


import smile.algeria.khadamet.movieapp.data.entities.PersonEntity
import smile.algeria.khadamet.movieapp.view.mappers.MapFromEntityToUi
import smile.algeria.khadamet.movieapp.view.uimodel.PersonUiModel

/**
 * Created at Tito on 3/16/19
 */

class PersonMapper : MapFromEntityToUi<PersonEntity, PersonUiModel> {

    override fun mapToUiModel(model: PersonEntity): PersonUiModel {
        with(model) {
            return PersonUiModel(
                id = id,
                popularity = popularity,
                name = name,
                profilePath = profilePath,
                isAdult = isAdult
            )
        }
    }

    override fun mapToUiModelList(model: List<PersonEntity>): List<PersonUiModel> {
        return model.map {
            with(it) {
                PersonUiModel(
                    id = id,
                    popularity = popularity,
                    name = name,
                    profilePath = profilePath,
                    isAdult = isAdult
                )
            }
        }
    }

}