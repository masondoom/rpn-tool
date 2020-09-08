package com.masondoom.rpntool.core.model

import io.kotlintest.matchers.types.shouldNotBeSameInstanceAs
import io.kotlintest.shouldBe
import org.junit.Test

class MutableStackTest {
    @Test
    fun `MutableStack can be created by empty constructor`() {
        val mutableStack = MutableStack<String>()
        mutableStack.toString() shouldBe "stack: "
    }

    @Test
    fun `MutableStack can be created by mutable list`() {
        val mutableStack = MutableStack(mutableListOf("a", "b", "c"))
        mutableStack.toString() shouldBe "stack: a b c"
    }

    @Test
    fun `push adds item into the stack`() {
        val mutableStack = MutableStack(mutableListOf("a", "b", "c"))
        mutableStack.push("d")
        mutableStack.toString() shouldBe "stack: a b c d"
    }

    @Test
    fun `peek returns top item of the stack without changing it`() {
        val mutableStack = MutableStack(mutableListOf("a", "b", "c"))
        mutableStack.peek() shouldBe "c"
        mutableStack.toString() shouldBe "stack: a b c"
    }

    @Test
    fun `pop returns top item of the stack and remove it from the stack`() {
        val mutableStack = MutableStack(mutableListOf("a", "b", "c"))
        mutableStack.pop() shouldBe "c"
        mutableStack.toString() shouldBe "stack: a b"
    }

    @Test
    fun `size returns size of items`() {
        val mutableStack = MutableStack(mutableListOf("a", "b", "c"))
        mutableStack.size() shouldBe 3
    }

    @Test
    fun `isEmpty returns true if empty`() {
        val mutableStack = MutableStack(mutableListOf<String>())
        mutableStack.isEmpty() shouldBe true
    }

    @Test
    fun `isEmpty returns false if not empty`() {
        val mutableStack = MutableStack(mutableListOf("a", "b", "c"))
        mutableStack.isEmpty() shouldBe false
    }

    @Test
    fun `clear removes all items in the stack`() {
        val mutableStack = MutableStack(mutableListOf("a", "b", "c"))
        mutableStack.clear()
        mutableStack.toString() shouldBe "stack: "
    }

    @Test
    fun `toMutableStack create a new MutableStack`() {
        val curStack = MutableStack(mutableListOf("a", "b", "c"))
        val newStack = curStack.toMutableStack()
        newStack shouldNotBeSameInstanceAs curStack
        newStack shouldBe curStack

        newStack.clear()
        curStack.toString() shouldBe "stack: a b c"
    }
}