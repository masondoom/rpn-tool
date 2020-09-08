package com.masondoom.rpntool.core.calculator

import com.masondoom.rpntool.core.model.operators.Operator
import com.masondoom.rpntool.core.model.MutableStack
import com.masondoom.rpntool.core.model.State
import com.masondoom.rpntool.core.model.InputItem
import com.masondoom.rpntool.core.model.Number

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