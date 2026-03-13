package com.example.rpncalculator;

import org.apache.commons.lang3.StringUtils;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class Calculator {

    Stack<Integer> calculatorStack = new Stack<>();

    Map<String, Integer> map = Map.of(
            "+", 2,
            "-", 2,
            "*", 3,
            "/", 3
    );

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

        Queue<String> queue = new LinkedList<>();
        Stack<String> operatorStack = new Stack<>();

        for (String s : inputSplit) {
            if (StringUtils.isNumeric(s)) {
                queue.add(s);
            } else {

                if (operatorStack.isEmpty()) {operatorStack.push(s); continue;}
                else if ( map.get(s) <= map.get(operatorStack.peek())){
                    queue.add(operatorStack.pop());
                }
                operatorStack.push(s);
            }
        }

        return calculate(recombine(queue, operatorStack));
    }

    private String recombine( Queue<String> queue, Stack<String> operatorStack){

        StringBuilder postfix = new StringBuilder(String.valueOf(queue.poll()));

        for (String i : queue) { postfix.append(" ").append(i);}
        while (!operatorStack.isEmpty()) { postfix.append(" ").append(operatorStack.pop());}

        return postfix.toString();
    }

}

