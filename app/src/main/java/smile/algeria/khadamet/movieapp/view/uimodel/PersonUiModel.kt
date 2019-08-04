package smile.algeria.khadamet.movieapp.view.uimodel

import smile.algeria.khadamet.movieapp.view.mappers.UiModel


/**
 * Created at Tito on 3/16/19
 */

data class PersonUiModel(

    val id: Int = 0,

    val popularity: Double = 0.0,

    val name: String? = null,

    val profilePath: String? = null,

    val isAdult: Boolean = false

): UiModel