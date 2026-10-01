package com.dipesh.mainali.leetcode.config;

import com.dipesh.mainali.leetcode.util.Regex;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class AppConfig {
    private static final Properties properties = new Properties();
    private static int problemNumber = 0;

    static {
        try(InputStream input = AppConfig.class.getClassLoader().getResourceAsStream("application.properties")) {
            if (input != null) {
                properties.load(input);
                System.out.println(properties.getProperty("application.name") + ":\n");
                setProblemNumber();
            }
        } catch (IOException ioException) {
            System.out.println("Error loading properties file");
        }
    }

    private static void setProblemNumber() {
        String problemName = properties.getProperty("problem.name");
        if (problemName != null) {
            problemNumber = ProblemList.getProblemNumber(problemName);
        }

        problemNumber = Regex.isNumber(properties.getProperty("problem.number"))
                ? Integer.parseInt(properties.getProperty("problem.number"))
                : 0;

    }
    public static int getProblemNumber() {
        return problemNumber;
    }

}
