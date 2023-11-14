package com.umut.poele.ui.shoplist

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.umut.poele.R
import com.umut.poele.data.RecipeDataSource
import com.umut.poele.data.SupplyDataSource
import com.umut.poele.databinding.FragmentShopListBinding
import com.umut.poele.ui.base.BaseFragment

class ShopListFragment : BaseFragment<FragmentShopListBinding, ShopListViewModel>(R.layout.fragment_shop_list) {

    override val vm: ShopListViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            viewModel = vm
            adapterRecipe = ShopListRecipeAdapter(RecipeDataSource().loadRecipe())
            adapterSupply = ShopListSupplyAdapter(SupplyDataSource().loadSupply())
            imageTrash.setOnClickListener {
                MaterialAlertDialogBuilder(requireContext()).setTitle(R.string.shoplist_dialog_title)
                    .setMessage(R.string.shoplist_dialog_message)
                    .setNegativeButton(R.string.shoplist_dialog_negative_button) { dialog, _ ->
                        dialog.dismiss()
                    }.setPositiveButton(R.string.shoplist_dialog_positive_button) { dialog, _ ->
                        dialog.cancel()
                    }.show()
            }
        }
    }
}
