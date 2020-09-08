package com.masondoom.rpntool.core.model.operators

import com.masondoom.rpntool.core.model.MutableStack
import com.masondoom.rpntool.core.model.Number
import com.masondoom.rpntool.core.model.State
import io.kotlintest.shouldBe
import io.kotlintest.shouldThrow
import org.junit.Test
import java.lang.IllegalStateException
import java.math.BigDecimal

class MinusTest {
    @Test
    fun `minus process with valid state should update history and return new state`() {
        val state = State(MutableStack(mutableListOf(
            Number(BigDecimal.valueOf(1.1)),
            Number(BigDecimal.valueOf(2.2))
        )))
        val history = MutableStack<State>()

        val newState = Minus(3).operate(state, history)

        newState.toString() shouldBe "stack: -1.1"
        history.size() shouldBe 1
        history.peek().toString() shouldBe "stack: 1.1 2.2"
    }

    @Test
    fun `minus process with invalid state should throw error`() {
        val state = State(MutableStack(mutableListOf(
            Number(BigDecimal.valueOf(1.1))
        )))
        val history = MutableStack<State>()

        val exception = shouldThrow<IllegalStateException> {
            Minus(2).operate(state, history)
        }
        exception.message shouldBe "Operator - (position: 2): Insufficient parameters"
    }
}