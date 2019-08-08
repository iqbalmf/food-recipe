package net.iqbalfauzan.data.repository

import io.reactivex.Single
import net.iqbalfauzan.data.entity.FoodCategoryEntity

/**
 * Created by Iqbalmf on 2019-08-08
 */
interface FoodService {
    fun getFoodCategories(): Single<FoodCategoryEntity>
}