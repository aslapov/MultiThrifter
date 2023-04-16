package com.multithrifter.accounts.domain.interactor

import com.multithrifter.accounts.domain.entity.TotalEntity
import com.multithrifter.accounts.domain.repo.AccountsRepository
import com.multithrifter.core.domain.entity.Account
import com.multithrifter.core.domain.entity.Currency
import com.multithrifter.core.extensions.sumOf
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flatMapMerge
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.transform
import javax.inject.Inject

internal class AccountsInteractorImpl @Inject constructor(
    private val repository: AccountsRepository,
) : AccountsInteractor {

    override val accountsFlow: Flow<List<Account>> = repository.accounts

    override val totalsFlow: Flow<List<TotalEntity>>
        get() = accountsFlow.transform { accounts ->
            val totalsByCurrency = accounts
                .groupBy { it.currency }
                .mapValues { it.toTotalEntity() }
                .values

            emit(totalsByCurrency.toList())
        }

    override val totalsByCurrencyFlow: Flow<List<TotalEntity>>
        get() = totalsFlow
            .flatMapMerge { totals ->
                val totalCurrencyIds = totals.map { it.currency.id }.toSet()
                repository.getLatestCurrencyRateGroups(totalCurrencyIds)
                    .map { it to totals }
            }
            .filter { (exchangeRates, totals) ->
                val totalCurrenciesSize = totals.map { it.currency.id }.toSet().size

                // проверка того, что присутствуют все пары курсов
                exchangeRates.size == (totalCurrenciesSize * (totalCurrenciesSize - 1))
            }
            .transform { (exchangeRates, totals) ->
                val result = mutableListOf<TotalEntity>()

                totals.forEach { total ->
                    var sum = total.amount
                    exchangeRates.filter { it.sourceCurrency == total.currency }
                        .forEach { rate ->
                            val currencyAmount = totals.findAmountByCurrency(rate.targetCurrency)
                            sum += rate.rate * currencyAmount
                        }
                    result.add(TotalEntity(sum, total.currency))
                }

                emit(result)
            }

    private fun Map.Entry<Currency, List<Account>>.toTotalEntity(): TotalEntity {
        val (currency, accounts) = this
        return TotalEntity(
            amount = accounts.sumOf { it.balance },
            currency = currency
        )
    }

    private fun List<TotalEntity>.findAmountByCurrency(currency: Currency): Float {
        return first { it.currency == currency }.amount
    }
}