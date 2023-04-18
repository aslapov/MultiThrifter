package com.multithrifter.accounts.presentation.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.multithrifter.accounts.R
import com.multithrifter.accounts.domain.entity.TotalEntity
import com.multithrifter.accounts.presentation.viewmodel.AccountsContract.AccountsState
import com.multithrifter.core.domain.entity.Account
import com.multithrifter.core.domain.entity.Currency
import com.multithrifter.core.extensions.conditional
import com.multithrifter.ui.MultiThrifterColors
import com.multithrifter.ui.MultiThrifterTheme

@Composable
internal fun AccountsScreen(
    state: AccountsState,
    onClickCreateAccount: () -> Unit,
    onClickAccount: (Account) -> Unit,
) {
    var isTransfersMenu by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            AccountsTopBar(
                isTransfersMenu = isTransfersMenu,
                onChangeMenu = { isTransfersMenu = it },
                onClickCreateAccount = onClickCreateAccount,
            )
        },
        modifier = Modifier.fillMaxSize(),
    ) { paddingValues ->
        if (isTransfersMenu) {

        } else {
            AccountsMenuContent(
                accounts = state.accounts,
                totals = state.totals,
                totalsByCurrency = state.totalsByCurrency,
                onClickAccount = onClickAccount,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues),
            )
        }
    }
}

@Composable
private fun AccountsTopBar(
    isTransfersMenu: Boolean,
    onChangeMenu: (isTransfersMenu: Boolean) -> Unit,
    onClickCreateAccount: () -> Unit,
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(MultiThrifterColors.Primary)
                .defaultMinSize(minHeight = 56.dp),
        ) {
            Text(
                text = stringResource(id = if (isTransfersMenu) R.string.transfers else R.string.accounts),
                color = Color.White,
                style = MaterialTheme.typography.h2,
                modifier = Modifier.align(Alignment.Center),
            )
            if (!isTransfersMenu) {
                IconButton(
                    onClick = onClickCreateAccount,
                    modifier = Modifier.align(Alignment.CenterEnd),
                ) {
                    Icon(
                        painter = painterResource(id = com.multithrifter.ui.R.drawable.ic_add),
                        contentDescription = null,
                        tint = Color.White,
                        modifier = Modifier.size(24.dp),
                    )
                }
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
                .height(56.dp),
        ) {
            IconButton(
                onClick = { onChangeMenu(false) },
                modifier = Modifier.weight(1f),
            ) {
                Text(
                    text = stringResource(id = R.string.accounts),
                    color = if (isTransfersMenu) MultiThrifterColors.middleGray else MultiThrifterColors.Primary,
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.body1,
                )
            }
            Box(
                modifier = Modifier
                    .width(1.dp)
                    .background(MultiThrifterColors.background)
                    .height(56.dp),
            )
            IconButton(
                onClick = { onChangeMenu(true) },
                modifier = Modifier.weight(1f),
            ) {
                Text(
                    text = stringResource(id = R.string.transfers),
                    color = if (!isTransfersMenu) MultiThrifterColors.middleGray else MultiThrifterColors.Primary,
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.body1,
                )
            }
        }
    }
}

@Composable
private fun AccountsMenuContent(
    accounts: List<Account>,
    totals: List<TotalEntity>,
    totalsByCurrency: List<TotalEntity>,
    onClickAccount: (Account) -> Unit,
    modifier: Modifier = Modifier,
) {
    LazyColumn(
        horizontalAlignment = Alignment.End,
        modifier = modifier,
    ) {
        itemsIndexed(accounts) { index, account ->
            AccountItem(
                account = account,
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { onClickAccount(account) }
                    .conditional(index % 2 != 0) {
                        background(MultiThrifterColors.secondary)
                    },
            )
        }
        item {
            Text(
                text = stringResource(id = R.string.total),
                color = MultiThrifterColors.Primary,
                textDecoration = TextDecoration.Underline,
                style = MaterialTheme.typography.body1,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(top = 8.dp)
                    .padding(horizontal = 16.dp, vertical = 4.dp),
            )
        }
        items(totals) { total ->
            TotalItem(
                total = total,
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 4.dp),
            )
        }
        item {
            Text(
                text = stringResource(id = R.string.total_amount),
                color = MultiThrifterColors.Primary,
                textDecoration = TextDecoration.Underline,
                style = MaterialTheme.typography.body1,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(top = 8.dp)
                    .padding(horizontal = 16.dp, vertical = 4.dp),
            )
        }
        items(totalsByCurrency) { total ->
            TotalItem(
                total = total,
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 4.dp),
            )
        }
        item {
            Spacer(modifier = Modifier.height(140.dp))
        }
    }
}

@Composable
private fun AccountItem(
    account: Account,
    modifier: Modifier = Modifier,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier.padding(16.dp),
    ) {
        Text(
            text = account.name,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            style = MaterialTheme.typography.body1,
        )
        Text(
            text = "${"%.2f".format(account.balance)} ${account.currency.symbol}",
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            style = MaterialTheme.typography.body1,
        )
    }
}

@Composable
private fun TotalItem(
    total: TotalEntity,
    modifier: Modifier = Modifier,
) {
    Text(
        text = "${"%.2f".format(total.amount)} ${total.currency.symbol}",
        maxLines = 1,
        overflow = TextOverflow.Ellipsis,
        style = MaterialTheme.typography.body1,
        modifier = modifier,
    )
}

@Preview(showBackground = true)
@Composable
private fun AccountsScreenPreview() {
    val currency = Currency("RUB", "russian ruble", "ruble", "₽")
    val account = Account("account", 1000f, currency)
    val total = TotalEntity(2000f, currency)
    MultiThrifterTheme {
        AccountsScreen(
            state = AccountsState(
                isLoading = false,
                accounts = listOf(account, account),
                totals = listOf(total, total),
                totalsByCurrency = listOf(total, total),
            ),
            onClickCreateAccount = {},
            onClickAccount = {},
        )
    }
}