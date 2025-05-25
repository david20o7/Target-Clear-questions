# Task 6

**Marks: 4**

This question extends the Skeleton Program by allowing the user to move the targets list back to the right, but at a cost to their score.

New functionality should be introduced which offers the user the opportunity to move the targets back to the right instead of entering an expression. If they select this option, the targets list should be moved along to the right by one index and the score should be reduced by 2. The list should maintain its standard length.

The start of the list should be repopulated with -1.

## What you need to do

### Task 6.1

Modify the `playGame` method to give the user the option to enter an expression or enter "MOVE" to move the targets list.
Create a new method called `moveTargetsBack` which operates as described.

### Task 6.2

Test that the changes you have made work:

- Run the Skeleton Program.
- Enter y to start a training game.
- Enter the expression: `512/8+2+2`
- Enter the expression: `8+3-2`
- When prompted to enter another expression, select to move the targets list to the right.
- Show the program displaying the targets list with the order:
  ```
  | 1 1 1 1231 11401821121134145| 175134|23|119|43|23|119|1191
  ```

## Evidence that you need to provide:

- Your PROGRAM SOURCE CODE showing the new method `moveTargetsBack` and the amended `playGame` method. [3 marks]
- SCREEN CAPTURE(S) showing the required tests. [1 mark]
