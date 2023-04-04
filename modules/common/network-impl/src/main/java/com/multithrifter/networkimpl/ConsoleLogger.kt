package com.multithrifter.networkimpl

import com.multithrifter.networkapi.NetworkLogger
import timber.log.Timber

class ConsoleLogger : NetworkLogger {

    override fun log(message: String) {
        Timber.i(message)
    }
}