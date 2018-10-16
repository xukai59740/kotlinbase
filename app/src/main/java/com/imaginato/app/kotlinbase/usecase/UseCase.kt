package com.imaginato.app.kotlinbase.usecase

import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers

/**
 * Created by img on 2018/10/16.
 */
abstract class UseCase<T> {
    private val compositeDisposable = CompositeDisposable()

    fun execute(disposableObserver: DisposableObserver<T?>): DisposableObserver<T?> {
        val disposable = buildUseCaseObservable()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(disposableObserver)
        compositeDisposable.add(disposable)
        return disposable
    }

    protected abstract fun buildUseCaseObservable(): Observable<T?>

    fun unsubscribe() {
        if (!compositeDisposable.isDisposed) {
            compositeDisposable.dispose()
            compositeDisposable.clear()
        }
    }
}