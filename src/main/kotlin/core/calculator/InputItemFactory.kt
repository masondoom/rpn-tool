package core.calculator

import core.model.InputItem
import core.model.Number
import core.model.operators.Add
import core.model.operators.Clear
import core.model.operators.Divide
import core.model.operators.Minus
import core.model.operators.Multiply
import core.model.operators.Sqrt
import core.model.operators.Undo
import core.utils.ErrorMessageUtil
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