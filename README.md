### Task 3

Marks: 2
The application currently uses list data structures but includes some functionality which would be better suited to stack or queue data structures.
The update Targets method uses iteration on a list to interact with the list as if it were a queue. Because the iteration is upperbound by the value of the maxNumbersOfTargets variable, it will always iterate the same number of times. The method therefore has a time complexity of O(1). The code, however, could be simplified to just interact with the start and end of the queue rather than iterating through it. This would make the functionality cleaner.
What you need to do

### Task 3.1

Modify the `updateTargets` method to simplify how the list is interacted just using start and end indices rather than iterating through it. Ensure that the functionality of the method does not change.

### Task 3.2

Test that the changes you have made work:

• Run the Skeleton Program.
• Enter y to start a training game.
• Enter the expression: 8+3-2
• Show the program displaying the updated targets list with the targets moved one index to the left and 119 added to the end of the list.
Evidence that you need to provide:
• Your PROGRAM SOURCE CODE showing the refactoring of the updateTargets method.
• SCREEN CAPTURE(S) showing the required tests.
[1 mark]
[1 mark]
