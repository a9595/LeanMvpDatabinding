/*
 * Copyright © 2016 inFullMobile. All rights reserved.
 */

package com.tieorange.leanmvpdatabinding.domain.usecases;

import io.reactivex.Scheduler;

public interface UseCaseSchedule {
    Scheduler getScheduler();
}
