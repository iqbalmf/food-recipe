package net.iqbalfauzan.network.rest

import io.reactivex.Single
import net.iqbalfauzan.data.entity.FoodCategoryEntity
import net.iqbalfauzan.data.repository.FoodService
import retrofit2.Retrofit

/**
 * Created by Iqbalmf on 2019-07-21
 */

class FoodServiceImpl(private val retrofit: Retrofit) : FoodService{
    private val foodService by lazy { retrofit.create(FoodApi::class.java) }

    override fun getFoodCategories(): Single<FoodCategoryEntity> {
        return foodService.getCategories(
            url = "categories.php"
        )
    }
}