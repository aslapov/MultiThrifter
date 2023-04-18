package com.multithrifter.createaccount

import com.multithrifter.core.domain.entity.Currency
import com.multithrifter.createaccount.domain.repo.CreateAccountRepository
import com.multithrifter.createaccount.presentation.navigation.Router
import javax.inject.Inject

internal class CreateAccountApiImpl @Inject constructor(
    private val router: Router,
    private val repository: CreateAccountRepository,
) : CreateAccountApi {

    override fun showCreateAccountScreen() {
        router.showCreateAccountScreen()
    }

    override fun updateSelectedCurrency(currency: Currency) {
        repository.updateSelectedCurrency(currency)
    }
}