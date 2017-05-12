package com.voltek.newsfeed.domain.interactor

import com.voltek.newsfeed.utils.CompositeDisposableComponent
import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.Action
import io.reactivex.functions.Consumer

abstract class BaseInteractor<ResultType : Any?, in ParameterType>(
        protected val jobScheduler: Scheduler,
        protected val uiScheduler: Scheduler
) : CompositeDisposableComponent {

    override val mDisposable = CompositeDisposable()

    protected abstract fun buildObservable(parameter: Parameter<ParameterType?>): Observable<Result<ResultType>>

    /**
     * @param parameter pass null, if parameter does not needed
     */
    fun execute(
            parameter: Parameter<ParameterType?>,
            onNext: Consumer<Result<ResultType>>,
            onError: Consumer<Throwable>,
            onComplete: Action
    ) {
        buildObservable(parameter)
                .subscribeOn(jobScheduler)
                .observeOn(uiScheduler)
                .subscribe(onNext, onError, onComplete)
                .bind()
    }

    fun unsubscribe() {
        resetCompositeDisposable()
    }
}