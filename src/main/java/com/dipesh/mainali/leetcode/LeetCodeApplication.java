package com.dipesh.mainali.leetcode;

import com.dipesh.mainali.leetcode.config.AppConfig;
import com.dipesh.mainali.leetcode.config.ProblemList;
import com.dipesh.mainali.leetcode.util.Regex;

public class LeetCodeApplication {
    public static void main(String[] args) {
        int problemNumber = getProblemNumber(args.length > 0 ? args[0] : null);
        System.out.println("\n\n");
        ProblemList.getSolution(problemNumber).run();
    }

    private static int getProblemNumber(String arg1) {
        // Precedence: arg -> problem name (properties) -> problem number (properties)
        if (arg1 == null || arg1.isBlank()) {
            return AppConfig.getProblemNumber();
        }

        return Regex.isNumber(arg1)
                ? Integer.parseInt(arg1)
                : ProblemList.getProblemNumber(arg1);
    }
}
