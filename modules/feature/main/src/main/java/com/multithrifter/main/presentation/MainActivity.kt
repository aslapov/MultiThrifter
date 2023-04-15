package com.multithrifter.main.presentation

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.navigation.NavigationBarView
import com.multithrifter.core.navigation.GlobalNavigator
import com.multithrifter.core.navigation.NavigationHandler
import com.multithrifter.core.navigation.TransitionAnimationSet
import com.multithrifter.main.MainDependencies
import com.multithrifter.main.MainFeature
import com.multithrifter.main.R
import com.multithrifter.main.databinding.ActivityMainBinding
import javax.inject.Inject

class MainActivity : AppCompatActivity(), NavigationHandler {

    @Inject
    lateinit var navigator: GlobalNavigator

    @Inject
    lateinit var dependencies: MainDependencies

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel: MainViewModel by viewModels { viewModelFactory }

    private lateinit var binding: ActivityMainBinding

    private val listener = NavigationBarView.OnItemSelectedListener { menuItem ->
        if (binding.bottomNavigation.selectedItemId == menuItem.itemId) {
            return@OnItemSelectedListener false
        }
        when (menuItem.itemId) {
            R.id.menu_expense -> dependencies.getExpensesActions().showExpensesScreen()
            R.id.menu_income -> dependencies.getIncomesActions().showIncomesScreen()
            R.id.menu_account -> dependencies.getAccountsActions().showAccountsScreen()
        }
        true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        MainFeature.component().inject(this)
        viewModel.updateCurrencyRates()

        navigator.setNavigationHandler(this)

        with(binding.bottomNavigation) {
            selectedItemId = R.id.menu_expense
            dependencies.getExpensesActions().showExpensesScreen()
            setOnItemSelectedListener(listener)
        }
    }

    override fun onBackPressed() {
        onBack()
    }
    override fun onBack() {
        val fm = supportFragmentManager
        if (fm.backStackEntryCount > 0) {
            fm.popBackStack()
        } else {
            onExit()
        }
    }

    override fun onExit() {
        finish()
    }

    /**
     * Открывает новый корневой фрагмент взамен всех других
     */
    override fun newRootFragment(root: Fragment, customAnimations: TransitionAnimationSet?) {
        val fm = supportFragmentManager
        while (fm.backStackEntryCount != 0) {
            fm.popBackStackImmediate()
        }

        openFragment(root, false, customAnimations = customAnimations)
    }

    override fun openFullScreenFragment(
        fragment: Fragment,
        addToBackStack: Boolean,
        customAnimations: TransitionAnimationSet?
    ) {
        binding.bottomNavigation.isVisible = false
        openFragment(fragment, addToBackStack, customAnimations)
    }

    override fun openFragment(
        fragment: Fragment,
        addToBackStack: Boolean,
        customAnimations: TransitionAnimationSet?
    ) {
        val tag = fragment.javaClass.name
        binding.bottomNavigation.isVisible = true

        supportFragmentManager.beginTransaction().apply {
            customAnimations?.let { animations ->
                setCustomAnimations(animations.enter, animations.exit, animations.popEnter, animations.popExit)
            }
            replace(R.id.fragmentContainer, fragment, tag)
            if (addToBackStack) {
                addToBackStack(tag)
            }
        }.commit()
    }
}