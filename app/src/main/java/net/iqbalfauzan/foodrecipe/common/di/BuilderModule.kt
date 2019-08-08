package net.iqbalfauzan.foodrecipe.common.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import net.iqbalfauzan.foodrecipe.about.AboutActivity
import net.iqbalfauzan.foodrecipe.about.AboutActivityModule
import net.iqbalfauzan.foodrecipe.home.HomeActivity
import net.iqbalfauzan.foodrecipe.home.HomeActivityModule

/**
 * Created by Iqbalmf on 2019-07-02
 */
@Module
abstract class BuilderModule {
    @ContributesAndroidInjector(modules = [(HomeActivityModule::class)])
    abstract fun bindHomeActivity(): HomeActivity

    @ContributesAndroidInjector(modules = [(AboutActivityModule::class)])
    abstract fun bindAboutActivity(): AboutActivity
}