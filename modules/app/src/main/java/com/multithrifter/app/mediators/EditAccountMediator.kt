package com.multithrifter.app.mediators

import androidx.annotation.MainThread
import com.multithrifter.core.di.ModuleDependenciesProvider
import com.multithrifter.core.domain.entity.Currency
import com.multithrifter.editaccount.EditAccountDependencies
import com.multithrifter.editaccount.EditAccountFeature
import com.multithrifter.editaccount.CurrenciesActions
import kotlinx.coroutines.flow.MutableSharedFlow

class EditAccountMediator {

    init {
        EditAccountFeature.dependenciesProvider = ModuleDependenciesProvider {
            getDependencies()
        }
    }

    @MainThread
    fun getApi() = EditAccountFeature.getApi()

    private fun getDependencies(): EditAccountDependencies {
        return object : EditAccountDependencies {
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