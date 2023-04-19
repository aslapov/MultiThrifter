package com.multithrifter.coretest

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.setMain
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mockito
import org.mockito.junit.jupiter.MockitoExtension
import org.mockito.junit.jupiter.MockitoSettings
import org.mockito.quality.Strictness

@MockitoSettings(strictness = Strictness.LENIENT)
@OptIn(ExperimentalCoroutinesApi::class)
@ExtendWith(value = [MockitoExtension::class])
abstract class CoreTest {

    /**
     * Выполняет корутины сразу. Аналог использованию runBlockingTest
     */
    val unconfinedTestDispatcher = UnconfinedTestDispatcher().apply {
        Dispatchers.setMain(this)
    }

    /**
     * Все добавляемые корутины добавляет в состоянии паузы
     */
    val standardTestDispatcher = StandardTestDispatcher()

    fun <T> any(type: Class<T>): T = Mockito.any<T>(type)

    inline fun <reified T> any() = any(T::class.java)
}