package com.multithrifter.selectcurrency.domain.interactor

import com.multithrifter.selectcurrency.domain.repo.SelectCurrencyRepository
import javax.inject.Inject

internal class SelectCurrencyInteractorImpl @Inject constructor(
    private val repository: SelectCurrencyRepository,
) : SelectCurrencyInteractor {

    override suspend fun getCurrencies() = repository.getCurrencies()
}