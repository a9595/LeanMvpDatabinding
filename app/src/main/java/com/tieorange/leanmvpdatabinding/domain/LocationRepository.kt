/*
 * Copyright © 2016 inFullMobile. All rights reserved.
 */

package com.tieorange.leanmvpdatabinding.domain

import android.location.Location
import io.reactivex.Single

/**
 * Created by jacek on 30/12/16.
 */
interface LocationRepository {
    fun currentLocation(): Single<Location>
    fun canConnectToToServices(): Single<Boolean>
}