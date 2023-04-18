package com.multithrifter.selectcurrency.presentation.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.multithrifter.core.domain.entity.Currency
import com.multithrifter.core.extensions.conditional
import com.multithrifter.selectcurrency.R
import com.multithrifter.selectcurrency.presentation.viewmodel.SelectCurrencyContract.SelectCurrencyEvent
import com.multithrifter.selectcurrency.presentation.viewmodel.SelectCurrencyContract.SelectCurrencyEvent.BackClicked
import com.multithrifter.selectcurrency.presentation.viewmodel.SelectCurrencyContract.SelectCurrencyEvent.CurrencySelected
import com.multithrifter.selectcurrency.presentation.viewmodel.SelectCurrencyContract.SelectCurrencyState
import com.multithrifter.ui.MultiThrifterColors
import com.multithrifter.ui.MultiThrifterTheme
import com.multithrifter.ui.R as UiR

@Composable
internal fun SelectCurrencyScreen(
    state: SelectCurrencyState,
    onEvent: (SelectCurrencyEvent) -> Unit,
) {
    Scaffold(
        topBar = {
            TopBar { onEvent(BackClicked) }
        },
        modifier = Modifier.fillMaxSize(),
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            itemsIndexed(state.currencies) { index, currency ->
                CurrencyItem(
                    currency = currency,
                    isSelected = currency == state.selectedCurrency,
                    onSelectCurrency = { onEvent(CurrencySelected(it)) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .conditional(index % 2 != 0) {
                            background(MultiThrifterColors.secondary)
                        },
                )
            }
        }
    }
}

@Composable
private fun TopBar(
    onClickBack: () -> Unit,
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(MultiThrifterColors.Primary)
            .defaultMinSize(minHeight = 56.dp)
            .padding(horizontal = 16.dp),
    ) {
        Text(
            text = stringResource(id = R.string.currencies),
            color = Color.White,
            style = MaterialTheme.typography.h2,
            modifier = Modifier.align(Alignment.Center),
        )
        IconButton(
            onClick = onClickBack,
            modifier = Modifier.align(Alignment.CenterStart),
        ) {
            Icon(
                painter = painterResource(id = UiR.drawable.ic_back),
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier.size(24.dp),
            )
        }
    }
}

@Composable
private fun CurrencyItem(
    currency: Currency,
    onSelectCurrency: (Currency) -> Unit,
    modifier: Modifier = Modifier,
    isSelected: Boolean = false,
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .clickable { onSelectCurrency(currency) }
            .padding(16.dp),
    ) {
        Text(
            text = currency.name,
            style = MaterialTheme.typography.body1,
        )
        Row {
            Text(
                text = currency.symbol,
                style = MaterialTheme.typography.body1,
            )
            if (isSelected) {
                Icon(
                    painter = painterResource(id = UiR.drawable.ic_ok),
                    contentDescription = null,
                    tint = MultiThrifterColors.Primary,
                    modifier = Modifier
                        .padding(start = 16.dp)
                        .size(24.dp),
                )
            }
        }
    }
}

@Preview
@Composable
private fun SelectCurrencyScreenPreview() {
    MultiThrifterTheme {
        val currency = Currency.default()
        SelectCurrencyScreen(
            state = SelectCurrencyState(
                currencies = listOf(currency, currency),
                selectedCurrency = currency,
            ),
            onEvent = {},
        )
    }
}