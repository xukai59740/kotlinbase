package com.imaginato.app.kotlinbase.ui.base

import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers

/**
 * Created by xukai on 2018/10/13.
 */
open class RxPresenter<T : BaseView> : BasePresenter {

    protected var mView: T? = null

    private val compositeDisposable = CompositeDisposable()

    @Suppress("UNCHECKED_CAST")
    override fun attachView(view: BaseView) {
       mView = view as T
    }

    override fun detachView() {
        unsubscribe()
        this.mView = null
    }

    /**
     * Change Schedulers or add compose
     */
    fun <E> execute(observable: Observable<E>, disposableObserver: DisposableObserver<E>): DisposableObserver<E> {
        val disposable = observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(disposableObserver)
        compositeDisposable.add(disposable)
        return disposable
    }

    fun unsubscribe() {
        if (!compositeDisposable.isDisposed) {
            compositeDisposable.dispose()
            compositeDisposable.clear()
        }
    }
}