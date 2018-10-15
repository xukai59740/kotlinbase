package com.imaginato.app.kotlinbase.data.source

import android.util.Log
import com.imaginato.app.kotlinbase.model.mapper.UserMapper
import com.imaginato.app.kotlinbase.model.realm.UserRealm
import com.imaginato.app.kotlinbase.model.response.User
import io.reactivex.Observable
import io.realm.Realm

/**
 * Created by xukai on 2018/10/14.
 */
class AccountLocal {

    constructor(){
        Log.d("kevin","create AccountLocal")
    }

    fun writeUser(user: User): Observable<Boolean> {
        val realm = Realm.getDefaultInstance()
        realm.executeTransaction { realmTransaction ->
            var userRealm = UserMapper.convertUserToUserRealm(user)
            realmTransaction.copyToRealmOrUpdate(userRealm)

        }
        realm.close()
        return Observable.just(realm.isClosed)
    }

    fun readUser(): Observable<User?> {
        val realm = Realm.getDefaultInstance()
        var userRealm = realm.where(UserRealm::class.java).findFirst()
        if (userRealm != null) {
            var user = UserMapper.convertUserRealmToUser(userRealm)
            realm.close()
            return Observable.just(user)
        } else {
            return Observable.error(Throwable())
        }
    }
}