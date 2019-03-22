package com.example.week6test;

import java.util.EmptyStackException;
import java.util.HashMap;
import java.util.Stack;

// 1. Create a program which checks if the string has the correct
// order of parenthesis/brackets. ({})[] = true, []{]}[ = false
public class Problem1 {
    public static HashMap<Character, Character> closeTags = new HashMap<>();

    public static void main(String[] args) {
        initHashMap();
        String str1 = "({}[]((())))[]";
        String str2 = "[]{]}[";
        System.out.println(str1 + " = " + checkForCorrectOrder(str1));
        System.out.println(str2 + " = " + checkForCorrectOrder(str2));
    }

    private static void initHashMap() {
        closeTags.put('(', ')');
        closeTags.put('[', ']');
        closeTags.put('{', '}');
    }

    public static boolean checkForCorrectOrder(String str) {
        Stack<Character> stack = new Stack<>();
        char[] characters = str.toCharArray();
        for (char c : characters) {
            switch (c) {
                case '(':
                case '[':
                case '{':
                    stack.push(c);
                    break;
                default:
                    try {
                        if (c != closeTags.get(stack.pop())) {
                            return false;
                        }
                    } catch (EmptyStackException e) {
                        return false;
                    }
            }
        }
        return true;
    }
}
