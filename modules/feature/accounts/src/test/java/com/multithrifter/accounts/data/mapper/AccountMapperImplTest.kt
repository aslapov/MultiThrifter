package com.multithrifter.accounts.data.mapper

import com.multithrifter.accounts.fixture.accounts
import com.multithrifter.accounts.fixture.accountsDto
import com.multithrifter.accounts.fixture.usdAccount
import com.multithrifter.accounts.fixture.usdAccountDto
import com.multithrifter.coretest.CoreTest
import org.assertj.core.api.BDDAssertions.then
import org.junit.jupiter.api.Test

internal class AccountMapperImplTest : CoreTest() {

    private val mapper: AccountMapper by lazy { AccountMapperImpl() }

    @Test
    fun `when map usd account - then appropriate mapping`() {
        // Given
        val from = usdAccountDto

        // When
        val result = mapper.map(from)

        // Then
        then(result).isEqualTo(usdAccount)
    }

    @Test
    fun `when map list of accounts - then appropriate list result`() {
        // Given
        val from = accountsDto

        // When
        val result = from.map(mapper::map)

        // Then
        then(result).isEqualTo(accounts)
    }
}