package com.multithrifter.app.mediators

import androidx.annotation.MainThread
import com.multithrifter.accounts.AccountsDependencies
import com.multithrifter.accounts.AccountsFeature
import com.multithrifter.accounts.CreateAccountActions
import com.multithrifter.accounts.EditAccountActions
import com.multithrifter.core.di.ModuleDependenciesProvider

class AccountsMediator {

    init {
        AccountsFeature.dependenciesProvider = ModuleDependenciesProvider {
            getDependencies()
        }
    }

    @MainThread
    fun getApi() = AccountsFeature.getApi()

    private fun getDependencies(): AccountsDependencies {
        return object : AccountsDependencies {
            override fun getCreateAccountActions(): CreateAccountActions {
                return object : CreateAccountActions {
                    override fun showCreateAccountScreen() {

                    }
                }
            }

            override fun getEditAccountActions(): EditAccountActions {
                return object : EditAccountActions {
                    override fun showEditAccountScreen() {

                    }
                }
            }
        }
    }
}