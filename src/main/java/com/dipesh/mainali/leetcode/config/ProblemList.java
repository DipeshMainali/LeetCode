package com.dipesh.mainali.leetcode.config;

import com.dipesh.mainali.leetcode.problem.Problem;
import com.dipesh.mainali.leetcode.problem.Solution;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class ProblemList {
    private static final Map<Integer, Problem> numberToProblem = new HashMap<>();
    private static final Map<String, Integer> questionToNumber = new HashMap<>();

    static {
        questionToNumber.put("Default", 0);
        numberToProblem.put(0, Problem.Default);
        Properties problemProperties = new Properties();
        try (InputStream input = ProblemList.class.getClassLoader().getResourceAsStream("problem.properties")) {
            if (input != null) {
                System.out.println("Loading Problems");
                problemProperties.load(input);
                for (String stringNumber: problemProperties.stringPropertyNames()) {
                    Integer number = Integer.parseInt(stringNumber);
                    String question = problemProperties.getProperty(stringNumber);

//                    System.out.println(number + ": " + question);
                    questionToNumber.put(question, number);
                    numberToProblem.put(number, Problem.getProblem(question));
                }
            }
        } catch (IOException ioException) {
            System.out.println("Error while loading problems.");
            ioException.printStackTrace();
        }
    }

    public static Solution getSolution(String problemName) {
        Integer problemNumber = getProblemNumber(problemName);
        if (numberToProblem.get(problemNumber) != null)
            return numberToProblem.get(problemNumber).getSolution();
        return numberToProblem.get(0).getSolution();
    }

    public static Solution getSolution(Integer problemNumber) {
        return numberToProblem.getOrDefault(problemNumber, numberToProblem.get(0)).getSolution();
    }

    public static Integer getProblemNumber (String problemName) {
        Integer problemNumber = questionToNumber.get(problemName);
        return problemNumber == null ? 0 : problemNumber;
    }
}
