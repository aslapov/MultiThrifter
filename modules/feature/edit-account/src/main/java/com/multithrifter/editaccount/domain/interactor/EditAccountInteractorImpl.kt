package com.multithrifter.editaccount.domain.interactor

import com.multithrifter.core.domain.entity.Account
import com.multithrifter.editaccount.domain.repo.EditAccountRepository
import javax.inject.Inject

internal class EditAccountInteractorImpl @Inject constructor(
    private val repository: EditAccountRepository,
) : EditAccountInteractor {

    override suspend fun editAccount(account: Account) = repository.editAccount(account)
    override suspend fun deleteAccount(accountId: Int) = repository.deleteAccount(accountId)
}