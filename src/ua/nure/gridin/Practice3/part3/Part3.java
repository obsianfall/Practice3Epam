package ua.nure.gridin.Practice3.part3;

import java.io.*;
import java.util.Scanner;

public class Part3 {
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

    public static String firstLettersToUpperCase() {
        String input = ua.nure.gridin.Practice3.part3.Part3.getInput("part2.txt");
        StringBuilder builder = new StringBuilder();
        int indexOfNextWord = input.indexOf(" ") + 1;
        int indexOfLastWord = input.lastIndexOf(" ") + 1;
        builder.append(input.substring(0, 1));
        builder.setCharAt(0,
                Character.toUpperCase(builder.charAt(0)));
        builder.append(input.substring(1, indexOfNextWord));

        while (indexOfNextWord <= indexOfLastWord) {
            String firstCharOfTheWord = input.substring(indexOfNextWord, indexOfNextWord + 1);
            builder.append(firstCharOfTheWord.toUpperCase());
            if (indexOfNextWord == indexOfLastWord) {
                break;
            }
            int newIndexOfNextWord = input.indexOf(" ", indexOfNextWord) + 1;
            builder.append(input.substring(indexOfNextWord + 1, newIndexOfNextWord));
            indexOfNextWord = newIndexOfNextWord;
        }

        builder.append(input.substring(indexOfLastWord + 1, input.length()));

        String output = builder.toString();

        return output;
    }

    public static void main(String[]args) {
        String input = Part3.getInput("part2.txt");
        System.out.println("Input Text: ");
        System.out.println(input);
        System.out.println("");
        System.out.println("Output Text: ");
        System.out.println(firstLettersToUpperCase());
    }
}