# Task 8

**Marks: 8**

This question extends the Skeleton Program by introducing a challenge mode into the program awarding the player a bonus score if they use all the numbers available to them and deducting points if they don't.

Introduce a "Challenge Mode" to the application. There should be a 25% chance of the "Challenge Mode" being triggered each turn. When triggered, the user should be told that they need to use all five numbers from the numbersAllowed list in that turn. The user should be told that doing so will gain them a bonus of 10 points and that if they do not, they will be deducted 5 points. If an expression identifies multiple targets the user should only be awarded or deducted points once.

## What you need to do

### Task 8.1

Modify the playGame method to tell the user that the "Challenge Mode" has been activated. There should be a 25% chance of this happening each turn.

Modify the check|fUserInputEvaluation|sA Target in Challenge Mode so that if a target is correctly identified and the user has used all the numbers in the numbersAllowed list, the user is awarded an additional 10 points. If a target is identified but the user has not used all the numbers in the numbersAllowed list, the user score should be reduced by 5 points.

### Task 8.2

Test that the changes you have made work:

- Run the Skeleton Program.
- Press enter to start a training game.
- Enter expressions until the "Challenge Mode" is activated.
- Show the program telling the user that "Challenge Mode" has been activated.
- Enter an expression which uses all five numbers in the numbersAllowed list

Show the program displaying the score increasing by 10 points on top of the normal score awarded for
the targets) identified.

## Evidence that you need to provide:

- Your PROGRAM SOURCE CODE showing the amended play Game method. [3 marks]
- Your PROGRAM SOURCE CODE showing the amended check|fUserInputEvaluation|sA Target method. [4 marks]
- SCREEN CAPTURE(S) showing the required tests. [1 mark]|
