package com.tieorange.leanmvpdatabinding.presentation.common.mvpdatabinding

/**
 * Created by andrii.kovalchuk on 27/05/2017.
 */
import android.content.Context
import android.support.v7.app.ActionBar
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import com.infullmobile.android.infullmvp.ContextPresentedView
import com.infullmobile.android.infullmvp.PresentedView

abstract class PresentedActivityView<PresenterType : Any>
    : ContextPresentedView<PresenterType, InFullMvpActivity<*, *, *>>() {

    private var activity: InFullMvpActivity<*, *, *>? = null

    override val context: Context
        get() = activity ?: throw IllegalStateException("This view must be bound to activity") as Throwable

    override val viewFinder: PresentedView<PresenterType, *>.(Int) -> View?
        get() = { activity?.findViewById(it) }

    override fun bindUiElements(boundingView: InFullMvpActivity<*, *, *>, presenter: PresenterType) {
        this.activity = boundingView
        this.boundPresenter = presenter
        onViewsBound()
    }

    open val actionBar: ActionBar?
        get() = activity?.getSupportActionBar()

    open fun setActionBar(toolbar: Toolbar) {
        activity?.setSupportActionBar(toolbar)
    }

    open fun inflateMenu(menu: Menu, menuInflater: MenuInflater) {
        /* NO OP */
    }

    open fun onOptionsItemSelected(item: MenuItem): Boolean {
        return false
    }
}