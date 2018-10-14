package com.imaginato.app.kotlinbase.model.realm

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

/**
 * Created by xukai on 2018/10/14.
 */
open class UserRealm : RealmObject {

    @PrimaryKey
    var id = "1"

    lateinit var userId :String

    var firstName: String? = null

    var lastName: String? = null

    constructor()


}