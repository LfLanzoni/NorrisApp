package ar.android.lflanzoni.norrisapp.models

import com.google.gson.annotations.SerializedName

data class Jokes(
    @SerializedName("categories")
    var categories: List<Any>,
    @SerializedName("created_at")
    val createdAt: String,
    @SerializedName("icon_url")
    val iconUrl: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("updated_at")
    val updateAt: String,
    @SerializedName("url")
    val url: String,
    @SerializedName("value")
    val value: String
)
