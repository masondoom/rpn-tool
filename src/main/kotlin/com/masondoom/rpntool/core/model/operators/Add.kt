package com.masondoom.rpntool.core.model.operators

import com.masondoom.rpntool.core.model.State
import com.masondoom.rpntool.core.model.Number

class Add(override val position: Int) : MathOperator() {
    override val name = "+"
    override fun process(newState: State) {
        val first = extractNumber(newState)
        val second = extractNumber(newState)
        newState.stack.push(Number(first.value.add(second.value)))
    }
}