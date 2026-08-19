package com.starttohkar.rpn;

import java.util.Stack;

/**
 * This class provides an example of how to evaluate expressions using
 * Reverse Polish Notation (RPN).
 *
 * Algorithm:
 * 1. Initialize an empty stack.
 * 2. Iterate through each token in the input expression:
 *    a. If the token is a number, push it onto the stack.
 *    b. If the token is an operator, pop the required number of operands from the stack, perform the operation, and push the result back onto the stack.
 * 3. After processing all tokens, the result will be the only value left in the stack.
 *
 *  time complexity is O(n) where n is the number of tokens in the input expression.
 *  space complexity is O(n) for the stack used to store operands.
 *
 *  explain the time and space complexity in detail:
 *  Time Complexity:
 *  The algorithm processes each token in the input expression exactly once. For each token, we perform a constant-time operation (either pushing onto the stack or popping from the stack and performing an arithmetic operation). Therefore, the overall time complexity is O(n), where n is the number of tokens in the input expression.
 *  Space Complexity:
 *  The space complexity is O(n) for the stack used to store operands. In the worst case, all tokens could be numbers, and we would need to store all of them on the stack.
 */
public class ReversePolishNotationExample {

    public int evalRPN(String[] tokens) {
        int returnedValue = 0;
        String operators = "+-*/";
        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {
            if (!operators.contains(token)) {
                stack.push(Integer.parseInt(token));
            } else {
                int b = stack.pop();
                int a = stack.pop();
                switch (token) {
                    case "+" -> returnedValue = a + b;
                    case "-" -> returnedValue = a - b;
                    case "*" -> returnedValue = a * b;
                    case "/" -> returnedValue = a / b;
                }
                stack.push(returnedValue);
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        ReversePolishNotationExample rpn = new ReversePolishNotationExample();
        String[] tokens = {"2", "1", "+", "3", "*"};
        int result = rpn.evalRPN(tokens);
        System.out.println("Result: " + result); // Output: Result: 9

        //one more complex example
        String[] tokens2 = {"4", "13", "5", "/", "+"};
        int result2 = rpn.evalRPN(tokens2);
        System.out.println("Result: " + result2); // Output: Result: 6

    }
}
