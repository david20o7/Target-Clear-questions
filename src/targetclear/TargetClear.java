// Skeleton Program code for the AQA A Level Paper 1 Summer 2025 examination
// this code should be used in conjunction with the Preliminary Material
// written by the AQA Programmer Team
// developed in the IntelliJ IDEA Community Edition programming environment

package targetclear;

import java.util.Scanner;
import java.util.Random;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;

public class TargetClear {
    static Scanner scanner = new Scanner(System.in);
    static Random rGen = new Random();

    static class IntWrapper {
        public int value;

        IntWrapper(int initialValue) {
            value = initialValue;
        }
    }

    public static void main(String[] args) {
        List<Integer> numbersAllowed = new ArrayList<Integer>();
        List<Integer> targets;

        int maxNumberOfTargets = 20;
        int maxTarget;
        int maxNumber;
        boolean trainingGame;
        System.out.print("Enter y to play the training game, anything else to play a random game: ");
        String choice = scanner.nextLine().toLowerCase();
        System.out.println();
        if (choice.equals("y")) {
            maxNumber = 1000;
            maxTarget = 1000;
            trainingGame = true;
            targets = new ArrayList<Integer>(
                    Arrays.asList(-1, -1, -1, -1, -1, 23, 9, 140, 82, 121, 34, 45, 68, 75, 34, 23, 119, 43, 23, 119));
        } else {
            maxNumber = 10;
            maxTarget = 50;
            trainingGame = false;
            targets = createTargets(maxNumberOfTargets, maxTarget);
        }
        numbersAllowed = fillNumbers(numbersAllowed, trainingGame, maxNumber);
        playGame(targets, numbersAllowed, trainingGame, maxTarget, maxNumber);
        scanner.nextLine();
    }

    static void playGame(List<Integer> targets, List<Integer> numbersAllowed, boolean trainingGame, int maxTarget,
            int maxNumber) {
        IntWrapper score = new IntWrapper(0);
        boolean gameOver = false;
        while (!gameOver) {
            displayState(targets, numbersAllowed, score.value);
            System.out.print("Enter an expression: ");
            String userInput = scanner.nextLine();
            System.out.println();
            if (checkIfUserInputValid(userInput)) {
                List<String> userInputInRPN = convertToRPN(userInput);
                if (checkNumbersUsedAreAllInNumbersAllowed(numbersAllowed, userInputInRPN, maxNumber)) {
                    if (checkIfUserInputEvaluationIsATarget(targets, userInputInRPN, score)) {
                        removeNumbersUsed(userInput, maxNumber, numbersAllowed);
                        numbersAllowed = fillNumbers(numbersAllowed, trainingGame, maxNumber);
                    }
                }
            }
            score.value -= 1;
            if (targets.get(0) != -1) {
                gameOver = true;
            } else {
                updateTargets(targets, trainingGame, maxTarget);
            }
        }
        System.out.println("Game over!");
        displayScore(score.value);

    }

    static boolean checkIfUserInputEvaluationIsATarget(List<Integer> targets, List<String> userInputInRPN,
            IntWrapper score) {
        int userInputEvaluation = evaluateRPN(userInputInRPN);
        boolean userInputEvaluationIsATarget = false;
        int counter = 0;
        if (userInputEvaluation != -1) {
            for (int count = 0; count < targets.size(); count++) {
                if (targets.get(count) == userInputEvaluation) {
                    counter += 1;
                    System.out.println("your expression evalutaed to: " + userInputEvaluation);
                    score.value = score.value + 2;
                    targets.set(count, -1);
                    userInputEvaluationIsATarget = true;
                }

            }
            System.out.println("Your expression has appeared " + counter + " times in the list");
        }
        return userInputEvaluationIsATarget;
    }

    static void removeNumbersUsed(String userInput, int maxNumber, List<Integer> numbersAllowed) {
        List<String> userInputInRPN = convertToRPN(userInput);
        for (String item : userInputInRPN) {
            if (checkValidNumber(item, maxNumber)) {
                if (numbersAllowed.contains(Integer.parseInt(item))) {
                    numbersAllowed.remove(numbersAllowed.indexOf(Integer.parseInt(item)));
                }
            }
        }
    }

    static void updateTargets(List<Integer> targets, boolean trainingGame, int maxTarget) {
        for (int count = 0; count <= targets.size() - 2; count++) {
            targets.set(count, targets.get(count + 1));
        }
        targets.remove(targets.size() - 1);
        if (trainingGame) {
            targets.add(targets.get(targets.size() - 1));
        } else {
            targets.add(getTarget(maxTarget));
        }
    }

    static boolean checkNumbersUsedAreAllInNumbersAllowed(List<Integer> numbersAllowed, List<String> userInputInRPN,
            int maxNumber) {
        List<Integer> temp = new ArrayList<Integer>();
        for (int item : numbersAllowed) {
            temp.add(item);
        }
        for (String item : userInputInRPN) {
            if (checkValidNumber(item, maxNumber)) {
                if (temp.contains(Integer.parseInt(item))) {
                    temp.remove(temp.indexOf(Integer.parseInt((item))));
                } else {
                    return false;
                }
            }
        }
        if (temp.size() != 0) {
            System.out.println("You still haven't used: " + temp);
        }
        return true;
    }

    static boolean checkValidNumber(String item, int maxNumber) {
        if (item.matches("^[0-9]+$")) {
            int itemAsInteger = Integer.parseInt(item);
            if (itemAsInteger > 0 && itemAsInteger <= maxNumber) {
                return true;
            }
        }
        return false;
    }

