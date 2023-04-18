package com.multithrifter.selectcurrency.data.repo

import com.multithrifter.dbapi.dao.CurrencyDao
import com.multithrifter.selectcurrency.data.mapper.CurrencyMapper
import com.multithrifter.selectcurrency.domain.repo.SelectCurrencyRepository
import javax.inject.Inject

internal class SelectCurrencyRepositoryImpl @Inject constructor(
    private val currencyDao: CurrencyDao,
    private val currencyMapper: CurrencyMapper,
) : SelectCurrencyRepository {

    override suspend fun getCurrencies() = currencyDao.getCurrencies().map(currencyMapper::map)
}