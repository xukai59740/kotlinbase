package com.imaginato.app.kotlinbase.ui.base

import android.app.Application
import com.imaginato.app.kotlinbase.data.realm.SchemaMigration
import com.imaginato.app.kotlinbase.injection.component.SingletonComponent
import io.realm.Realm
import io.realm.RealmConfiguration

/**
 * Created by xukai on 2018/10/13.
 */
class BaseApplication : Application() {
    companion object {
        lateinit var singletonComponent: SingletonComponent
        init {
            initializeComponents()
        }
        private fun initializeComponents() {
            singletonComponent = SingletonComponent
                    .Initializer.init()
        }
    }

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

}