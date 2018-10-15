package com.imaginato.app.kotlinbase.ui.base

import android.app.Application
import com.imaginato.app.kotlinbase.data.realm.SchemaMigration
import io.realm.Realm
import io.realm.RealmConfiguration

/**
 * Created by xukai on 2018/10/13.
 */
class BaseApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        initRealm()
        initializeComponents()
    }

    private fun initRealm() {
        Realm.init(this)
        val realmConfiguration = RealmConfiguration.Builder()
                .schemaVersion(SchemaMigration.SCHEMA_VERSION)
                .migration(SchemaMigration())
                .build()
        Realm.setDefaultConfiguration(realmConfiguration)
    }

    private fun initializeComponents() {

    }
}