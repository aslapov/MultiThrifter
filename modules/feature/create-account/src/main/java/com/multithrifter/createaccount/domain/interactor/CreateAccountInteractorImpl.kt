package com.multithrifter.createaccount.domain.interactor

import com.multithrifter.core.domain.entity.Account
import com.multithrifter.createaccount.domain.repo.CreateAccountRepository
import javax.inject.Inject

internal class CreateAccountInteractorImpl @Inject constructor(
    private val repository: CreateAccountRepository,
) : CreateAccountInteractor {

    override suspend fun createAccount(account: Account) = repository.createAccount(account)
    override suspend fun getCurrencies() = repository.getCurrencies()
}