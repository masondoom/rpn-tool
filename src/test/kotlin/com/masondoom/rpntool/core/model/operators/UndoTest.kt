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

class UndoTest {
    @Test
    fun `undo process with valid state should update history and return new state`() {
        val prevState0 = State(MutableStack(mutableListOf<InputItem>()))
        val prevState1 = State(MutableStack(mutableListOf(
            Number(BigDecimal.valueOf(1.1))
        )))
        val curState = State(MutableStack(mutableListOf(
            Number(BigDecimal.valueOf(1.1)),
            Number(BigDecimal.valueOf(2.2))
        )))
        val history = MutableStack<State>()
        history.push(prevState0)
        history.push(prevState1)

        val newState = Undo(3).operate(curState, history)

        newState.toString() shouldBe "stack: 1.1"
        history.size() shouldBe 1
        history.peek().toString() shouldBe "stack: "
    }

    @Test
    fun `undo process with invalid state should throw error`() {
        val state = State(MutableStack(mutableListOf<InputItem>()))
        val history = MutableStack<State>()

        val exception = shouldThrow<IllegalStateException> {
            Undo(1).operate(state, history)
        }
        exception.message shouldBe "Operator undo (position: 1): No previous operation found"
    }
}