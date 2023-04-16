package com.multithrifter.accounts.data.mapper

import com.multithrifter.core.domain.entity.Account
import com.multithrifter.core.domain.entity.Currency
import com.multithrifter.core.mapper.Mapper
import com.multithrifter.dbapi.dto.AccountDto
import java.util.*
import javax.inject.Inject

internal interface AccountMapper: Mapper<AccountDto, Account>

internal class AccountMapperImpl @Inject constructor(): AccountMapper {

    override fun map(from: AccountDto): Account {
        return Account(
            id = from.id,
            name = from.name,
            balance = from.balance,
            currency = Currency(
                id = from.currencyId,
                name = from.currencyName,
                shortName = from.currencyShortName,
                symbol = from.currencySymbol,
            )
        )
    }
}