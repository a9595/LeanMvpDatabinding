/*
 * Copyright © 2017 inFullMobile. All rights reserved.
 */

package com.infullmobile.neuca.domain.usecases

import com.tieorange.leanmvpdatabinding.domain.usecases.UseCaseSchedule
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers

/**
 * Created by jacek on 27/01/17.
 */
class UiThreadSchedule : UseCaseSchedule {
    override fun getScheduler(): Scheduler = AndroidSchedulers.mainThread()
}