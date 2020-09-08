package com.masondoom.rpntool.core.model.operators

import com.masondoom.rpntool.core.model.State
import com.masondoom.rpntool.core.model.Number
import com.masondoom.rpntool.core.utils.ErrorMessageUtil
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