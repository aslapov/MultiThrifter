package com.multithrifter.core.extensions

import android.os.Bundle

inline fun <reified T> Bundle.getValue(key: String): T? {
    return get(key) as? T
}

inline fun <reified T : Any> Bundle.getRequiredValue(key: String): T {
    return requireNotNull(getValue<T>(key)) {
        "No value found by key: $key. Check argument KEY and value type"
    }
}