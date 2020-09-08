package com.masondoom.rpntool.core.model

import io.kotlintest.matchers.types.shouldNotBeSameInstanceAs
import io.kotlintest.shouldBe
import org.junit.Test

class StateTest {

    @Test
    fun `toCalculatorState creates a new State`() {
        val curState = State(MutableStack<InputItem>())
        val newState = curState.toCalculatorState()
        newState shouldNotBeSameInstanceAs curState
        newState.stack shouldNotBeSameInstanceAs curState.stack
    }

    @Test
    fun `toString delegates to stack`() {
        val state = State(MutableStack<InputItem>())
        state.toString() shouldBe state.stack.toString()
    }
}