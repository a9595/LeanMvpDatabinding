/*
 * Copyright © 2017 inFullMobile. All rights reserved.
 */

package com.infullmobile.neuca.domain.usecases

import io.reactivex.subjects.PublishSubject

/**
 * Created by jacek on 10/02/17.
 */
abstract class PublishSubjectUseCase<Type : Any> {

    abstract fun doWork(): PublishSubject<Type>
}