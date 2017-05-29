package com.tieorange.leanmvpdatabinding.presentation.common.mvpdatabinding

/**
 * Created by andrii.kovalchuk on 27/05/2017.
 */
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.infullmobile.android.infullmvp.Presenter

abstract class InFullMvpActivity<
        PresenterType : Presenter<PresentedViewType>,
        out PresentedViewType : PresentedActivityView<PresenterType>,
        BindingType : android.databinding.ViewDataBinding
        > : AppCompatActivity() {

    abstract val presenter: PresenterType
    abstract val presentedView: PresentedViewType

    lateinit var binding: BindingType

    abstract fun injectIntoGraph()

    abstract fun bindingFinished(binding: BindingType)

    override final fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        injectIntoGraph()
        binding = DataBindingUtil.setContentView<BindingType>(this, presentedView.layoutResId)
        bindingFinished(binding)
        presentedView.bindUiElements(this, presenter)
        presenter.bind(intent.extras ?: Bundle(), savedInstanceState ?: Bundle(), intent.data)
    }

    override final fun onDestroy() {
        super.onDestroy()
        presenter.unbind()
    }

    override fun onResume() {
        super.onResume()
        presenter.onResume()
    }

    override fun onPause() {
        super.onPause()
        presenter.onPause()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        presentedView.inflateMenu(menu, menuInflater)
        return true
    }

    final override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return presentedView.onOptionsItemSelected(item) || super.onOptionsItemSelected(item)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        presenter.onActivityResult(requestCode, resultCode, data)
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        presenter.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }

    override fun onBackPressed() {
        if (!presenter.onBackPressed()) {
            super.onBackPressed()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        presenter.saveInstanceState(outState)
        super.onSaveInstanceState(outState)
    }
}
