package smile.algeria.khadamet.movieapp.view.base


import androidx.lifecycle.ViewModel
import io.reactivex.Flowable
import io.reactivex.Scheduler
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.functions.Consumer
import org.reactivestreams.Subscription

/**
 *
 * A base view model class that deals with RX threading, dispose them when the view model is cleared and also gives
 * the ability to start more than observable in the same time by adding them in the disposables object.
 */

open class BaseViewModel
constructor(
    baseSchedulerProvider: BaseSchedulerProvider
) : ViewModel() {

    private val subscribeOn: Scheduler = baseSchedulerProvider.io()
    private val observeOn: Scheduler = baseSchedulerProvider.ui()
    private val disposables: CompositeDisposable = CompositeDisposable()

    protected fun <T> execute(
        loadingConsumer: Consumer<Subscription>,
        successConsumer: Consumer<T>,
        throwableConsumer: Consumer<Throwable>,
        useCase: Flowable<T>
    ) {
        val observable = useCase
            .doOnSubscribe(loadingConsumer)
            .subscribeOn(subscribeOn)
            .observeOn(observeOn)
        addDisposable(observable.subscribe(successConsumer, throwableConsumer))
    }

    private fun dispose() {
        if (!disposables.isDisposed) {
            disposables.dispose()
        }
    }

    private fun addDisposable(disposable: Disposable) {
        disposables.add(disposable)
    }

    override fun onCleared() {
        super.onCleared()
        dispose()
    }
}
