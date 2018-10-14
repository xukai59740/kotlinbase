package com.imaginato.app.kotlinbase.data

import com.google.gson.Gson
import com.imaginato.app.kotlinbase.BuildConfig
import com.imaginato.app.kotlinbase.data.source.AccountApi
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named

/**
 * Created by xukai on 2018/10/14.
 */
class RetrofitFactory {

    companion object {

         var retrofit : Retrofit

        init {
            retrofit=provideDefaultRetrofit()
        }

        fun provideDefaultRetrofit(): Retrofit {
            val retrofit = Retrofit.Builder()
                    .baseUrl(BuildConfig.BASE_SERVER)
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .client(createHttpClient())
                    .addConverterFactory(GsonConverterFactory.create(Gson()))
                    .build()
            return retrofit
        }

        private fun createHttpClient(): OkHttpClient {
            val httpClient = OkHttpClient.Builder()
            return httpClient.build()
        }

        fun provideAccountApi():AccountApi{
            return retrofit.create(AccountApi::class.java)
        }

    }


}