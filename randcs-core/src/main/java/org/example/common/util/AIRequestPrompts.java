package org.example.common.util;

public class AIRequestPrompts {
    public static final String streakProblemPrompt = "Can you pose a different simple problem in computer science (like network, database, OS, etc.)" +
                    "with short simple answer Please respond only in the following the format, and write the content in Korean. and dont use character , in respond " +
                    "Do not add numbers in front of the choices, and use a number (not a letter) for the correct answer. do not print any other sentence " +
                    "format: {\"problem\": \"질문 내용\", \"choices\":[\"선지1\", \"선지2\", \"선지3\", \"선지4\"], \"answer\": index number of answer in choices,\"explanation\": \"간단한 설명\"}";

    public static final String getHardProblemPrompt = "Can you pose a different simple problem in computer science (like network, database, OS, etc.)" +
            "in short answer question Please respond only in the following the format, and write the content in Korean. " +
            "do not print any other sentence. and plz make problem can be answered with one word or sentence" +
            "format: {\"problem\": \"질문 내용\"}";

    public static String getCheckProblemAnswerPrompt(String problem, String answer) {
        return "Here is a problem and an answer. Determine if the answer is correct or wrong. respond only in the following the format. and do not print any other sentence.\n" +
                "format: {\"result\": \"True or False\", \"message\": \"간단한 설명\"}\n" +
                "Problem: " + problem + "\n" +
                "Answer: " + answer;
    }
}
