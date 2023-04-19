package com.multithrifter.editaccount.presentation.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.LocalContentAlpha
import androidx.compose.material.LocalContentColor
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.multithrifter.core.domain.entity.Currency
import com.multithrifter.editaccount.R
import com.multithrifter.editaccount.presentation.viewmodel.EditAccountContract.AccountState
import com.multithrifter.editaccount.presentation.viewmodel.EditAccountContract.AccountEvent
import com.multithrifter.editaccount.presentation.viewmodel.EditAccountContract.AccountEvent.BalanceChanged
import com.multithrifter.editaccount.presentation.viewmodel.EditAccountContract.AccountEvent.CancelClicked
import com.multithrifter.editaccount.presentation.viewmodel.EditAccountContract.AccountEvent.CurrencyClicked
import com.multithrifter.editaccount.presentation.viewmodel.EditAccountContract.AccountEvent.DeleteClicked
import com.multithrifter.editaccount.presentation.viewmodel.EditAccountContract.AccountEvent.NameChanged
import com.multithrifter.editaccount.presentation.viewmodel.EditAccountContract.AccountEvent.SaveClicked
import com.multithrifter.editaccount.presentation.viewmodel.EditAccountContract.AccountEvent.ValidationNotificationShown
import com.multithrifter.ui.MultiThrifterColors
import com.multithrifter.ui.MultiThrifterTheme
import com.multithrifter.ui.R as UiR
import kotlinx.coroutines.delay

private const val MESSAGE_SHOW_TIME = 5000

@Composable
internal fun EditAccountScreen(
    state: AccountState,
    onEvent: (AccountEvent) -> Unit,
) {
    Box {
        Scaffold(
            topBar = {
                TopBar { onEvent(CancelClicked) }
            },
            modifier = Modifier.fillMaxSize(),
        ) { paddingValues ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues),
            ) {
                Column(modifier = Modifier.fillMaxWidth()) {
                    TextField(
                        value = state.name,
                        onValueChange = { onEvent(NameChanged(it)) },
                        textStyle = MaterialTheme.typography.body2,
                        label = {
                            Text(
                                text = stringResource(id = R.string.edit_account_name),
                                style = MaterialTheme.typography.body2,
                            )
                        },
                        singleLine = true,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp, vertical = 8.dp),
                    )
                    TextField(
                        value = state.balance,
                        onValueChange = { onEvent(BalanceChanged(it)) },
                        textStyle = MaterialTheme.typography.body2,
                        label = {
                            Text(
                                text = stringResource(id = R.string.edit_account_balance),
                                style = MaterialTheme.typography.body2,
                            )
                        },
                        singleLine = true,
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp, vertical = 8.dp),
                    )
                    SelectCurrencyItem(
                        selectedCurrency = state.selectedCurrency,
                        onClick = { onEvent(CurrencyClicked(state.selectedCurrency)) },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp, vertical = 8.dp),
                    )
                }
                Column(modifier = Modifier.align(Alignment.BottomCenter)) {
                    Button(
                        onClick = { onEvent(SaveClicked) },
                        shape = RoundedCornerShape(8.dp),
                        modifier = Modifier
                            .padding(16.dp)
                            .fillMaxWidth(),
                    ) {
                        Text(
                            text = stringResource(id = R.string.edit_account_save),
                            style = MaterialTheme.typography.body1,
                            textAlign = TextAlign.Center,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(8.dp),
                        )
                    }
                    Button(
                        onClick = { onEvent(DeleteClicked) },
                        shape = RoundedCornerShape(8.dp),
                        elevation = ButtonDefaults.elevation(
                            defaultElevation = 0.dp,
                            pressedElevation = 0.dp,
                        ),
                        colors = ButtonDefaults.outlinedButtonColors(),
                        modifier = Modifier
                            .padding(horizontal = 16.dp)
                            .padding(bottom = 16.dp)
                            .fillMaxWidth(),
                    ) {
                        Text(
                            text = stringResource(id = R.string.edit_account_delete),
                            style = MaterialTheme.typography.body1,
                            textAlign = TextAlign.Center,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(8.dp),
                        )
                    }
                }
            }
        }
        
        Notification(
            text = stringResource(id = R.string.edit_account_message),
            visible = state.showValidationNotification,
            onFinish = { onEvent(ValidationNotificationShown) },
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
        )
    }
}

@Composable
private fun TopBar(
    onClickCancel: () -> Unit,
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(MultiThrifterColors.Primary)
            .defaultMinSize(minHeight = 56.dp)
            .padding(horizontal = 16.dp),
    ) {
        Text(
            text = stringResource(id = R.string.edit_account),
            color = Color.White,
            style = MaterialTheme.typography.h2,
            modifier = Modifier.align(Alignment.Center),
        )
        IconButton(
            onClick = onClickCancel,
            modifier = Modifier.align(Alignment.CenterStart),
        ) {
            Icon(
                painter = painterResource(id = com.multithrifter.ui.R.drawable.ic_back),
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier.size(24.dp),
            )
        }
    }
}

@Composable
private fun SelectCurrencyItem(
    selectedCurrency: Currency,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    TextField(
        value = selectedCurrency.name,
        onValueChange = {},
        readOnly = true,
        textStyle = MaterialTheme.typography.body2,
        label = {
            Text(
                text = stringResource(id = R.string.edit_account_currency),
                style = MaterialTheme.typography.body2,
            )
        },
        trailingIcon = {
            Icon(
                painter = painterResource(id = UiR.drawable.ic_chevron),
                contentDescription = null,
            )
        },
        colors = TextFieldDefaults.textFieldColors(
            disabledTextColor = LocalContentColor.current.copy(LocalContentAlpha.current),
        ),
        enabled = false,
        modifier = modifier.clickable(
            onClick = onClick,
            role = Role.Button,
        ),
    )
}

@Composable
private fun Notification(
    text: String,
    visible: Boolean,
    onFinish: () -> Unit,
    modifier: Modifier = Modifier,
) {
    var notificationVisible by remember { mutableStateOf(visible) }

    LaunchedEffect(visible) {
        if (visible) {
            notificationVisible = true
        }
    }

    LaunchedEffect(notificationVisible) {
        delay(MESSAGE_SHOW_TIME.toLong())
        notificationVisible = false
        onFinish()
    }

    AnimatedVisibility(
        visible = notificationVisible,
        enter = slideInVertically(
            animationSpec = tween(easing = LinearEasing),
            initialOffsetY = { -it },
        ),
        exit = slideOutVertically(
            animationSpec = tween(easing = LinearEasing),
            targetOffsetY = { -it },
        ),
    ) {
        Box(
            modifier = modifier
                .defaultMinSize(minHeight = 24.dp)
                .background(
                    color = MultiThrifterColors.backgroundError,
                    shape = RoundedCornerShape(16.dp),
                )
        ) {
            Text(
                text = text,
                color = Color.White,
                style = MaterialTheme.typography.body2,
                modifier = Modifier
                    .align(Alignment.Center)
                    .padding(16.dp),
            )
        }
    }
}

@Preview
@Composable
private fun EditAccountScreenPreview() {
    MultiThrifterTheme {
        EditAccountScreen(
            state = AccountState(),
            onEvent = {},
        )
    }
}