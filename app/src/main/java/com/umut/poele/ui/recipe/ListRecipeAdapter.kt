//package com.umut.poele.ui.recipe
//
//import android.view.ViewGroup
//import androidx.recyclerview.widget.DiffUtil
//import androidx.recyclerview.widget.RecyclerView
//import com.umut.poele.R
//import com.umut.poele.data.source.local.entity.RecipeEntity
//import com.umut.poele.databinding.ListRecipeBinding
//import com.umut.poele.domain.model.RecipeBasic
//import com.umut.poele.ui.base.BaseListAdapter
//import com.umut.poele.ui.base.BaseViewHolder
//
//
//import android.view.LayoutInflater
//
//class ListRecipeAdapter(private var dataset: List<RecipeBasic>) : BaseListAdapter<ListRecipeBinding, ListRecipeAdapter
//    .RecipeViewHolder>
//    (BaseListAdapter.Foo(), R.layout.list_recipe) {
//
//    class RecipeViewHolder(private var binding: ListRecipeBinding) : RecyclerView.ViewHolder(binding.root) {
//
//        fun bind(recipe: RecipeEntity) {
//            binding.recipe = recipe
//        }
//    }
//
//    override fun bind(binding: ListRecipeBinding, item: RecipeViewHolder) {
//
//    }
//
//    override fun onBindViewHolder(holder: BaseViewHolder<ListRecipeBinding>, position: Int) {
//        super.onBindViewHolder(holder, position)
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
//        return RecipeViewHolder(ListRecipeBinding.inflate(LayoutInflater.from(parent.context)))
//    }
//
//
//
//}
