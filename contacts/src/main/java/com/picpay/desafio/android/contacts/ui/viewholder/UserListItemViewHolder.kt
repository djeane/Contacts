package com.picpay.desafio.android.contacts.ui.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.picpay.desafio.android.contacts.R
import com.picpay.desafio.android.features.contacts.api.response.ContactsResponse
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_contacts.view.*

class UserListItemViewHolder(
    itemView: View
) : RecyclerView.ViewHolder(itemView) {

    fun bind(user: ContactsResponse) {
        itemView.name.text = user.name
        itemView.username.text = user.username
        itemView.progressBar.visibility = View.VISIBLE
        Picasso.get()
            .load(user.img)
            .error(R.drawable.ic_round_account_circle)
            .into(itemView.picture, object : Callback {
                override fun onSuccess() {
                    itemView.progressBar.visibility = View.GONE
                }

                override fun onError(e: Exception?) {
                    itemView.progressBar.visibility = View.GONE
                }
            })
    }
}