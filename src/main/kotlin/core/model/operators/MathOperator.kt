package core.model.operators

import core.model.State
import core.model.MutableStack
import core.model.Number
import core.utils.ErrorMessageUtil
import java.lang.IllegalStateException

abstract class MathOperator : Operator {
    protected abstract fun process(newState: State)

    override fun operate(currentState: State, history: MutableStack<State>): State {
        val newState = currentState.toCalculatorState()
        process(newState)
        history.push(currentState)
        return newState
    }

    protected fun extractNumber(newState: State): Number {
        if (!newState.stack.isEmpty() && newState.stack.peek() is Number) {
            return newState.stack.pop() as Number
        } else {
            throw IllegalStateException(ErrorMessageUtil.buildOperatorErrorMessage(
                name, position, "Insufficient parameters"
            ))
        }
    }
}