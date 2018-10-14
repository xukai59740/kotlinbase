package com.imaginato.app.kotlinbase.ui.base

import com.imaginato.app.kotlinbase.model.response.User
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers
import org.reactivestreams.Subscription

/**
 * Created by xukai on 2018/10/13.
 */
open class RxPresenter<T : BaseView> : BasePresenter {

    protected var mView: T? = null

    private val compositeDisposable = CompositeDisposable()

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
    fun <E>execute(observable:  Observable<E>, disposableObserver: DisposableObserver<E>): DisposableObserver<E> {
        val disposableObserver= observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(disposableObserver)
        compositeDisposable.add(disposableObserver)
        return disposableObserver
    }

    fun unsubscribe() {
        if (!compositeDisposable.isDisposed) {
            compositeDisposable.dispose()
            compositeDisposable.clear()
        }
    }
}