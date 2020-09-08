package com.masondoom.rpntool.core.model.operators

import com.masondoom.rpntool.core.model.InputItem
import com.masondoom.rpntool.core.model.MutableStack
import com.masondoom.rpntool.core.model.Number
import com.masondoom.rpntool.core.model.State
import io.kotlintest.shouldBe
import io.kotlintest.shouldThrow
import org.junit.Test
import java.lang.IllegalStateException
import java.math.BigDecimal

class SqrtTest {
    @Test
    fun `sqrt process with valid state should update history and return new state`() {
        val state = State(MutableStack(mutableListOf(
            Number(BigDecimal.valueOf(1.1)),
            Number(BigDecimal.valueOf(2.2))
        )))
        val history = MutableStack<State>()

        val newState = Sqrt(3).operate(state, history)

        newState.toString() shouldBe "stack: 1.1 1.4832396974"
        history.size() shouldBe 1
        history.peek().toString() shouldBe "stack: 1.1 2.2"
    }

    @Test
    fun `sqrt process with invalid state should throw error`() {
        val state = State(MutableStack(mutableListOf<InputItem>()))
        val history = MutableStack<State>()

        val exception = shouldThrow<IllegalStateException> {
            Sqrt(1).operate(state, history)
        }
        exception.message shouldBe "Operator sqrt (position: 1): Insufficient parameters"
    }

    @Test
    fun `sqrt process with state when first item is zero should throw error`() {
        val state = State(MutableStack(mutableListOf(
            Number(BigDecimal.valueOf(-1.1))
        )))
        val history = MutableStack<State>()

        val exception = shouldThrow<IllegalStateException> {
            Sqrt(1).operate(state, history)
        }
        exception.message shouldBe "Operator sqrt (position: 1): Illegal sqrt(x) for x < 0: x = -1.1"
        state.toString() shouldBe "stack: -1.1"
    }
}