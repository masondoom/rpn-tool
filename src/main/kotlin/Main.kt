package com.masondoom.rpntool

import com.masondoom.rpntool.commendLine.CommandLineHandler
import com.masondoom.rpntool.core.calculator.Calculator
import com.masondoom.rpntool.core.utils.InputParser

fun main() {
    val calculator = Calculator()
    val inputParser = InputParser()
    CommandLineHandler(calculator, inputParser).start()
}