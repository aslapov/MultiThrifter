package com.multithrifter.core.di

/**
 * Интерфейс для предоставления зависимостей фичи
 */
fun interface ModuleDependenciesProvider<out T> {

    fun getDependencies(): T
}