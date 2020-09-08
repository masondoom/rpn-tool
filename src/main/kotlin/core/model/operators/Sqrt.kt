package core.model.operators

import ch.obermuhlner.math.big.BigDecimalMath
import core.model.State
import core.model.Number
import core.utils.Constants.DEFAULT_MATH_CONTEXT
import core.utils.ErrorMessageUtil
import java.lang.IllegalStateException

class Sqrt(override val position: Int) : MathOperator() {
    override val name = "sqrt"

    override fun process(newState: State) {
        val first = extractNumber(newState)

        try {
            newState.stack.push(Number(BigDecimalMath.sqrt(first.value, DEFAULT_MATH_CONTEXT)))
        } catch (ex: ArithmeticException) {
            throw IllegalStateException(ErrorMessageUtil.buildOperatorErrorMessage(
                name, position, ex.message ?: ""
            ))
        }
    }
}