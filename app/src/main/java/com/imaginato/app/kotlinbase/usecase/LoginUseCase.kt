package com.imaginato.app.kotlinbase.usecase

import com.imaginato.app.kotlinbase.data.repository.AccountRepository
import com.imaginato.app.kotlinbase.model.response.User
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by img on 2018/10/16.
 */
class LoginUseCase : UseCase<User> {
    private var accountRepository: AccountRepository
    private var map: HashMap<String, String> = HashMap()

    @Inject constructor(accountRepository: AccountRepository) {
        this@LoginUseCase.accountRepository = accountRepository
    }

    fun setParams(email: String) {
        map.put("email", email)
    }

    override fun buildUseCaseObservable(): Observable<User?> {
        return accountRepository.login(map)
    }
}