package com.multithrifter.app

import androidx.compose.ui.test.assertCountEquals
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onAllNodesWithTag
import androidx.compose.ui.test.onChildAt
import androidx.compose.ui.test.onChildren
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import androidx.compose.ui.test.performTextReplacement
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.multithrifter.core.domain.entity.Currency
import com.multithrifter.main.presentation.MainActivity
import org.junit.Rule
import org.junit.Test
import com.multithrifter.main.R

class UserFlowTest {

    @get:Rule
    val activity = ActivityScenarioRule(MainActivity::class.java)

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun createAccountTest() {
        val currenciesCount = 4
        val newAccountBalance = "1500"

        Espresso.onView(ViewMatchers.withId(R.id.menu_account))
            .perform(ViewActions.click())

        composeTestRule.waitForIdle()

        val accountsCount = composeTestRule.onAllNodesWithTag("account_item", true)
            .fetchSemanticsNodes()
            .size

        composeTestRule.onNodeWithTag("add_account_icon", true)
            .performClick()

        composeTestRule.onNodeWithTag("create_account_name_field", true)
            .assertTextEquals("")
            .performTextInput("test account name")

        composeTestRule.waitForIdle()

        composeTestRule.onNodeWithTag("create_account_balance_field", true)
            .assertTextEquals("0")
            .performTextReplacement(newAccountBalance)

        val accountCurrency = composeTestRule.onNodeWithTag("create_account_currency_field", true)

        accountCurrency.assertTextEquals(Currency.default().name)
            .performClick()

        val currencies = composeTestRule.onNodeWithTag("currencies_list", true)

        currencies.onChildren()
            .assertCountEquals(currenciesCount)

        val currencyNode = currencies.onChildAt(currenciesCount - 1)
        val currencyTextConfigValue = currencyNode.fetchSemanticsNode().children[0].config
            .find { it.key.name == "Text" }

        val currencyText = (currencyTextConfigValue?.value as? List<*>)
            ?.firstOrNull()
            ?.toString() ?: ""

        currencyNode.performClick()

        accountCurrency.assertTextEquals(currencyText)

        composeTestRule.onNodeWithTag("create_account_save", true)
            .performClick()

        composeTestRule.onAllNodesWithTag("account_item", true)
            .assertCountEquals(accountsCount + 1)
    }
}