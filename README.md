# Task 10

**Marks: 11**

This question extends the Skeleton Program by introducing some object orientation to allow the user to undo previous moves.

Introduce new functionality to allow the user to undo their previous moves. If there are undo moves available, the program should inform the user how many are available and ask them if they would like to undo their last move. If they select this option, the program should undo the last move.

## What you need to do

### Task 10.1

Create a new class called `UndoState` which stores the copies of the `numbersAllowed` list, `targets` list and `score`. Create suitable accessor methods to be able to access these properties.

Modify the `playGame` method to prompt the user appropriately and introduce a suitable data structure to store `UndoState` objects to fulfil the requirements described.

### Task 10.2

Create a new method `addToUndo` which instantiates a copy of the current game state and stores it accordingly to allow undo functionality.

Create a new method `undoLastTurn` which restores the game to the previous game state, ensuring that the `numbersAllowed` list, `targets` list and `score` are all updated.

### Task 10.3

Test that the changes you have made work:

- Run the Skeleton Program.
- Enter `y` to start a training game.
- Enter the expression: `512/8+2+2`
- When prompted, do not undo the last turn.
- Enter the expression: `8+3-2`
- Show the program displaying that two undos are available.
- When prompted, undo the last move.
- Show the program displaying the targets list:
  `| 1 1 1 1231911401821121134145| 175|34|23|119|43|23|119|1191`

## Evidence that you need to provide:

- Your PROGRAM SOURCE CODE showing the new class `UndoState` with a suitable constructor and accessor methods. [4 marks]
- Your PROGRAM SOURCE CODE showing the amended `playGame` method with a suitable prompt as described. [4 marks]
- Your PROGRAM SOURCE CODE showing the new `addToUndo` and `undoLastTurn` methods. [2 marks]
- SCREEN CAPTURE(S) showing the required tests. [1 mark]
