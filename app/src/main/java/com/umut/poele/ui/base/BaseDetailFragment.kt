package com.umut.poele.ui.base

import androidx.annotation.LayoutRes
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import com.umut.poele.domain.model.RecipeBasic

abstract class BaseDetailFragment
    : Fragment() {
        Lohdas
         abstract fun updateRecipe(updatedRecipe: RecipeBasic)
}
