package core.model.operators

import core.model.State
import core.model.Number
import core.utils.ErrorMessageUtil
import java.lang.IllegalStateException

class Divide(override val position: Int) : MathOperator() {
    override val name = "/"

    override fun process(newState: State) {
        val first = extractNumber(newState)
        val second = extractNumber(newState)
        try {
            newState.stack.push(Number(second.value.divide(first.value)))
        } catch (ex: ArithmeticException) {
            throw IllegalStateException(ErrorMessageUtil.buildOperatorErrorMessage(
                name, position, ex.message ?: ""
            ))
        }
    }
}