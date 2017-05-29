/*
 * Copyright © 2016 inFullMobile. All rights reserved.
 */

package com.tieorange.leanmvpdatabinding.presentation.common.adapters

import android.support.annotation.LayoutRes
import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.infullmobile.neuca.presentation.common.BaseViewHolder


abstract class BaseAdapter<HolderType : BaseViewHolder<ItemType>, ItemType : Any>()
    : RecyclerView.Adapter<HolderType>() {

    var items: MutableList<ItemType> = mutableListOf()
    private var onItemSelectedListener: ((listItem: ItemType) -> Unit)? = null

    open val isEmpty: Boolean
        get() = !isNotEmpty

    open val isNotEmpty: Boolean
        get() = itemCount > 0

    val lastItemPosition: Int
        get() = items.lastIndex

    abstract fun createHolder(view: View, viewType: Int): HolderType

    @LayoutRes abstract fun layoutId(viewType: Int): Int

    open fun setOnItemSelectedListener(onItemSelectedListener: ((listItem: ItemType) -> Unit)?) {
        this.onItemSelectedListener = onItemSelectedListener
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HolderType {
        return createHolder(LayoutInflater.from(parent.context).inflate(layoutId(viewType), parent, false), viewType)
    }

    override fun onBindViewHolder(holder: HolderType, position: Int) {
        holder.displayItem(items[position])
        holder.onItemSelectedListener = onItemSelectedListener
    }

    open fun setData(data: List<ItemType>) {
        setDataSilently(data)
        notifyDataSetChanged()
    }

    internal fun setDataSilently(data: List<ItemType>) {
        items.clear()
        items.addAll(data)
    }

    open fun clearData() {
        items.clear()
        notifyDataSetChanged()
    }
}

private fun <HolderType : BaseViewHolder<ItemType>, ItemType : Any> BaseAdapter<HolderType, ItemType>.swapExtension(
        actors: List<ItemType>) {
    val diffCallback = ActorDiffCallback(this.items, actors)
    val diffResult = DiffUtil.calculateDiff(diffCallback)

    this.items.clear()
    diffResult.dispatchUpdatesTo(this)
}

class ActorDiffCallback<ItemType>(items: MutableList<ItemType>, actors: List<ItemType>) : DiffUtil.Callback() {
    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getOldListSize(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getNewListSize(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
