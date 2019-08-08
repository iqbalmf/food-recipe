package net.iqbalfauzan.foodrecipe.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import io.reactivex.observers.DisposableSingleObserver
import net.iqbalfauzan.food.model.FoodCategoryModel
import net.iqbalfauzan.food.usecase.FoodCategoryUseCase
import net.iqbalfauzan.foodrecipe.common.base.ViewModelType
import java.lang.IllegalArgumentException
import javax.inject.Inject

/**
 * Created by Iqbalmf on 2019-07-02
 */

interface HomeActivityViewModelType : ViewModelType {
    val inputs: Inputs
    val outputs: Outputs

    interface Inputs {
        fun onViewLoaded()
    }
    interface Outputs {}
}

class HomeActivityViewModel(private val foodCategoryUseCase: FoodCategoryUseCase) :
    ViewModel(),
    HomeActivityViewModelType,
    HomeActivityViewModelType.Outputs,
    HomeActivityViewModelType.Inputs {

    override val inputs: HomeActivityViewModelType.Inputs
        get() = this
    override val outputs: HomeActivityViewModelType.Outputs
        get() = this

    override fun onViewLoaded() {
        prepareFoodCategory()
    }

    private fun prepareFoodCategory(){
        foodCategoryUseCase.execute(FoodCategoryObserver())
    }

    @Suppress("UNCHECKED_CAST")
    class Factory
    @Inject constructor(private val foodCategoryUseCase: FoodCategoryUseCase) : ViewModelProvider.Factory{
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(HomeActivityViewModel::class.java)){
                return HomeActivityViewModel(foodCategoryUseCase) as T
            }
            throw IllegalArgumentException("Unknown ViewModel Class")
        }

    }

    inner class FoodCategoryObserver : DisposableSingleObserver<FoodCategoryModel>(){
        override fun onSuccess(t: FoodCategoryModel) {
            t.toString()
        }

        override fun onError(e: Throwable) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }
    }

}