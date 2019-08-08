package net.iqbalfauzan.data.di

import dagger.Module
import dagger.Provides
import net.iqbalfauzan.data.FoodCategoryRepositorySource
import net.iqbalfauzan.data.source.FoodCategoryDataSource
import net.iqbalfauzan.food.repository.FoodRecipeRepository
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Iqbalmf on 2019-08-08
 */
@Module
class DataModule {
    @Provides
    @Singleton
    fun provideFoodCategoryRepository(foodCategoryRepositorySource: FoodCategoryRepositorySource):
            FoodRecipeRepository = foodCategoryRepositorySource


}