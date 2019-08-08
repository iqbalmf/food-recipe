package net.iqbalfauzan.foodrecipe.about

import android.app.Activity
import net.iqbalfauzan.uikit.extension.start

/**
 * Created by Iqbalmf on 2019-07-02
 */
class AboutActivityWireframe {
    companion object {
        fun startAboutActivity(source: Activity) {
            source.start(AboutActivity::class.java)
        }
    }
}