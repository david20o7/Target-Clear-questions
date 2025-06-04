# Extending Mathematical Range with Parentheses

This question extends the mathematical range of the Skeleton Program by introducing parentheses.
Add functionality to the game to allow users to input infix notation using brackets in their expressions to control the order of operations.
You can assume that the user will enter a valid number of brackets in their expression.

## What you need to do

### Task 16.1

- Create a new method `convertToRPNWithBrackets` to replace the `convertToRPN` method. Use a shunting algorithm to correctly interpret the precedence of an expression which includes brackets. Update the application to replace wherever the `convertToRPN` method is called.
- Modify the `checkValidOperator` and `check|fUserInputValid` methods to update the Regular Expressions to match with a suitable pattern to allow brackets in an infix expression.

### Task 16.2

Test that the changes you have made work:

- Run the Skeleton Program.
- Enter y to start a training game.
- Enter the expression: (8+2) \*2+3
- Show the program displaying an updated targets list with 23 correctly removed:
  ```
  | | | 1 19|140|82|121|34|45|68|75|34| |119|43||
  |119|119|119||
  ```

## Evidence that you need to provide:

- Your PROGRAM SOURCE CODE showing the new `convertToRPNWithBrackets` method and any additional methods required to operate. [9 marks]
- Your PROGRAM SOURCE CODE showing the amended `checkValidOperator` and `check|fUserInputValid` methods. [2 marks]
- SCREEN CAPTURE(S) showing the required tests. [1 mark]
