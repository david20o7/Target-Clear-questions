# Task 9

**Marks: 8**

This question extends the Skeleton Program to allow the user to "Freeze" a number in the targets list so that it does not move along to the left when the update Targets method is called at the end of each turn.

Introduce new functionality to allow the user to select a number in the targets list to freeze in place. The user can only have one frozen number at any time and can either freeze or unfreeze the number as part of their turn. A frozen number does not move when the number list is moved one to the left. A frozen number is shown by the symbols < › around it.

## What you need to do

### Task 9.1l

Modify the play Game method to give the user the option to freeze or unfreeze a target in the targets list and allow them to select the position. Display the state of the game again to confirm the update with the frozen number shown.

Modify the update Targets method so that the number identified as frozen does not move when the targets list is updated.

Update the display State method and any subsequently required methods to display the game state as described.

### Task 9.2

Test that the changes you have made work:

- Run the Skeleton Program.
- Enter y to start a training game.
- When prompted, decline the offer to freeze a number on your first turn.
- Enter the expression: `512/8+2+2`
- When prompted to freeze a number, enter position 8 (which should be the target 82).
- Show the program displaying the targets list with the order:
  ```
  | 1 1 1 1231911401<82>1121|34|45| 175|34|23|119|43|23|119|1191
  ```
- Enter the expression: `8+3-2`
- Show the program displaying the targets list with the order:
  ```
  1 1 1 1231 114011211<82>134|45| 175|34|23|119|43|23|119|119|1191
  ```

## Evidence that you need to provide:

- Your PROGRAM SOURCE CODE showing the amended method play Game and the amended update Targets method. [5 marks]
- Your PROGRAM SOURCE CODE showing the amended method display State and any subsequent methods which need updating to operate as described. [1 mark]
- SCREEN CAPTURE(S) showing the required tests. [1 mark]
