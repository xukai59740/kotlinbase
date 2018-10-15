package com.imaginato.app.kotlinbase.model.mapper

import com.imaginato.app.kotlinbase.model.realm.UserRealm
import com.imaginato.app.kotlinbase.model.response.User

/**
 * Created by xukai on 2018/10/14.
 */
class UserMapper {
    companion object {

        fun convertUserToUserRealm(user: User): UserRealm {
            var userRealm = UserRealm()
            userRealm.userId = user.id
            userRealm.firstName = user.firstName
            userRealm.lastName = user.lastName
            return userRealm
        }

        fun convertUserRealmToUser(userRealm: UserRealm): User {
            var user = User()
            user.id = userRealm.userId
            user.firstName = userRealm.firstName
            user.lastName = userRealm.lastName
            return user
        }
    }
}