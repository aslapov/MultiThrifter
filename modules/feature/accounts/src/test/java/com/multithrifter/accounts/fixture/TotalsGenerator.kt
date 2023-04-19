package com.multithrifter.accounts.fixture

import com.multithrifter.accounts.domain.entity.TotalEntity

internal val rubTotal = TotalEntity(amount = 2000f, currency = rub)
internal val usdTotal = TotalEntity(amount = 1000f, currency = usd)
internal val gelTotal = TotalEntity(amount = 1000f, currency = gel)
internal val totals = listOf(rubTotal, usdTotal, gelTotal)

internal val totalInRub = TotalEntity(amount = 2000f + 80000f + 25000f, currency = rub)
internal val totalInUsd = TotalEntity(amount = 1000f + 25f + 400f, currency = usd)
internal val totalInGel = TotalEntity(amount = 1000f + 80f + 2500f, currency = gel)
internal val totalsByCurrency = listOf(totalInRub, totalInUsd, totalInGel)