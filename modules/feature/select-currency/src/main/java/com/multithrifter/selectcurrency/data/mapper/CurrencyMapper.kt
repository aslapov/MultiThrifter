package com.multithrifter.selectcurrency.data.mapper

import com.multithrifter.core.domain.entity.Currency
import com.multithrifter.core.mapper.Mapper
import com.multithrifter.dbapi.entity.CurrencyDbEntity
import javax.inject.Inject

internal interface CurrencyMapper: Mapper<CurrencyDbEntity, Currency>

internal class CurrencyMapperImpl @Inject constructor(): CurrencyMapper {

    override fun map(from: CurrencyDbEntity): Currency {
        return Currency(
            id = from.id,
            name = from.name,
            shortName = from.shortName,
            symbol = from.symbol,
        )
    }
}