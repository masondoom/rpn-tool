package com.masondoom.rpntool.core.utils

import java.math.MathContext
import java.math.RoundingMode

object Constants {
    const val NUMBER_OF_DECIMAL_TO_DISPLAY = 10
    const val DEFAULT_SCALE = 17
    const val DEFAULT_PRECISION = 50
    val DEFAULT_MATH_CONTEXT = MathContext(DEFAULT_PRECISION, RoundingMode.HALF_UP)
}