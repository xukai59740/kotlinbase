package com.imaginato.app.kotlinbase.data.source

import com.imaginato.app.kotlinbase.model.response.User
import io.reactivex.Observable
import retrofit2.http.*

/**
 * Created by xukai on 2018/10/14.
 */
interface AccountApi {

    @FormUrlEncoded
    @POST("login")
    fun login(@FieldMap params:Map<String, String>): Observable<User>

}