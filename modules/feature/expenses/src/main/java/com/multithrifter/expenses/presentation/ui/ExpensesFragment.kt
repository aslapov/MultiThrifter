package com.multithrifter.expenses.presentation.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.fragment.app.Fragment
import com.multithrifter.core.extensions.composeView

class ExpensesFragment : Fragment() {

    companion object {
        fun newInstance(): ExpensesFragment = ExpensesFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return composeView {
            Box(modifier = Modifier.fillMaxSize()) {
                Text(
                    text = "Expenses will be soon",
                    modifier = Modifier.align(Alignment.Center)
                )
            }
        }
    }
}