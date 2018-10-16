package com.imaginato.app.kotlinbase.data.source

import com.imaginato.app.kotlinbase.model.response.User
import io.reactivex.Observable

/**
 * Created by img on 2018/10/16.
 */
class CommonMock{

    fun mockLoginSuccess(): Observable<User> {
        var user = User()
        user.firstName = "test firstName"
        user.lastName = "test lastName"
        user.id = "1111"
        return Observable.just(user)
    }
}