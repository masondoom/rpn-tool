package core.model.operators

import core.model.State
import core.model.InputItem
import core.model.MutableStack

interface Operator : InputItem {
    fun operate(currentState: State, history: MutableStack<State>): State
    val name: String
    val position: Int
}