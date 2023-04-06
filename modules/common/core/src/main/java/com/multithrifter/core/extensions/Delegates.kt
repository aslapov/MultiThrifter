package com.multithrifter.core.extensions

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 * Возвращает делегат, который при первом чтении переменной возвращает значение,
 * полученное в результате вызова @param[createFunction],
 * сохраняет это значение в переменной и возвращает его же при последующих обращениях к переменной
 * */
fun <T> demand(createFunction: () -> T): ReadWriteProperty<Any?, T> = ByDemandDelegate(createFunction)

private class ByDemandDelegate<T>(private val createFunction: () -> T) : ReadWriteProperty<Any?, T> {
    private var value: T? = null

    override fun getValue(thisRef: Any?, property: KProperty<*>): T = value ?: createFunction().also(::value::set)

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
        this.value = value
    }
}