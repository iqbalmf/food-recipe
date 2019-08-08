package net.iqbalfauzan.foodrecipe.about

import androidx.lifecycle.ViewModelProviders
import dagger.Module
import dagger.Provides

/**
 * Created by Iqbalmf on 2019-07-02
 */
@Module
class AboutActivityModule {
    @Provides
    fun providesViewModel(activity: AboutActivity, factory: AboutActivityViewModel.Factory): AboutActivityViewModelType {
        return ViewModelProviders.of(activity, factory).get(AboutActivityViewModel::class.java)
    }

    @Provides
    fun providesWireframe(): AboutActivityWireframe = AboutActivityWireframe()
}