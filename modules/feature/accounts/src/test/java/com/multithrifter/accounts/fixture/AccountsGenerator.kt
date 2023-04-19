package com.multithrifter.accounts.fixture

import com.multithrifter.core.domain.entity.Account
import com.multithrifter.dbapi.dto.AccountDto
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

internal val rub1AccountDto = AccountDto(
    id = 1,
    name = "rub1",
    balance = 1000f,
    currencyId = rub.id,
    currencyName = rub.name,
    currencyShortName = rub.shortName,
    currencySymbol = rub.symbol,
)

internal val usdAccountDto = AccountDto(
    id = 2,
    name = "usd",
    balance = 1000f,
    currencyId = usd.id,
    currencyName = usd.name,
    currencyShortName = usd.shortName,
    currencySymbol = usd.symbol,
)

internal val gelAccountDto = AccountDto(
    id = 3,
    name = "gel",
    balance = 1000f,
    currencyId = gel.id,
    currencyName = gel.name,
    currencyShortName = gel.shortName,
    currencySymbol = gel.symbol,
)

internal val rub2AccountDto = rub1AccountDto.copy(id = 4, name = "rub2")

internal val accountsDto = listOf(rub1AccountDto, usdAccountDto, gelAccountDto, rub2AccountDto)

internal val accountsDtoFlow: Flow<List<AccountDto>> = flowOf(accountsDto)

internal val rub1Account = Account(
    id = 1,
    name = "rub1",
    balance = 1000f,
    currency = rub,
)

internal val usdAccount = Account(
    id = 2,
    name = "usd",
    balance = 1000f,
    currency = usd,
)

internal val gelAccount = Account(
    id = 3,
    name = "gel",
    balance = 1000f,
    currency = gel,
)

internal val rub2Account = Account(
    id = 4,
    name = "rub2",
    balance = 1000f,
    currency = rub,
)

internal val accounts = listOf(rub1Account, usdAccount, gelAccount, rub2Account)

internal val accountsFlow = flowOf(accounts)