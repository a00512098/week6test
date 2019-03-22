package com.example.week6test;

// 2. Given a string and a non-empty substring sub,
// compute recursively if at least n copies of sub appear
// in the string somewhere, possibly with overlapping.
// N will be non-negative.
//
//strCopies("catcowcat", "cat", 2) → true
//strCopies("catcowcat", "cow", 2) → false
//strCopies("catcowcat", "cow", 1) → true

public class Problem2 {
    public static void main(String[] args) {
        System.out.println(strCopies("catcowcat", "cat", 2)); // true
        System.out.println(strCopies("catcowcat", "cow", 2)); // false
        System.out.println(strCopies("catcowcat", "cow", 1)); // true
        System.out.println(strCopies("catcowcatcatcowcat", "cow", 3)); //false
        System.out.println(strCopies("catcowcatcatcowcat", "cat", 3)); // true
    }

    public static boolean strCopies(String  str, String subStr, int numberOfSubStr) {
        return checkForCopies(str, subStr, 0) >= numberOfSubStr;
    }

    private static int checkForCopies(String str, String subStr, int numberOfSubStr) {
        if (str.contains(subStr)) {
            numberOfSubStr++;
            int index = str.indexOf(subStr) + subStr.length();
            return checkForCopies(str.substring(index), subStr, numberOfSubStr);
        }

        return numberOfSubStr;
    }
}
