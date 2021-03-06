package com.imaginato.app.kotlinbase.data.source

import com.imaginato.app.kotlinbase.model.response.User
import io.reactivex.Observable
import retrofit2.http.FieldMap
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

/**
 * Created by xukai on 2018/10/14.
 */
interface AccountApi {

    @FormUrlEncoded
    @POST("login")
    fun login(@FieldMap params: Map<String, String>): Observable<User?>

}