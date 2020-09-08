package com.masondoom.rpntool.core.utils

object ErrorMessageUtil {
    fun buildOperatorErrorMessage(name: String, position: Int, message: String): String {
        return buildErrorMessage("Operator", name, position, message)
    }

    fun buildErrorMessage(type: String, name: String, position: Int, message: String): String {
        return "$type $name (position: $position): $message"
    }
}