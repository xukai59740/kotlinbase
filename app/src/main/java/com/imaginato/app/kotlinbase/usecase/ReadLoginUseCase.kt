package com.imaginato.app.kotlinbase.usecase

import com.imaginato.app.kotlinbase.data.repository.AccountRepository
import com.imaginato.app.kotlinbase.model.response.User
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by img on 2018/10/16.
 */
class ReadLoginUseCase : UseCase<User?> {
    private var accountRepository: AccountRepository

    @Inject constructor(accountRepository: AccountRepository) {
        this@ReadLoginUseCase.accountRepository = accountRepository
    }

    override fun buildUseCaseObservable(): Observable<User?> {
        return accountRepository.readLogin()
    }
}