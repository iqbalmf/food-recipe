package net.iqbalfauzan.foodrecipe.about

import android.os.Bundle
import net.iqbalfauzan.foodrecipe.R
import net.iqbalfauzan.foodrecipe.common.base.BaseActivity
import javax.inject.Inject

class AboutActivity : BaseActivity<AboutActivityViewModelType>() {
    @Inject
    lateinit var wireframe: AboutActivityWireframe

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)
        initView()
        bindViewEvent()
        bindViewModel()
    }
    private fun initView(){}
    private fun bindViewEvent(){}
    private fun bindViewModel(){}
}
