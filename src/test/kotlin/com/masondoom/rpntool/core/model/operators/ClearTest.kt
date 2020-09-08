package com.masondoom.rpntool.core.model.operators

import com.masondoom.rpntool.core.model.MutableStack
import com.masondoom.rpntool.core.model.Number
import com.masondoom.rpntool.core.model.State
import io.kotlintest.shouldBe
import org.junit.Test
import java.math.BigDecimal

class ClearTest {
    @Test
    fun `clear operate clear history and create a new state with empty stack`() {
        val state = State(MutableStack(mutableListOf(
            Number(BigDecimal.valueOf(1.1)),
            Number(BigDecimal.valueOf(2.2))
        )))
        val history = MutableStack<State>()

        val newState = Clear(3).operate(state, history)

        newState.toString() shouldBe "stack: "
        history.size() shouldBe 0
    }
}