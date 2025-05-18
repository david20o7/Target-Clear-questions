# Task 1: Adding Quit Functionality (3 Marks)

## Description

This task extends the Skeleton Program to allow the user to end the game at any point rather than wait until they are beaten by the targets. Modify the application to allow the user to enter the word "QUIT" to end the game rather than entering an expression. The program should quit and display the final score.

## Task Requirements

### Task 1.1: Update the Game Logic

- [ ] Update the `playGame` method to allow the user to enter the word "QUIT" instead of an expression
- [ ] Ensure that the code does not decrement the score on that turn when "QUIT" is entered
- [ ] Add logic to test the user input to either play the turn if they enter an expression or quit the game
- [ ] Display the current score when quitting the game

### Task 1.2: Testing Requirements

- [ ] Run the Skeleton Program
- [ ] Enter 'y' to start a training game
- [ ] Enter the expression: `8+3-2`
- [ ] Verify the program correctly identifies the target 9 and awards 1 point
- [ ] When prompted for another expression, enter the word: `QUIT`
- [ ] Confirm the program displays the "Game over!" message and the final score

## Evidence Requirements

- [ ] PROGRAM SOURCE CODE showing the modifications to the `playGame` method (2 marks)
- [ ] SCREEN CAPTURE(S) showing the required tests (1 mark)
