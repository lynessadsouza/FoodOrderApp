package com.example.foodorderapp.Model

import com.google.gson.annotations.SerializedName
import java.io.Serializable
/*

data class UserModel(
    var email :String ?= "",
    var name :String ?= "",
    var photo :String ?= "",
    var pin :Int? = 0,
    var type :String?= ""
): Serializable{}
*/


open class UserModel(
    @SerializedName("email")
    var email: String? = "",
    @SerializedName("name")
    var name: String? = "",
    @SerializedName("photo")
    var photo: String? = "",
    @SerializedName("pin")
    var pin: Int? = 0,
    @SerializedName("type")
    var type: String? = ""

) {

    data class UserModel(
        @SerializedName("email")
        var email: String? = "",
        @SerializedName("name")
        var name: String? = "",
        @SerializedName("photo")
        var photo: Int? = 0,
        @SerializedName("pin")
        var pin: Int? = 0,
        @SerializedName("type")
        var type: String? = ""
    ) {}


}