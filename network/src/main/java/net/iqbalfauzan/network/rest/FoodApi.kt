package net.iqbalfauzan.network.rest

import io.reactivex.Single
import net.iqbalfauzan.data.entity.FoodCategoryEntity
import retrofit2.http.GET
import retrofit2.http.Url

/**
 * Created by Iqbalmf on 2019-07-21
 */
interface FoodApi{
    @GET
    fun getCategories(@Url  url:String) : Single<FoodCategoryEntity>
}