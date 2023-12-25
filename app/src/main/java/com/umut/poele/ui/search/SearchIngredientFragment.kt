package com.umut.poele.ui.search

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.umut.poele.R
import com.umut.poele.domain.model.SupplyDataSource
import com.umut.poele.databinding.FragmentSearchIngredientBinding
import com.umut.poele.ui.base.BaseFragment

class SearchIngredientFragment : BaseFragment<FragmentSearchIngredientBinding, SearchViewModel>(R.layout.fragment_search_ingredient) {

    override val vm: SearchViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            adapter = SearchIngredientAdapter(SupplyDataSource().loadSupply(), vm)
        }
    }
}
