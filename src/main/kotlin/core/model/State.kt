package core.model

data class State(val stack: MutableStack<InputItem>) {

    fun toCalculatorState(): State {
        return State(stack.toMutableStack())
    }

    override fun toString(): String {
        return stack.toString()
    }
}