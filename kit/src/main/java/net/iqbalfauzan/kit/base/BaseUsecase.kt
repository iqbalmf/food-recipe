package net.iqbalfauzan.kit.base

import io.reactivex.Completable
import io.reactivex.Maybe
import io.reactivex.Scheduler
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableCompletableObserver
import io.reactivex.observers.DisposableMaybeObserver
import io.reactivex.observers.DisposableSingleObserver
import net.iqbalfauzan.kit.extension.disposedBy

/**
 * Created by Iqbalmf on 2019-08-08
 */
abstract class BaseUsecase<out Type, in Params> protected constructor(
    private val threadExecutor: Scheduler,
    private val postExecutionThread: Scheduler) {

    protected val disposables = CompositeDisposable()

    abstract fun build(params: Params?): Type

    fun dispose() = disposables.dispose()

    abstract class RxSingle<T, in P> protected constructor(
        private val threadExecutor: Scheduler,
        private val postExecutionThread: Scheduler)
        : BaseUsecase<Single<T>, P>(threadExecutor, postExecutionThread) {
        fun execute(observer: DisposableSingleObserver<T>, params: P? = null) {
            build(params)
                .subscribeOn(threadExecutor)
                .observeOn(postExecutionThread)
                .subscribeWith(observer)
                .disposedBy(disposables)
        }
    }

    abstract class RxCompletable<in P> protected constructor(
        private val threadExecutor: Scheduler,
        private val postExecutionThread: Scheduler)
        : BaseUsecase<Completable, P>(threadExecutor, postExecutionThread) {
        fun execute(observer: DisposableCompletableObserver, params: P? = null) {
            build(params)
                .subscribeOn(threadExecutor)
                .observeOn(postExecutionThread)
                .subscribeWith(observer)
                .disposedBy(disposables)
        }
    }

    abstract class RxMaybe<T, in P> protected constructor(
        private val threadExecutor: Scheduler,
        private val postExecutionThread: Scheduler)
        : BaseUsecase<Maybe<T>, P>(threadExecutor, postExecutionThread) {
        fun execute(observer: DisposableMaybeObserver<T>, params: P? = null) {
            build(params)
                .subscribeOn(threadExecutor)
                .observeOn(postExecutionThread)
                .subscribeWith(observer)
                .disposedBy(disposables)
        }
    }
}