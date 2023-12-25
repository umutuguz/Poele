package com.umut.poele.ui.profile

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.umut.poele.R
import com.umut.poele.domain.model.RecipeDataSource
import com.umut.poele.databinding.FragmentFavoriteBinding
import com.umut.poele.ui.base.BaseFragment

class FavoriteFragment : BaseFragment<FragmentFavoriteBinding, FavoriteViewModel>(R.layout.fragment_favorite) {

    override val vm: FavoriteViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            adapter = FavoriteListAdapter(RecipeDataSource().loadRecipe(), vm)
        }
    }
}
