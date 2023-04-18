package com.multithrifter.app.mediators

import androidx.annotation.MainThread
import com.multithrifter.core.di.ModuleDependenciesProvider
import com.multithrifter.core.domain.entity.Currency
import com.multithrifter.selectcurrency.SelectCurrencyDependencies
import com.multithrifter.selectcurrency.SelectCurrencyFeature
import com.multithrifter.selectcurrency.SelectedCurrencyListenerActions

class SelectCurrencyMediator {

    init {
        SelectCurrencyFeature.dependenciesProvider = ModuleDependenciesProvider {
            getDependencies()
        }
    }

    @MainThread
    fun getApi() = SelectCurrencyFeature.getApi()

    private fun getDependencies(): SelectCurrencyDependencies {
        return object : SelectCurrencyDependencies {

            override fun getSelectedCurrencyListenerActions(): SelectedCurrencyListenerActions {
                return object : SelectedCurrencyListenerActions {

                    override fun updateSelectedCurrency(currency: Currency) {
                        MediatorManager.createAccountMediator.getApi().updateSelectedCurrency(currency)
                    }
                }
            }
        }
    }
}