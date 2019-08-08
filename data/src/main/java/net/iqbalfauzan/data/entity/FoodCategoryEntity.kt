package net.iqbalfauzan.data.entity

import com.google.gson.annotations.SerializedName
import net.iqbalfauzan.food.model.FoodCategoryModel

/**
 * Created by Iqbalmf on 2019-08-08
 */
data class FoodCategoryEntity(@SerializedName("categories") var categories: List<CategoryEntity>? = null){
    fun create(): FoodCategoryModel {
        return FoodCategoryModel(
            foodCategories = categories?.map { it.create() } ?: listOf()
        )
    }
}