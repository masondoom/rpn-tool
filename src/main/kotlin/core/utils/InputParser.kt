package core.utils

class InputParser {
    /**
     * parse input string into a pair of input and its position
     */
    fun parse(inputLine: String): List<Pair<String, Int>> {
        val mutableList = mutableListOf<Pair<String, Int>>()
        var position = 1
        val inputStrings = inputLine.split(" ")
        inputStrings.forEach {
            mutableList.add(Pair(it, position))
            position += 1 + it.length
        }
        return mutableList.toList()
    }
}