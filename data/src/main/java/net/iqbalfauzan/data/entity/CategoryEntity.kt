package net.iqbalfauzan.data.entity

import com.google.gson.annotations.SerializedName
import net.iqbalfauzan.food.model.CategoryModel

/**
 * Created by Iqbalmf on 2019-08-08
 */
data class CategoryEntity(
    @SerializedName("idCategory") val idCategory: String? = null,
    @SerializedName("strCategory") val category: String? = null,
    @SerializedName("strCategoryThumb") val imageCategory: String? = null,
    @SerializedName("strCategoryDescription") val descCategory: String? = null){

    fun create(): CategoryModel {
        return CategoryModel(
            idCategory = idCategory.orEmpty(),
            category = category.orEmpty(),
            imageCategory = imageCategory.orEmpty(),
            descCategory = descCategory.orEmpty()
        )
    }
}