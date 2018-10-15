package com.imaginato.app.kotlinbase.data.realm

import io.realm.DynamicRealm
import io.realm.RealmMigration

/**
 * Created by xukai on 2018/10/14.
 */
class SchemaMigration : RealmMigration {
    companion object {
        val SCHEMA_VERSION: Long = 1
    }

    override fun migrate(realm: DynamicRealm?, oldVersion: Long, newVersion: Long) {

    }
}