package smile.algeria.khadamet.movieapp.data.entities

import smile.algeria.khadamet.movieapp.view.mappers.EntityModel

data class MovieEntity(

    val id: Int = 0,

    val overview: String? = null,

    val originalLanguage: String? = null,

    val originalTitle: String? = null,

    val title: String? = null,

    val posterPath: String? = null,

    val releaseDate: String? = null,

    val popularity: Double = 0.0,

    val voteAverage: Double = 0.0,

    val isAdult: Boolean = false,

    val voteCount: Int = 0

): EntityModel