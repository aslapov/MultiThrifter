package com.multithrifter.incomes

import com.multithrifter.incomes.presentation.navigation.Router
import javax.inject.Inject

class IncomesApiImpl @Inject constructor(
    private val router: Router,
) : IncomesApi {

    override fun showIncomesScreen() {
        router.showIncomesScreen()
    }
}