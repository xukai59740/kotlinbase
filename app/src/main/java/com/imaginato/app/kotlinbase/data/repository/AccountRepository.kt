package com.imaginato.app.kotlinbase.data.repository

import com.imaginato.app.kotlinbase.model.response.User
import io.reactivex.Observable

/**
 * Created by xukai on 2018/10/14.
 */
interface AccountRepository {

    fun login(params: Map<String, String>): Observable<User>

    fun saveLogin(user: User): Observable<Boolean>


    fun readLogin(): Observable<User?>
}