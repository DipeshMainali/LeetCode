package com.dipesh.mainali.leetcode.util;

public class Regex {
    public static boolean isNumber(String value) {
        return value != null && value.matches("-?\\d+(\\.\\d+)?");
    }
}
