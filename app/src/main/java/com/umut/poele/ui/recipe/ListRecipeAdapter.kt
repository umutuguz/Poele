package com.umut.poele.ui.recipe

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.umut.poele.data.source.local.entity.RecipeEntity
import com.umut.poele.databinding.ListRecipeBinding

class ListRecipeAdapter(private val onRecipeClicked: (RecipeEntity) -> Unit) : ListAdapter<RecipeEntity, ListRecipeAdapter.RecipeViewHolder>(DiffCallback) {

    class RecipeViewHolder(private var binding: ListRecipeBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(recipe: RecipeEntity) {
            binding.recipe = recipe
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        return RecipeViewHolder(ListRecipeBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        val current = getItem(position)
        holder.itemView.setOnClickListener {
            onRecipeClicked(current)
        }
        holder.bind(current)
    }

    companion object {

        private val DiffCallback = object : DiffUtil.ItemCallback<RecipeEntity>() {
            override fun areItemsTheSame(oldItem: RecipeEntity, newItem: RecipeEntity): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: RecipeEntity, newItem: RecipeEntity): Boolean {
                return oldItem.id == newItem.id
            }
        }
    }
}
