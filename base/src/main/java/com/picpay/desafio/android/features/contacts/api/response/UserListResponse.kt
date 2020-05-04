package com.picpay.desafio.android.features.contacts.api.response

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Entity(tableName = "users")
@Parcelize
data class UserListResponse(
    @SerializedName("img") val img: String,
    @SerializedName("name") val name: String,
    @SerializedName("id") @PrimaryKey(autoGenerate = false) val id: Int,
    @SerializedName("username") val username: String
) : Parcelable