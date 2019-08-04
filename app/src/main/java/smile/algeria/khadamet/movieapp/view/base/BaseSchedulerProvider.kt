package smile.algeria.khadamet.movieapp.view.base

import io.reactivex.Scheduler


interface BaseSchedulerProvider {

    fun io(): Scheduler

    fun ui(): Scheduler

}