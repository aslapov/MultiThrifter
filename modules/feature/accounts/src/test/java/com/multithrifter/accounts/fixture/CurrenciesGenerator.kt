package com.multithrifter.accounts.fixture

import com.multithrifter.core.domain.entity.Currency

internal val rub = Currency.default()
internal val usd = Currency("USD", "доллар США", "доллар", "$")
internal val gel = Currency("GEL", "грузинский лари", "лари", "₾")