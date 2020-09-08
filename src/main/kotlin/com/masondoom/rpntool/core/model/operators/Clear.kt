package com.masondoom.rpntool.core.model.operators

import com.masondoom.rpntool.core.model.State
import com.masondoom.rpntool.core.model.MutableStack

class Clear(override val position: Int) : Operator {
    override val name = "clear"

    override fun operate(currentState: State, history: MutableStack<State>): State {
        val newState = State(MutableStack())
        history.clear()
        return newState
    }
}