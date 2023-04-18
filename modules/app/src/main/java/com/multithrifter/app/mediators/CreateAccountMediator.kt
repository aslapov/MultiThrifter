package com.multithrifter.app.mediators

import androidx.annotation.MainThread
import com.multithrifter.core.di.ModuleDependenciesProvider
import com.multithrifter.core.domain.entity.Currency
import com.multithrifter.createaccount.CreateAccountDependencies
import com.multithrifter.createaccount.CreateAccountFeature
import com.multithrifter.createaccount.CurrenciesActions
import kotlinx.coroutines.flow.MutableSharedFlow

class CreateAccountMediator {

    init {
        CreateAccountFeature.dependenciesProvider = ModuleDependenciesProvider {
            getDependencies()
        }
    }

    @MainThread
    fun getApi() = CreateAccountFeature.getApi()

    private fun getDependencies(): CreateAccountDependencies {
        return object : CreateAccountDependencies {
            override fun getCurrenciesActions(): CurrenciesActions {
                return object : CurrenciesActions {
                    override fun showCurrenciesScreen(
                        selectedCurrencyListener: MutableSharedFlow<Currency>,
                        selectedCurrency: Currency?,
                    ) {
                        MediatorManager.selectCurrencyMediator.getApi(selectedCurrencyListener)
                            .showSelectCurrencyScreen(selectedCurrency)
                    }
                }
            }
        }
    }
}