package smile.algeria.khadamet.movieapp.view.ui.homescreen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import io.reactivex.functions.Consumer
import smile.algeria.khadamet.movieapp.ViewState
import smile.algeria.khadamet.movieapp.domain.usecase.ActorsUseCase
import smile.algeria.khadamet.movieapp.domain.usecase.MovieUseCase
import smile.algeria.khadamet.movieapp.domain.usecase.TVsUseCase
import smile.algeria.khadamet.movieapp.view.base.BaseSchedulerProvider
import smile.algeria.khadamet.movieapp.view.base.BaseViewModel
import smile.algeria.khadamet.movieapp.view.mapper.MovieMapper
import smile.algeria.khadamet.movieapp.view.mapper.PersonMapper
import smile.algeria.khadamet.movieapp.view.mapper.TVMapper
import smile.algeria.khadamet.movieapp.view.uimodel.MovieUiModel
import smile.algeria.khadamet.movieapp.view.uimodel.PersonUiModel
import smile.algeria.khadamet.movieapp.view.uimodel.TVUiModel
import javax.inject.Inject

class HomeViewModel
@Inject
constructor(
    baseSchedulerProvider: BaseSchedulerProvider,
    private val movieUseCase: MovieUseCase,
    private val personUseCase: ActorsUseCase,
    private val tvUseCase: TVsUseCase,
    private val movieMapper: MovieMapper,
    private val personMapper: PersonMapper,
    private val tvMapper: TVMapper
) : BaseViewModel(baseSchedulerProvider) {

    fun getMovies(pageNumber: Int): LiveData<ViewState<List<MovieUiModel>>> {

        val moviesLiveData = MutableLiveData<ViewState<List<MovieUiModel>>>()

        execute(
            loadingConsumer = Consumer {
                moviesLiveData.postValue(
                    ViewState.loading()
                )
            },
            successConsumer = Consumer { movieItemList ->
                movieItemList?.let {
                    moviesLiveData.postValue(
                        ViewState.success(movieMapper.mapToUiModelList(it))
                    )
                }
            },
            throwableConsumer = Consumer { throwable ->
                moviesLiveData.postValue(
                    ViewState.error(throwable.message)
                )
            },
            useCase = movieUseCase.getMovies(pageNumber)//7wzd5n
        )

        return moviesLiveData
    }

//    fun getPersons(pageNumber: Int): LiveData<ViewState<List<PersonUiModel>>> {
//
//        val personsLiveData = MutableLiveData<ViewState<List<PersonUiModel>>>()
//
//        execute(
//            loadingConsumer = Consumer {
//                personsLiveData.postValue(
//                    ViewState.loading()
//                )
//            },
//            successConsumer = Consumer { personsItemList ->
//                personsItemList?.let {
//                    personsLiveData.postValue(
//                        ViewState.success(personMapper.mapToUiModelList(it))
//                    )
//                }
//            },
//            throwableConsumer = Consumer { throwable ->
//                personsLiveData.postValue(
//                    ViewState.error(throwable.message)
//                )
//            },
//            useCase = personUseCase.getActors(pageNumber)
//        )
//
//        return personsLiveData
//    }
//
//    fun getTVs(pageNumber: Int): LiveData<ViewState<List<TVUiModel>>> {
//
//        val tvsLiveData = MutableLiveData<ViewState<List<TVUiModel>>>()
//
//        execute(
//            loadingConsumer = Consumer {
//                tvsLiveData.postValue(
//                    ViewState.loading()
//                )
//            },
//            successConsumer = Consumer { tvItemList ->
//                tvItemList?.let {
//                    tvsLiveData.postValue(
//                        ViewState.success(tvMapper.mapToUiModelList(it))
//                    )
//                }
//            },
//            throwableConsumer = Consumer { throwable ->
//                tvsLiveData.postValue(
//                    ViewState.error(throwable.message)
//                )
//            },
//            useCase = tvUseCase.getTVs(pageNumber)
//        )
//
//        return tvsLiveData
//    }

}