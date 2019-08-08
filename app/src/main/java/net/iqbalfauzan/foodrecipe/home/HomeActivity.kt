package net.iqbalfauzan.foodrecipe.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import net.iqbalfauzan.foodrecipe.R
import net.iqbalfauzan.foodrecipe.common.base.BaseActivity
import javax.inject.Inject

class HomeActivity : BaseActivity<HomeActivityViewModelType>() {
    @Inject
    lateinit var wireframe: HomeActivityWireframe

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
        bindViewEvent()
        bindViewModel()

        viewModel.inputs.onViewLoaded()
    }

    private fun initView() {}
    private fun bindViewEvent() {
        wireframe.openAboutActivity(this@HomeActivity)
    }
    private fun bindViewModel() {}
}
