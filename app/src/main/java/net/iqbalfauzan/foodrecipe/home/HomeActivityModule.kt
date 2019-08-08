package net.iqbalfauzan.foodrecipe.home

import androidx.lifecycle.ViewModelProviders
import dagger.Module
import dagger.Provides

/**
 * Created by Iqbalmf on 2019-07-02
 */
@Module
class HomeActivityModule {
    @Provides
    fun providesViewModel(activity: HomeActivity, factory: HomeActivityViewModel.Factory): HomeActivityViewModelType {
        return ViewModelProviders.of(activity, factory).get(HomeActivityViewModel::class.java)
    }

    @Provides
    fun providesWireframe() : HomeActivityWireframe = HomeActivityWireframe()
}