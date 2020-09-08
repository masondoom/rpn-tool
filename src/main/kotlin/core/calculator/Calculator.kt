package core.calculator

import core.model.operators.Operator
import core.model.MutableStack
import core.model.State
import core.model.InputItem
import core.model.Number

/**
 * Calculator that tracks the current state and can process the incoming requests
 *
 * Note: This is not thread-safe
 */
class Calculator(
    private var currentState: State = State(MutableStack()),
    private val history: MutableStack<State> = MutableStack()
) {
    fun calculate(input: String, pos: Int): String {
        process(InputItemFactory.create(input, pos))
        return currentState.toString()
    }

    private fun process(input: InputItem) {
        when (input) {
            is Number -> {
                val newState = currentState.toCalculatorState()
                newState.stack.push(input)
                history.push(currentState)
                currentState = newState
            }
            is Operator -> {
                currentState = input.operate(currentState, history)
            }
        }
    }
}