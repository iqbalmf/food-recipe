package net.iqbalfauzan.food.repository

import io.reactivex.Single
import net.iqbalfauzan.food.model.FoodCategoryModel

/**
 * Created by Iqbalmf on 2019-08-08
 */
interface FoodRecipeRepository {
    fun foodCategory(): Single<FoodCategoryModel>
}