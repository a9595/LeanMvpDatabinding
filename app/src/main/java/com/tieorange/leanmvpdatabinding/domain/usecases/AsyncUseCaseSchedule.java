package com.tieorange.leanmvpdatabinding.domain.usecases;

import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;

public class AsyncUseCaseSchedule implements UseCaseSchedule {
    @Override
    public Scheduler getScheduler() {
        return Schedulers.io();
    }
}
