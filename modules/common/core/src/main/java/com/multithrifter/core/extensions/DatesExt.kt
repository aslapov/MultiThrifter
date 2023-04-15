package com.multithrifter.core.extensions

import java.util.*

fun Long.toDate() = Date(this)

fun Long.toCalendar() = Date(this).toCalendar()

fun Date.toCalendar(): Calendar {
    val date = this
    return Calendar.getInstance().apply { time = date }
}

fun Date.isSameDate(other: Date): Boolean {
    val one = toCalendar()
    val another = other.toCalendar()
    return one.year == another.year && one.dayOfYear == another.dayOfYear
}

fun Calendar.toMidnight(): Calendar {
    return apply {
        set(Calendar.HOUR_OF_DAY, 0)
        set(Calendar.MINUTE, 0)
        set(Calendar.SECOND, 0)
        set(Calendar.MILLISECOND, 0)
    }
}

fun Calendar.nextDay(): Calendar {
    return apply {
        add(Calendar.DAY_OF_MONTH, 1)
    }
}

val Calendar.year
    get() = get(Calendar.YEAR)

val Calendar.dayOfYear
    get() = get(Calendar.DAY_OF_YEAR)