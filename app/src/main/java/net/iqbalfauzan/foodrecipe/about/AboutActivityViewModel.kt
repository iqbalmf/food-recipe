package net.iqbalfauzan.foodrecipe.about

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import net.iqbalfauzan.foodrecipe.common.base.ViewModelType
import java.lang.IllegalArgumentException
import javax.inject.Inject

/**
 * Created by Iqbalmf on 2019-07-02
 */
interface AboutActivityViewModelType : ViewModelType {
    val inputs: Inputs
    val outputs: Outputs

    interface Inputs {}
    interface Outputs {}
}

@Suppress("UNCHECKED_CAST")
class AboutActivityViewModel :
    ViewModel(),
    AboutActivityViewModelType,
    AboutActivityViewModelType.Inputs,
    AboutActivityViewModelType.Outputs {

    override val inputs: AboutActivityViewModelType.Inputs
        get() = this
    override val outputs: AboutActivityViewModelType.Outputs
        get() = this

    class Factory
    @Inject constructor() : ViewModelProvider.Factory{
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(AboutActivityViewModel::class.java)){
                    return AboutActivityViewModel() as T
                }
            throw IllegalArgumentException("Unknown ViewModel Class")
        }
    }
}
