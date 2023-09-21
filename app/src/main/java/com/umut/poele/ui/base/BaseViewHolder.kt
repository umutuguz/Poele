package com.umut.poele.ui.base

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

class BaseViewHolder<Binding : ViewDataBinding>(val binder: Binding) :
    RecyclerView.ViewHolder
        (binder.root)
