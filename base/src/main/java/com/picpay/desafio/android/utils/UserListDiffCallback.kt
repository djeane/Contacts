package com.picpay.desafio.android.utils

import androidx.recyclerview.widget.DiffUtil
import com.picpay.desafio.android.features.contacts.api.response.UserListResponse

class UserListDiffCallback(
    private val oldList: List<UserListResponse>,
    private val newList: List<UserListResponse>
) : DiffUtil.Callback() {

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].username == newList[newItemPosition].username
    }

    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return true
    }
}