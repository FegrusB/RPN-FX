package com.example.rpncalculator;

import org.apache.commons.lang3.StringUtils;

import java.util.LinkedList;
import java.util.Queue;
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

    public Integer calculateShunting(String input) {

        String[] inputSplit = input.split(" ");

        Queue<Integer> queue = new LinkedList<Integer>();
        Stack<String> operatorStack = new Stack<>();

        for (String s : inputSplit) {
            if (StringUtils.isNumeric(s)) {
                queue.add(Integer.parseInt(s));
            } else {
                operatorStack.push(s);
            }
        }

        return calculate(recombine(queue, operatorStack));
    }

    private String recombine( Queue<Integer> queue, Stack<String> operatorStack){

        StringBuilder postfix = new StringBuilder(String.valueOf(queue.poll()));

        for (Integer i : queue) { postfix.append(" ").append(i);}
        for (String s : operatorStack) { postfix.append(" ").append(s);}

        return postfix.toString();
    }

}
