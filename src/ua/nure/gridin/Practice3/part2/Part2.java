package ua.nure.gridin.Practice3.part2;

import java.io.*;
import java.util.*;

public class Part2 {
    public static String getInput (String fileName) {
        StringBuilder sb = new StringBuilder();
        try {
            Scanner scanner = new Scanner(new File(fileName),"Cp1251");
            while (scanner.hasNextLine()) {
                sb.append(scanner.nextLine()).append(System.lineSeparator());
            }
            return sb.toString().trim();
        } catch(IOException ex) {
            ex.printStackTrace();
        }
        return sb.toString();
    }

    public static String words() {
        String input = ua.nure.gridin.Practice3.part2.Part2.getInput("part2.txt");
        int indexOfNextSpace = input.indexOf(" ");
        int indexOfNextComma = input.indexOf(", ");
        int indexOfNextLineBreak = input.indexOf("\n");
        int indexOfNextApostrophe = input.indexOf("'");
        int indexOfNextHyphen = input.indexOf("-");

        ArrayList<Integer> firstLetterIndex = new ArrayList<Integer>();
        firstLetterIndex.add(0);
        ArrayList<Integer> lastLetterIndex = new ArrayList<Integer>();
        lastLetterIndex.add(input.length() - 1);

        while (indexOfNextSpace != -1) {
            firstLetterIndex.add(indexOfNextSpace + 1);
            lastLetterIndex.add(indexOfNextSpace - 1);
            indexOfNextSpace = input.indexOf(" ", indexOfNextSpace + 1);
        }

        while (indexOfNextComma != -1) {
            lastLetterIndex.remove((Integer)indexOfNextComma);
            lastLetterIndex.add(indexOfNextComma - 1);
            indexOfNextComma = input.indexOf(", ", indexOfNextComma + 1);
        }

        while (indexOfNextLineBreak != -1) {
            firstLetterIndex.add(indexOfNextLineBreak + 1);
            lastLetterIndex.add(indexOfNextLineBreak - 1);
            indexOfNextLineBreak = input.indexOf("\n", indexOfNextLineBreak + 1);
        }

        while (indexOfNextApostrophe != -1) {
            firstLetterIndex.add(indexOfNextApostrophe + 1);
            lastLetterIndex.add(indexOfNextApostrophe - 1);
            indexOfNextApostrophe = input.indexOf("'", indexOfNextApostrophe + 1);
        }

        while (indexOfNextHyphen != -1) {
            firstLetterIndex.add(indexOfNextHyphen + 1);
            lastLetterIndex.add(indexOfNextHyphen - 1);
            indexOfNextHyphen = input.indexOf("-", indexOfNextHyphen + 1);
        }

        Collections.sort(firstLetterIndex);
        Collections.sort(lastLetterIndex);

        ArrayList<String> words = new ArrayList<String>();

        for (int i = 0; i < firstLetterIndex.size(); i++) {
            words.add(input.substring(firstLetterIndex.get(i), lastLetterIndex.get(i) + 1));
        }

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (String str : words) {
            if (str.length() < min) {
                min = str.length();
            }
            if (str.length() > max) {
                max = str.length();
            }
        }

        ArrayList<String> minWords = new ArrayList<String>();
        ArrayList<String> maxWords = new ArrayList<String>();

        for (String str : words) {
            if (str.length() == min && !minWords.contains(str)) {
                minWords.add(str);
            }
            if (str.length() == max && !maxWords.contains(str)) {
                maxWords.add(str);
            }
        }

        StringBuilder builder = new StringBuilder();
        builder.append("Min: ");
        builder.append(String.join(", ", minWords));
        builder.append("\n");
        builder.append("Max: ");
        builder.append(String.join(", ", maxWords));
        String output = builder.toString();

        return output;
    }

    public static void main(String[]args) {
        String input = Part2.getInput("part2.txt");
        System.out.println("Input Text: ");
        System.out.println(input);
        System.out.println("");
        System.out.println("Output: ");
        System.out.println(words());
    }
}