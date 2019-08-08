package net.iqbalfauzan.foodrecipe.common.di

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import net.iqbalfauzan.data.di.DataModule
import net.iqbalfauzan.foodrecipe.common.base.BaseApplication
import net.iqbalfauzan.network.di.NetworkModule
import javax.inject.Singleton

/**
 * Created by Iqbalmf on 2019-07-02
 */
@Singleton
@Component(
    modules =
    [(AndroidSupportInjectionModule::class),
        (BuilderModule::class),
        (ApplicationModule::class),
        (NetworkModule::class),
        (DataModule::class)]
)
interface ApplicationComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(app: Application): Builder

        fun build(): ApplicationComponent
    }

    fun inject(app: BaseApplication)
}