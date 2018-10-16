package com.imaginato.app.kotlinbase.data.repository

import com.imaginato.app.kotlinbase.data.source.AccountApi
import com.imaginato.app.kotlinbase.data.source.AccountLocal
import com.imaginato.app.kotlinbase.data.source.CommonMock
import com.imaginato.app.kotlinbase.model.response.User
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by xukai on 2018/10/14.
 */
class AccountRepositoryImpl : AccountRepository {

    val accountApi: AccountApi

    val accountLocal: AccountLocal

    val commonMock: CommonMock

    @Inject constructor(accountApi: AccountApi, accountLocal: AccountLocal, commonMock: CommonMock) {
        this@AccountRepositoryImpl.accountApi = accountApi
        this@AccountRepositoryImpl.accountLocal = accountLocal
        this@AccountRepositoryImpl.commonMock = commonMock
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
        return commonMock.mockLoginSuccess()
                .concatMap { user ->
                    saveLogin(user)
                    Observable.just(user)
                }
    }

    override fun saveLogin(user: User): Observable<Boolean> {
        return accountLocal.writeUser(user)
    }

    override fun readLogin(): Observable<User?> {
        return accountLocal.readUser()
    }
}