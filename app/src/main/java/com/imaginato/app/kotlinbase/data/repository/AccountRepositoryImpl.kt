package com.imaginato.app.kotlinbase.data.repository

import com.imaginato.app.kotlinbase.data.source.AccountApi
import com.imaginato.app.kotlinbase.model.response.User
import io.reactivex.Observable

/**
 * Created by xukai on 2018/10/14.
 */
class AccountRepositoryImpl : AccountRepository {

    val accountApi: AccountApi


    constructor(accountApi: AccountApi) {
        this@AccountRepositoryImpl.accountApi = accountApi
    }

    override fun login(params: Map<String, String>): Observable<User> {
        return accountApi.login(params)
                .concatMap { user ->
                    if (user.code == 1) {
                        Observable.just(user)
                    } else {
                        Observable.error<User>(Throwable("error"))
                    }
                }

    }
}