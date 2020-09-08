package com.masondoom.rpntool.core.model

data class MutableStack<E>(private val elements: MutableList<E>) {
    constructor() : this(mutableListOf())

    fun push(element: E) = elements.add(element)

    fun peek(): E = elements.last()

    fun pop(): E = elements.removeAt(elements.size - 1)

    fun isEmpty() = elements.isEmpty()

    fun size() = elements.size

    fun clear() = elements.clear()

    fun toMutableStack(): MutableStack<E> {
        return MutableStack(elements.toMutableList())
    }

    override fun toString() = "stack: ${elements.joinToString(" ")}"
}