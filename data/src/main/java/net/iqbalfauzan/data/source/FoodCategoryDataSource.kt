package net.iqbalfauzan.data.source

import dagger.Lazy
import io.reactivex.Single
import net.iqbalfauzan.data.repository.FoodService
import net.iqbalfauzan.food.model.FoodCategoryModel
import net.iqbalfauzan.food.repository.FoodRecipeRepository
import javax.inject.Inject

/**
 * Created by Iqbalmf on 2019-08-08
 */
interface FoodCategoryDataSource : FoodRecipeRepository {
    class Factory
    @Inject constructor(private val network: Lazy<Network>) {
        fun network(): Network = network.get()
    }

    class Network
    @Inject constructor(private val service: FoodService) : FoodCategoryDataSource {
        override fun foodCategory(): Single<FoodCategoryModel> {
            return service.getFoodCategories()
                .map {
                    it.create()
                }
        }


    }


}