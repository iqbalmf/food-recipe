package net.iqbalfauzan.data

import io.reactivex.Single
import net.iqbalfauzan.data.source.FoodCategoryDataSource
import net.iqbalfauzan.food.model.FoodCategoryModel
import net.iqbalfauzan.food.repository.FoodRecipeRepository
import javax.inject.Inject

/**
 * Created by Iqbalmf on 2019-08-08
 */
class FoodCategoryRepositorySource
@Inject constructor(private val factory: FoodCategoryDataSource.Factory) : FoodRecipeRepository {
    override fun foodCategory(): Single<FoodCategoryModel> {
        return factory.network().foodCategory()
    }
}