package com.arao.challenges.codility;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.*;
import java.util.stream.Collectors;

/**
* Write a program that parses a sentence and replaces each word with the following:
* 1) The first letter of the word
* 2) The number of distinct characters between first and last character
* 3) The last letter of the word.
*
* For example, Smooth would become S3h.
*
* Words are separated by spaces or non-alphabetic characters and these separators should be maintained in their original form and location in the answer.
* A few of the things we will be looking at is accuracy, efficiency, solution completeness.
*
* Example:1
* input: "Creativity is thinking-up new things. Innovation is doing new things!"
* expected: C6y is t4g-up n1w t4s. I6n is d3g n1w t4s!
*/
class WordParser {

    /**
     * IMPERATIVE approach:
     * Original method which is calling the overloaded one so that functionality can receive the divider parameter
     * and having a more scalable program without modify the original call from main method
     *
     * @param input the string to evaluate
     */
    public static String parse(String input) {
        return parse(input, " ").trim();
    }

    /**
     * IMPERATIVE approach:
     * Overloaded method receiving the word divider as parameter in order to use recursion and
     * having a more scalable program
     *
     * @param input the string to evaluate
     * @param wordDivider the identifier that divides two words
     */
    public static String parse(String input, String wordDivider) {

        StringBuilder output = new StringBuilder();
        Set<String> middleWords = new HashSet<>();

        // regex for special characters
        Pattern specialCharsPattern = Pattern.compile("[\\s@&.?!$+-]+");
        Matcher matcher;

        // Split the words from input based on divider received,
        // for dot divider(.) scape it in order to be recognized by split
        String words[] = input.split(wordDivider.equals(".") ? "\\." : wordDivider);

        AtomicInteger counter = new AtomicInteger(words.length);
        String whiteSpace = " ";

        // Iterate for each word in the array
        for(int i=0; i<words.length; i++) {

            matcher = specialCharsPattern.matcher(words[i]);
            if(matcher.find()) {
                // word in turn has a special character then process using recursion to get inner words
                output.append(parse(words[i], matcher.group(0)));

            } else {
                middleWords.clear();
                // Save into a set the intermediate words excluding duplicates
                for(int j=1; j<words[i].length()-1; j++) {
                    middleWords.add(String.valueOf(words[i].charAt(j)));
                }

                long lettersCount = words[i].substring(1, words[i].length() - 1).chars().distinct().count();

                // rules to append last element of every new word set
                String endOfSet = wordDivider;
                if (!whiteSpace.equals(wordDivider) && counter.get() > 1) {
                    if (words.length <= 1)
                        endOfSet = wordDivider + whiteSpace;
                } else {
                    if (words.length == 1)
                        endOfSet = wordDivider + whiteSpace;
                    else
                        endOfSet = whiteSpace;
                }

                // Build into the string builder the final string output
                output.append(String.valueOf(words[i].charAt(0))
                        + (lettersCount > 0 ? lettersCount : "")
                        + words[i].charAt(words[i].length()-1)
                        + endOfSet);

                if (!wordDivider.equals(whiteSpace))
                    counter.getAndDecrement();
            }
        }
        return output.toString();
    }

    /**
     * DECLARATIVE approach:
     * Original method which is calling the overloaded one so that functionality can receive the divider parameter
     * and having a more scalable program without modify the original call from main method
     *
     * @param input the string to evaluate
     */
    public static String parseFunctional(String input) {
        return parseFunctional(input, " ").trim();
    }

    /**
     * DECLARATIVE approach:
     * Overloaded method receiving the word divider as parameter in order to use recursion and
     * having a more scalable program
     *
     * @param input the string to evaluate
     * @param wordDivider the identifier that divides two words
     */
    public static String parseFunctional(String input, String wordDivider) {

        // regex for special characters
        Pattern specialCharsPattern = Pattern.compile("[\\s@&.?!$+-]+");
        StringBuilder output = new StringBuilder();

        // split text into words by divider
        String[] words = input.split(wordDivider.equals(".") ? "\\." : wordDivider);
        AtomicInteger counter = new AtomicInteger(words.length);
        String whiteSpace = " ";

        List<String> result = Arrays.stream(words)
            .map(in -> {
                Matcher matcher = specialCharsPattern.matcher(in);
                if (matcher.find()) {
                    // word in turn has a special character then process using recursion to get inner words
                    output.append(parseFunctional(in, matcher.group(0)));
                } else {
                    long lettersCount = in.substring(1, in.length() - 1).chars().distinct().count();

                    // rules to append last element of every new word set
                    String endOfSet = wordDivider;
                    if (!whiteSpace.equals(wordDivider) && counter.get() > 1) {
                        if (words.length <= 1)
                            endOfSet = wordDivider + whiteSpace;
                    } else {
                        if (words.length == 1)
                            endOfSet = wordDivider + whiteSpace;
                        else
                            endOfSet = whiteSpace;
                    }

                    // Build into the string builder the final string output
                    output.append(String.valueOf(in.charAt(0))
                            + (lettersCount > 0 ? lettersCount : "")
                            + in.charAt(in.length() - 1)
                            + endOfSet);

                    if (!wordDivider.equals(whiteSpace))
                        counter.getAndDecrement();
                }
                return output.toString();
            }).collect(Collectors.toList());

        return output.toString();
    }
}
