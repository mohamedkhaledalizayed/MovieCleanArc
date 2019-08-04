package smile.algeria.khadamet.movieapp.data.repository

import smile.algeria.khadamet.movieapp.data.remote.ApiService
import javax.inject.Inject

class ActorsRepository
@Inject
constructor(
    private val remote: ApiService
){

    fun getActors(pageNumber: Int){

    }

    fun getActor(personId: Int){

    }
}