    static void displayState(List<Integer> targets, List<Integer> numbersAllowed, int score) {
        displayTargets(targets);
        displayNumbersAllowed(numbersAllowed);
        displayScore(score);
    }

    static void displayScore(int score) {
        System.out.println("Current score: " + score);
        System.out.println();
        System.out.println();
    }

    static void displayNumbersAllowed(List<Integer> numbersAllowed) {
        System.out.print("Numbers available: ");
        for (int n : numbersAllowed) {
            System.out.print(n + "  ");
        }
        System.out.println();
        System.out.println();
    }

    static void displayTargets(List<Integer> targets) {
        System.out.print("|");
        for (int t : targets) {
            if (t == -1) {
                System.out.print(" ");
            } else {
                System.out.print(t);
            }
            System.out.print("|");
        }
        System.out.println();
        System.out.println();
    }

    static List<String> convertToRPN(String userInput) {
        IntWrapper position = new IntWrapper(0);
        Map<String, Integer> precedence = new HashMap<String, Integer>();
        precedence.put("+", 2);
        precedence.put("-", 2);
        precedence.put("*", 4);
        precedence.put("/", 4);
        List<String> operators = new ArrayList<String>();
        int operand = getNumberFromUserInput(userInput, position);
        List<String> userInputInRPN = new ArrayList<String>();
        userInputInRPN.add(Integer.toString(operand));
        operators.add(userInput.substring(position.value - 1, position.value));
        while (position.value < userInput.length()) {
            operand = getNumberFromUserInput(userInput, position);
            userInputInRPN.add(Integer.toString(operand));
            if (position.value < userInput.length()) {
                String currentOperator = userInput.substring(position.value - 1, position.value);
                while (operators.size() > 0
                        && precedence.get(operators.get(operators.size() - 1)) > precedence.get(currentOperator)) {
                    userInputInRPN.add(operators.get(operators.size() - 1));
                    operators.remove(operators.size() - 1);
                }
                if (operators.size() > 0
                        && precedence.get(operators.get(operators.size() - 1)) == precedence.get(currentOperator)) {
                    userInputInRPN.add(operators.get(operators.size() - 1));
                    operators.remove(operators.size() - 1);
                }
                operators.add(currentOperator);
            } else {
                while (operators.size() > 0) {
                    userInputInRPN.add(operators.get(operators.size() - 1));
                    operators.remove(operators.size() - 1);
                }
            }
        }
        return userInputInRPN;
    }

    static int evaluateRPN(List<String> userInputInRPN) {
        List<String> s = new ArrayList<String>();
        while (userInputInRPN.size() > 0) {
            while (!"+-*/".contains(userInputInRPN.get(0))) {
                s.add(userInputInRPN.get(0));
                userInputInRPN.remove(0);
            }
            double num2 = Double.parseDouble(s.get(s.size() - 1));
            s.remove(s.size() - 1);
            double num1 = Double.parseDouble(s.get(s.size() - 1));
            s.remove(s.size() - 1);
            double result = 0.0;
            switch (userInputInRPN.get(0)) {
                case "+":
                    result = num1 + num2;
                    break;
                case "-":
                    result = num1 - num2;
                    break;
                case "*":
                    result = num1 * num2;
                    break;
                case "/":
                    result = num1 / num2;
                    break;
            }
            userInputInRPN.remove(0);
            s.add(Double.toString(result));
        }
        if (Double.parseDouble(s.get(0)) - Math.floor(Double.parseDouble(s.get(0))) == 0) {
            return (int) Math.floor(Double.parseDouble(s.get(0)));
        } else {
            return -1;
        }
    }

    static int getNumberFromUserInput(String userInput, IntWrapper position) {
        String number = "";
        boolean moreDigits = true;
        while (moreDigits) {
            if (userInput.substring(position.value, position.value + 1).matches("[0-9]")) {
                number += userInput.substring(position.value, position.value + 1);
            } else {
                moreDigits = false;
            }
            position.value = position.value + 1;
            if (position.value == userInput.length()) {
                moreDigits = false;
            }
        }
        if (number.isEmpty()) {
            return -1;
        } else {
            return Integer.parseInt(number);
        }
    }

    static boolean checkIfUserInputValid(String userInput) {
        return userInput.matches("^([0-9]+[\\+\\-\\*\\/])+[0-9]+$");
    }

    static int getTarget(int maxTarget) {
        return rGen.nextInt(maxTarget) + 1;
    }

    static int getNumber(int maxNumber) {
        return rGen.nextInt(maxNumber) + 1;
    }

    static List<Integer> createTargets(int sizeOfTargets, int maxTarget) {
        List<Integer> targets = new ArrayList<Integer>();
        for (int count = 1; count <= 5; count++) {
            targets.add(-1);
        }
        for (int count = 1; count <= sizeOfTargets - 5; count++) {
            targets.add(getTarget(maxTarget));
        }
        return targets;
    }

    static List<Integer> fillNumbers(List<Integer> numbersAllowed, boolean trainingGame, int maxNumber) {
        if (trainingGame) {
            return new ArrayList<Integer>(Arrays.asList(2, 3, 2, 8, 512));
        } else {
            while (numbersAllowed.size() < 5) {
                numbersAllowed.add(getNumber(maxNumber));
            }
            return numbersAllowed;
        }
    }
}