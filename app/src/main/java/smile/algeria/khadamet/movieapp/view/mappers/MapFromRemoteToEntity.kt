package smile.algeria.khadamet.movieapp.view.mappers

/**
 * Created at Tito on 3/15/19
 *
 * Map from remote to entity use case model.
 */

interface MapFromRemoteToEntity<R, L, E : EntityModel> {

    fun mapFromRemoteToEntity(model: R): E
    fun mapFromLocalToEntity(model: L): E
    fun mapFromRemoteToLocal(model: R): L

}