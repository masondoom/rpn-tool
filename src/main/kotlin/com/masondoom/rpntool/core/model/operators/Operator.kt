package com.masondoom.rpntool.core.model.operators

import com.masondoom.rpntool.core.model.State
import com.masondoom.rpntool.core.model.InputItem
import com.masondoom.rpntool.core.model.MutableStack

interface Operator : InputItem {
    fun operate(currentState: State, history: MutableStack<State>): State
    val name: String
    val position: Int
}