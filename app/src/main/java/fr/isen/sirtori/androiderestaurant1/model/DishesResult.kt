package fr.isen.sirtori.androiderestaurant1.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class DishesResult (val data: List<Categorymodel>): Serializable

data class Categorymodel(val name_fr: String, val items: List<DishesModel>): Serializable

data class DishesModel(
    val name_fr: String,
    @SerializedName("images") val pictures: List<String>,
    val ingredients: List<Ingredient>,
    val prices: List<Price>
    ): Serializable {
        fun getFirstPicture() = if( pictures[0].isNotEmpty()) pictures[0] else null
        fun getFormattedPrice() = prices[0].price + "€"

    }
data class Ingredient(val name_fr: String): Serializable
data class Price(val price: String): Serializable