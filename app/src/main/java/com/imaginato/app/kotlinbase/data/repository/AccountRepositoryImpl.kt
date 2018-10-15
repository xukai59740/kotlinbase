package com.imaginato.app.kotlinbase.data.repository

import android.util.Log
import com.imaginato.app.kotlinbase.data.source.AccountApi
import com.imaginato.app.kotlinbase.data.source.AccountLocal
import com.imaginato.app.kotlinbase.model.response.User
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by xukai on 2018/10/14.
 */
class AccountRepositoryImpl : AccountRepository {

    val accountApi: AccountApi

    val accountLocal: AccountLocal


    @Inject constructor(accountApi: AccountApi, accountLocal: AccountLocal) {
        this@AccountRepositoryImpl.accountApi = accountApi
        this@AccountRepositoryImpl.accountLocal = accountLocal
    }

    override fun login(params: Map<String, String>): Observable<User> {
//        return accountApi.login(params)
//                .concatMap { user ->
//                    if (user.code == 1) {
//                        Observable.just(user)
//                    } else {
//                        Observable.error<User>(Throwable(user.error))
//                    }
//                }
        var user = User()
        user.firstName = "kevin"
        user.lastName = "xu"
        user.id = "123123112"
        saveLogin(user)
        return Observable.just(user)
    }

    override fun saveLogin(user: User): Observable<Boolean> {
        return accountLocal.writeUser(user)
    }

    override fun readLogin(): Observable<User?> {
        return accountLocal.readUser()
    }
}