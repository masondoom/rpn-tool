package core.model

import core.utils.Constants.DEFAULT_MATH_CONTEXT
import core.utils.Constants.DEFAULT_SCALE
import core.utils.Constants.NUMBER_OF_DECIMAL_TO_DISPLAY
import java.math.BigDecimal

data class Number(val value: BigDecimal) : InputItem {
    override fun toString(): String {
        return value
            .setScale(NUMBER_OF_DECIMAL_TO_DISPLAY, BigDecimal.ROUND_HALF_UP)
            .stripTrailingZeros()
            .toPlainString()
    }

    companion object {
        fun createNumber(input: String): Number {
            return Number(
                BigDecimal(input, DEFAULT_MATH_CONTEXT)
                    .setScale(DEFAULT_SCALE, BigDecimal.ROUND_HALF_UP)
            )
        }
    }
}