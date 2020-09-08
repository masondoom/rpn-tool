package com.masondoom.rpntool.core.calculator

import com.masondoom.rpntool.core.model.InputItem
import com.masondoom.rpntool.core.model.Number
import com.masondoom.rpntool.core.model.operators.Add
import com.masondoom.rpntool.core.model.operators.Clear
import com.masondoom.rpntool.core.model.operators.Divide
import com.masondoom.rpntool.core.model.operators.Minus
import com.masondoom.rpntool.core.model.operators.Multiply
import com.masondoom.rpntool.core.model.operators.Sqrt
import com.masondoom.rpntool.core.model.operators.Undo
import com.masondoom.rpntool.core.utils.ErrorMessageUtil
import java.lang.IllegalArgumentException

object InputItemFactory {
    fun create(input: String, position: Int): InputItem {
        return when (input) {
            "+" -> Add(position)
            "-" -> Minus(position)
            "*" -> Multiply(position)
            "/" -> Divide(position)
            "undo" -> Undo(position)
            "clear" -> Clear(position)
            "sqrt" -> Sqrt(position)
            else -> try {
                Number.createNumber(input)
            } catch (ex: NumberFormatException) {
                throw IllegalArgumentException(ErrorMessageUtil.buildErrorMessage(
                    "Input", "read", position, "Invalid input=$input"
                ))
            }
        }
    }
}