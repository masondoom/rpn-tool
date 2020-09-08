package core.model.operators

import core.model.MutableStack
import core.model.Number
import core.model.State
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