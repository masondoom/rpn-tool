package core.model.operators

import core.model.State
import core.model.MutableStack
import core.utils.ErrorMessageUtil
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