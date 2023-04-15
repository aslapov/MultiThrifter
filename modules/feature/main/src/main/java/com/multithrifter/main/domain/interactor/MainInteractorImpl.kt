package com.multithrifter.main.domain.interactor

import com.multithrifter.main.domain.repo.MainRepository
import javax.inject.Inject

internal class MainInteractorImpl @Inject constructor(
    private val repository: MainRepository,
) : MainInteractor {
    override suspend fun updateCurrencyRates() = repository.updateCurrencyRates()
}