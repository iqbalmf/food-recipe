package net.iqbalfauzan.foodrecipe.home

import android.app.Activity
import net.iqbalfauzan.foodrecipe.about.AboutActivityWireframe
import net.iqbalfauzan.uikit.extension.start

/**
 * Created by Iqbalmf on 2019-07-02
 */
class HomeActivityWireframe {
    companion object {
        fun startHomeActivity(source: Activity) {
            source.start(HomeActivity::class.java)
        }
    }
    fun openAboutActivity(source: Activity){
        AboutActivityWireframe.startAboutActivity(source)
    }
}