package com.multithrifter.accounts.fixture

import com.multithrifter.core.domain.entity.ExchangeRate
import com.multithrifter.dbapi.dto.ExchangeRateDto
import kotlinx.coroutines.flow.flowOf
import java.util.Date

private const val someDateTime = 1L
private val someDate = Date(someDateTime)

internal val rubToUsdRateDto = ExchangeRateDto(
    sourceCurrencyId = rub.id,
    sourceCurrencyName = rub.name,
    sourceCurrencyShortName = rub.shortName,
    sourceCurrencySymbol = rub.symbol,
    targetCurrencyId = usd.id,
    targetCurrencyName = usd.name,
    targetCurrencyShortName = usd.shortName,
    targetCurrencySymbol = usd.symbol,
    rate = 80f,
    date = someDateTime,
)

internal val usdToRubRateDto = ExchangeRateDto(
    sourceCurrencyId = usd.id,
    sourceCurrencyName = usd.name,
    sourceCurrencyShortName = usd.shortName,
    sourceCurrencySymbol = usd.symbol,
    targetCurrencyId = rub.id,
    targetCurrencyName = rub.name,
    targetCurrencyShortName = rub.shortName,
    targetCurrencySymbol = rub.symbol,
    rate = 1 / 80f,
    date = someDateTime,
)

internal val rubToGelRateDto = ExchangeRateDto(
    sourceCurrencyId = rub.id,
    sourceCurrencyName = rub.name,
    sourceCurrencyShortName = rub.shortName,
    sourceCurrencySymbol = rub.symbol,
    targetCurrencyId = gel.id,
    targetCurrencyName = gel.name,
    targetCurrencyShortName = gel.shortName,
    targetCurrencySymbol = gel.symbol,
    rate = 25f,
    date = someDateTime,
)

internal val gelToRubRateDto = ExchangeRateDto(
    sourceCurrencyId = gel.id,
    sourceCurrencyName = gel.name,
    sourceCurrencyShortName = gel.shortName,
    sourceCurrencySymbol = gel.symbol,
    targetCurrencyId = rub.id,
    targetCurrencyName = rub.name,
    targetCurrencyShortName = rub.shortName,
    targetCurrencySymbol = rub.symbol,
    rate = 1 / 25f,
    date = someDateTime,
)

internal val usdToGelRateDto = ExchangeRateDto(
    sourceCurrencyId = usd.id,
    sourceCurrencyName = usd.name,
    sourceCurrencyShortName = usd.shortName,
    sourceCurrencySymbol = usd.symbol,
    targetCurrencyId = gel.id,
    targetCurrencyName = gel.name,
    targetCurrencyShortName = gel.shortName,
    targetCurrencySymbol = gel.symbol,
    rate = 0.4f,
    date = someDateTime,
)

internal val gelToUsdRateDto = ExchangeRateDto(
    sourceCurrencyId = gel.id,
    sourceCurrencyName = gel.name,
    sourceCurrencyShortName = gel.shortName,
    sourceCurrencySymbol = gel.symbol,
    targetCurrencyId = usd.id,
    targetCurrencyName = usd.name,
    targetCurrencyShortName = usd.shortName,
    targetCurrencySymbol = usd.symbol,
    rate = 2.5f,
    date = someDateTime,
)

internal val exchangeRatesDto = listOf(
    rubToUsdRateDto,
    usdToRubRateDto,
    rubToGelRateDto,
    gelToRubRateDto,
    usdToGelRateDto,
    gelToUsdRateDto,
)

internal val exchangeRatesFlow = flowOf(exchangeRatesDto)

internal val rubToUsd = ExchangeRate(
    sourceCurrency = rub,
    targetCurrency = usd,
    rate = 80f,
    date = someDate,
)

internal val usdToRub = ExchangeRate(
    sourceCurrency = usd,
    targetCurrency = rub,
    rate = 1 / 80f,
    date = someDate,
)

internal val rubToGel = ExchangeRate(
    sourceCurrency = rub,
    targetCurrency = gel,
    rate = 25f,
    date = someDate,
)

internal val gelToRub = ExchangeRate(
    sourceCurrency = gel,
    targetCurrency = rub,
    rate = 1 / 25f,
    date = someDate,
)

internal val usdToGel = ExchangeRate(
    sourceCurrency = usd,
    targetCurrency = gel,
    rate = 0.4f,
    date = someDate,
)

internal val gelToUsd = ExchangeRate(
    sourceCurrency = gel,
    targetCurrency = usd,
    rate = 2.5f,
    date = someDate,
)

internal val exchangeRates = listOf(rubToUsd, usdToRub, rubToGel, gelToRub, usdToGel, gelToUsd)