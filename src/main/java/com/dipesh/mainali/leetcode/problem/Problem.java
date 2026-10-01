package com.dipesh.mainali.leetcode.problem;

import com.dipesh.mainali.leetcode.problem.dynamic_programming.ClimbingStairs;

public enum Problem {
    Default(new Solution() {
        @Override
        public void run() {
            Solution.super.run();
        }
    }),
    ClimbingStairs(new ClimbingStairs()),
    ErrorQuestionLoading(new Solution() {
        @Override
        public void run() {
            System.out.println("Error Loading Question.");
        }
    });

    private final Solution solution;
    private final String problemName;
    Problem(Solution solution) {
                this.solution = solution;
                this.problemName = this.name();
    }

    Problem(Solution solution, String problemName) {
        this.solution = solution;
        this.problemName = problemName;
    }

    public Solution getSolution() {
        return solution;
    }

    public String getProblemName() {
        return problemName;
    }

    public static Problem getProblem(String value) {
        try {
            return Problem.valueOf(value);
        } catch (IllegalArgumentException ex) {
            for (Problem problem : Problem.values()) {
                if (problem.getProblemName().equals(value)) return problem;
            }
            return ErrorQuestionLoading;
        }
    }
}
