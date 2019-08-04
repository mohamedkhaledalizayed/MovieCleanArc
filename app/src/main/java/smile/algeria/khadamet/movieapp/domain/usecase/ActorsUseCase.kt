package smile.algeria.khadamet.movieapp.domain.usecase

import smile.algeria.khadamet.movieapp.data.repository.ActorsRepository
import javax.inject.Inject

class ActorsUseCase
@Inject
constructor(private val repository: ActorsRepository) {

    fun getActors(pageNumber: Int) = repository.getActors(pageNumber)

    fun getActor(personId: Int) = repository.getActor(personId)

}
