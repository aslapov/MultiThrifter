package com.multithrifter.accounts.data.mapper

import com.multithrifter.core.domain.entity.Currency
import com.multithrifter.core.domain.entity.ExchangeRate
import com.multithrifter.core.mapper.Mapper
import com.multithrifter.dbapi.dto.ExchangeRateDto
import java.util.*
import javax.inject.Inject

internal interface CurrencyRateMapper: Mapper<ExchangeRateDto, ExchangeRate>

internal class CurrencyRateMapperImpl @Inject constructor(): CurrencyRateMapper {

    override fun map(from: ExchangeRateDto): ExchangeRate {
        return ExchangeRate(
            rate = from.rate,
            date = Date(from.date),
            sourceCurrency = Currency(
                id = from.sourceCurrencyId,
                name = from.sourceCurrencyName,
                shortName = from.sourceCurrencyShortName,
                symbol = from.sourceCurrencySymbol,
            ),
            targetCurrency = Currency(
                id = from.targetCurrencyId,
                name = from.targetCurrencyName,
                shortName = from.targetCurrencyShortName,
                symbol = from.targetCurrencySymbol,
            ),
        )
    }
}