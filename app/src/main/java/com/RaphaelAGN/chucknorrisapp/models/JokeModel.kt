package com.RaphaelAGN.chucknorrisapp.models

import com.google.gson.annotations.SerializedName

//Model with api response keys
data class JokeModel(
    @SerializedName("categories")
    var category: ArrayList<String>,

    @SerializedName("created_at")
    var createdAt: String,

    @SerializedName("icon_url")
    var iconUrl : String,

    @SerializedName("id")
    var id : String,

    @SerializedName("updated_at")
    var updatedAt: String,

    @SerializedName("url")
    var url : String,

    @SerializedName("value")
    var value : String
)