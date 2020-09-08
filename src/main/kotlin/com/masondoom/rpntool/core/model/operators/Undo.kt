package com.masondoom.rpntool.core.model.operators

import com.masondoom.rpntool.core.model.State
import com.masondoom.rpntool.core.model.MutableStack
import com.masondoom.rpntool.core.utils.ErrorMessageUtil
import java.lang.IllegalStateException

class Undo(override val position: Int) : Operator {
    override val name = "undo"

    override fun operate(currentState: State, history: MutableStack<State>): State {
        if (history.isEmpty()) {
            throw IllegalStateException(ErrorMessageUtil.buildOperatorErrorMessage(
                name, position, "No previous operation found"
            ))
        }
        return history.pop()
    }
}