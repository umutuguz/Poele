package com.umut.poele.ui.base

import android.annotation.SuppressLint
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter

//abstract class BaseListAdapter<B: ViewDataBinding, T: Any>(var list: List<T>, @LayoutRes val layoutId: Int
//): ListAdapter<T,BaseViewHolder<B>>(BaseItemCallback<T>()) {
//
//    abstract fun bind(binding: B, item: T)
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<B> {
//        return BaseViewHolder()
//    }
//
//    override fun onBindViewHolder(holder: BaseViewHolder<B>, position: Int) {
//
//    }
//    //    companion object {
////
////        private val DiffCallback = object : DiffUtil.ItemCallback<Any>() {
////            override fun areItemsTheSame(oldItem: Any, newItem: Any): Boolean {
////                return oldItem == newItem
////            }
////
////            override fun areContentsTheSame(oldItem: Any, newItem: Any): Boolean {
////                return oldItem == newItem
////            }
////
////        }
////    }
//
//}
//
//class BaseItemCallback<T : Any> : DiffUtil.ItemCallback<T>() {
//    override fun areItemsTheSame(oldItem: T, newItem: T) = oldItem.toString() == newItem.toString()
//
//    override fun areContentsTheSame(oldItem: T, newItem: T) = oldItem == newItem
//}
