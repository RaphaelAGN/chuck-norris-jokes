package com.RaphaelAGN.chucknorrisapp.models

import com.google.gson.annotations.SerializedName

//Model with api response keys
data class JokeModel(

    @SerializedName("icon_url")
    var iconUrl : String,

    @SerializedName("id")
    var id : String,

    @SerializedName("url")
    var url : String,

    @SerializedName("value")
    var value : String
)