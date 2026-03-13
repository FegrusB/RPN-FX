package com.example.rpncalculator;

import java.util.Stack;

public class Calculator {

    Stack<Integer> calculatorStack = new Stack<>();


    public Integer calculate(String input) {

        String[] inputSplit = input.split(" ");

        for (String s : inputSplit) {
            switch (s) {
                case "+" -> calculatorStack.push(calculatorStack.pop() + calculatorStack.pop());
                case "-" -> calculatorStack.push( calculatorStack.pop() - calculatorStack.pop());
                case "*" -> calculatorStack.push(calculatorStack.pop() * calculatorStack.pop());
                case "/" -> calculatorStack.push(calculatorStack.pop() / calculatorStack.pop());
                default -> calculatorStack.push(Integer.parseInt(s));
            }
        }

        return calculatorStack.pop();

    }




}
