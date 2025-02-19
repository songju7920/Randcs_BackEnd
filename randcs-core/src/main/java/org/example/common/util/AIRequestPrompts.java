package org.example.common.util;

public class AIRequestPrompts {
    public static final String streakProblemPrompt = "Can you pose a different simple problem in computer science (like network, database, OS, etc.)" +
                    "with 4 choices?  Please respond only in the following the format, and write the content in Korean. and dont use character , in respond " +
                    "Do not add numbers in front of the choices, and use a number (not a letter) for the correct answer. do not print any other sentence " +
                    "format: {\"problem\": \"질문 내용\", \"choices\":[\"선지1\", \"선지2\", \"선지3\", \"선지4\"], \"answer\": index number of answer in choices,\"explanation\": \"간단한 설명\"}";
}
