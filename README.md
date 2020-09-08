# rpn-tool
Command-line based Reverse Polish Notation tool.

* supports Math operator (+, -, *, /, sqrt)
* supports undo and clear operator

Configuration of precision and scale can be found [here](https://github.com/masondoom/rpn-tool/blob/master/src/main/kotlin/com/masondoom/rpntool/core/utils/Constants.kt)

## Usage
run start.sh

Note: kotlin cli tool is required.
```
./start.sh
```





# Future improvements
## Enhanced functionalities
* More match operators can be easily added by extending MathOperator class
* Other Operators can be easily added by extending Operator interface

## Online & UI
* To support Online mode, Calculator#State and Calculator#history can be serialized and stored in session and deserialized from session to keep track of a user's session of calculator
* Customize the color of each number in the stack depending on its position:
  * For position of number in the stack, we could add logic in state#toString
  * For position of number in input string, we could move the Operator#position to InputItem interface to keep track of that and customize during toString function
  