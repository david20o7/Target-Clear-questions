# convertToRPN

**Return Type:** String List

This method converts the infix expression entered by the user into postfix notation using a version of the shunting yard algorithm.

## Initialization

The method initializes the following local variables:

- `position` set to 0 (as an intWrapper static object) - used to identify indices in the userinput
- `precedence` as a HashMap of type \<string, int\> - stores mathematical operators with associated values where multiplication and division have higher values than addition and subtraction, implementing BIDMAS (though it doesn't handle brackets or indices)
- `operand` as an integer - gets the first number in the infix notation using the getNumberFromUserInput method
- `userinputinRPN` as a list of strings - immediately populated with the operand variable casted as a string
- `operators` as a list of strings - populated with the first operator in the userinput expression

## Algorithm

The method then enters a condition-controlled loop which:

1. Updates `operand` using the getNumberFromUserInput method to get the next number
2. Appends the updated operand to the `userinputinRPN` list as a string

The method then handles operators:

- If the `position` variable is less than the length of the userinput string:

  - Extracts the operator prior using `position - 1` and stores it in `currentOperator`
  - Tests this against other values in the `operators` list by popping values from the back
  - Uses the `precedence` HashMap to compare operator precedence
  - If a value in the `operators` list has higher or equal precedence than `currentOperator`, it's added to `userinputinRPN` and removed from `operators`
  - Adds `currentOperator` to the `operators` list, ensuring multiplication and division are processed before addition and subtraction

- If `position` equals or exceeds the userinput length:
  - All operands and operators have been extracted
  - The method iterates through the remaining `operators`, popping values from the back and adding them to `userinputinRPN`

The method finally returns the completed `userinputinRPN` list.
