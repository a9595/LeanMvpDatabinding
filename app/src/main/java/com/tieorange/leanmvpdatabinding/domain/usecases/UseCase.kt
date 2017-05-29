package com.infullmobile.neuca.domain.usecases

import com.tieorange.leanmvpdatabinding.domain.usecases.UseCaseSchedule
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers

abstract class UseCase<T>(protected val useCaseSchedule: UseCaseSchedule) {

    fun perform(): Single<T> {
        return doWork()
                .subscribeOn(useCaseSchedule.scheduler)
                .observeOn(AndroidSchedulers.mainThread())
    }

    fun performWithoutRedirection(): Single<T> {
        return doWork()
                .subscribeOn(useCaseSchedule.scheduler)
    }

    fun performOnTheSameThread(): Single<T> {
        return doWork()
    }

    protected abstract fun doWork(): Single<T>
}