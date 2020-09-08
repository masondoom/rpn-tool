package core.model

import io.kotlintest.shouldBe
import io.kotlintest.shouldNotBe
import org.junit.Test

class StateTest {

    @Test
    fun `toCalculatorState creates a new State`() {
        val curState = State(MutableStack<InputItem>())
        val newState = curState.toCalculatorState()
        newState shouldNotBe curState
        newState.stack shouldNotBe curState.stack
    }

    @Test
    fun `toString delegates to stack`() {
        val state = State(MutableStack<InputItem>())
        state.toString() shouldBe state.stack.toString()
    }
}