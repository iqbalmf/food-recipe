package net.iqbalfauzan.food.usecase

import io.reactivex.Scheduler
import io.reactivex.Single
import net.iqbalfauzan.food.model.FoodCategoryModel
import net.iqbalfauzan.food.repository.FoodRecipeRepository
import net.iqbalfauzan.kit.base.BaseUsecase
import net.iqbalfauzan.kit.constant.TagInjectConstant
import javax.inject.Inject
import javax.inject.Named

/**
 * Created by Iqbalmf on 2019-08-08
 */
class FoodCategoryUseCase
@Inject constructor(
    val repository: FoodRecipeRepository,
    @Named(TagInjectConstant.SCHEDULER_EXECUTION) threadExecutor: Scheduler,
    @Named(TagInjectConstant.SCHEDULER_POST_EXECUTION) postExecutionThread: Scheduler)
    : BaseUsecase.RxSingle<FoodCategoryModel, Any?>(threadExecutor, postExecutionThread) {
    override fun build(params: Any?): Single<FoodCategoryModel> {
        return repository.foodCategory()
    }
}