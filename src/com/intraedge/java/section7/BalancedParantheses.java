/**
 * Given a string expression with parantheses, write a program to examine whether the
 * pairs and orders are in the right order. For example, the program should print true
 * for "[()]{}{[()()]()}" and false for "[(])"
 * Hint: Use a Stack and HashMap
 */
public class BalancedParantheses {
	package com;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;


public class BalancedParanthesis {
	public static void main(String args[]){
        String brackets = "{}{{{}}}";
        
        Stack<Character> stack = new Stack<>();
        boolean isBalanced = true;
 
        for (int i = 0; i < brackets.length(); i++) {
            char bracket = brackets.charAt(i);
            if (bracket == '{' || bracket == '[' || bracket == '(') {
                stack.push(bracket);
            } else {
                if (bracket == '}') {
                    bracket = '{';
                } else if (bracket == ')') {
                    bracket = '(';
                } else if (bracket == ']') {
                    bracket = '[';
                }
 
                if (stack.empty()) {
                    isBalanced = false;
                    break;
                }
 
                if (bracket == stack.peek()) {
                    stack.pop();
                } else {
                    isBalanced = false;
                    break;
                }
            }
        }
 
        if (isBalanced) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
	}

}

}
