package com.multithrifter.accounts.data.mapper

import com.multithrifter.accounts.fixture.exchangeRates
import com.multithrifter.accounts.fixture.exchangeRatesDto
import com.multithrifter.accounts.fixture.rubToUsd
import com.multithrifter.accounts.fixture.rubToUsdRateDto
import com.multithrifter.coretest.CoreTest
import org.assertj.core.api.BDDAssertions.then
import org.junit.jupiter.api.Test

internal class CurrencyRateMapperImplTest : CoreTest() {

    private val mapper: CurrencyRateMapper by lazy { CurrencyRateMapperImpl() }

    @Test
    fun `when map usd account - then appropriate mapping`() {
        // Given
        val from = rubToUsdRateDto

        // When
        val result = mapper.map(from)

        // Then
        then(result).isEqualTo(rubToUsd)
    }

    @Test
    fun `when map list of accounts - then appropriate list result`() {
        // Given
        val from = exchangeRatesDto

        // When
        val result = from.map(mapper::map)

        // Then
        then(result).isEqualTo(exchangeRates)
    }
}