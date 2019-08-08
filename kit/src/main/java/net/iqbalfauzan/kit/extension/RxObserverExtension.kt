package net.iqbalfauzan.kit.extension

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableCompletableObserver
import io.reactivex.observers.DisposableMaybeObserver
import io.reactivex.observers.DisposableSingleObserver

/**
 * Created by Iqbalmf on 2019-08-08
 */
fun <T> DisposableMaybeObserver<T>.disposedBy(compositeDisposable: CompositeDisposable) {
    compositeDisposable.add(this)
}

fun <T> DisposableSingleObserver<T>.disposedBy(compositeDisposable: CompositeDisposable) {
    compositeDisposable.add(this)
}

fun DisposableCompletableObserver.disposedBy(compositeDisposable: CompositeDisposable) {
    compositeDisposable.add(this)
}

fun Disposable.disposedBy(compositeDisposable: CompositeDisposable) {
    compositeDisposable.add(this)
}