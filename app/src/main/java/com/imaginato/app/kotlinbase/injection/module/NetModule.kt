package com.imaginato.app.kotlinbase.injection.module

import com.google.gson.Gson
import com.imaginato.app.kotlinbase.BuildConfig
import com.imaginato.app.kotlinbase.data.repository.AccountRepository
import com.imaginato.app.kotlinbase.data.repository.AccountRepositoryImpl
import com.imaginato.app.kotlinbase.data.source.AccountApi
import com.imaginato.app.kotlinbase.data.source.AccountLocal
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

/**
 * Created by xukai on 2018/10/13.
 */
@Module
class NetModule {

    @Provides
    @Singleton
    @Named("DefaultRetrofit")
    fun provideDefaultRetrofit(@Named("DefaultOkHttpClient") okHttpClient: OkHttpClient): Retrofit {
        val retrofit = Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_SERVER)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create(Gson()))
                .build()
        return retrofit
    }

    @Provides
    @Singleton
    @Named("DefaultOkHttpClient")
    fun provideHttpClient(): OkHttpClient {
        val httpClient = OkHttpClient.Builder()
        return httpClient.build()
    }

    // Account
    @Provides
    @Singleton
    fun provideAccountApi(@Named("DefaultRetrofit") retrofit: Retrofit): AccountApi {
        return retrofit.create(AccountApi::class.java)
    }

    @Provides
    @Singleton
    fun provideAccountLocal(): AccountLocal {
        return AccountLocal()
    }

    @Provides
    @Singleton
    fun provideAccountRepository(accountApi: AccountApi, accountLocal: AccountLocal): AccountRepository {
        return AccountRepositoryImpl(accountApi, accountLocal)
    }

}