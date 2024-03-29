package smile.algeria.khadamet.movieapp.data.entities

import smile.algeria.khadamet.movieapp.view.mappers.EntityModel


/**
 * Created at Tito on 3/15/19
 */

data class TVEntity(

    val id: Int = 0,

    val overview: String? = null,

    val originalLanguage: String? = null,

    val posterPath: String? = null,

    val voteAverage: Double = 0.0,

    val originalName: String? = null,

    val name: String? = null,

    val voteCount: Int = 0

) : EntityModel