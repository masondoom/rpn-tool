import commendLine.CommandLineHandler
import core.calculator.Calculator
import core.utils.InputParser

fun main() {
    val calculator = Calculator()
    val inputParser = InputParser()
    CommandLineHandler(calculator, inputParser).start()
}