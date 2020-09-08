package commendLine

import core.calculator.Calculator
import core.utils.InputParser
import java.lang.RuntimeException

class CommandLineHandler(
    private val calculator: Calculator,
    private val inputParser: InputParser
) {
    fun start() {
        print("Welcome to RPN tool!\n")
        while (true) {
            readLine()?.let { inputLine ->
                val inputList = inputParser.parse(inputLine)
                var curState = ""

                try {
                    inputList.forEach {
                        curState = calculator.calculate(it.first, it.second)
                    }
                } catch(ex: RuntimeException) {
                    print("${ex.message}\n")
                }
                print("$curState\n")
            }
        }
    }
}