package com.pizza11x.androidMVVMarchitecture.presentation.ui.base

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.pizza11x.androidMVVMarchitecture.domain.models.IUiModel

abstract class ABaseAdapter<N : IUiModel> :
    RecyclerView.Adapter<ABaseAdapter<N>.ABaseViewHolder>() {

    /* VARIABLES */
    protected open val differList: AsyncListDiffer<N> by lazy {
        AsyncListDiffer(
            this,
            DiffCallBack()
        )
    }

    protected val listItems: List<N> get() = differList.currentList

    /* ADAPTER FUN */
    override fun getItemCount(): Int {
        return listItems.size
    }

    override fun onBindViewHolder(holder: ABaseViewHolder, position: Int) {
        holder.bindItem(listItems[position])

    }

    /* PUBLIC FUN */
    open fun addList(list: List<N>) {
        differList.submitList(list)
    }

    /* PROTECTED FUN */
    protected fun <T : ViewDataBinding> bindLayout(
        inflater: LayoutInflater,
        layout: Int,
        viewGroup: ViewGroup?
    ): T {
        return DataBindingUtil.inflate(inflater, layout, viewGroup, false)
    }

    /* INNER CLASSES */
    abstract inner class ABaseViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        abstract fun bindItem(items: N)
    }

    inner class DiffCallBack : DiffUtil.ItemCallback<N>() {
        override fun areItemsTheSame(oldItem: N, newItem: N): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: N, newItem: N): Boolean {
            return oldItem.areContentsTheSame(newItem)
        }

    }
}