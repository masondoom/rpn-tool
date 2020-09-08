package core.model.operators

import core.model.State
import core.model.Number

class Add(override val position: Int) : MathOperator() {
    override val name = "+"
    override fun process(newState: State) {
        val first = extractNumber(newState)
        val second = extractNumber(newState)
        newState.stack.push(Number(first.value.add(second.value)))
    }
}