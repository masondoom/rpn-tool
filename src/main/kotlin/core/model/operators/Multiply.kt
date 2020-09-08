package core.model.operators

import core.model.State
import core.model.Number

class Multiply(override val position: Int) : MathOperator() {
    override val name = "*"

    override fun process(newState: State) {
        val first = extractNumber(newState)
        val second = extractNumber(newState)
        newState.stack.push(Number(second.value.times(first.value)))
    }
}