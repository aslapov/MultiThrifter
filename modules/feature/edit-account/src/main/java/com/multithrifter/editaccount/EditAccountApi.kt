package com.multithrifter.editaccount

import com.multithrifter.core.domain.entity.Account

interface EditAccountApi {
    fun showEditAccountScreen(account: Account)
}