package ua.nure.gridin.Practice3.part1;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.lang.Math;

public class Part1 {
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

    public static String convert1(String input) {
        int nextIndexOfLogin = input.indexOf("\n") + 1;
        int nextIndexOfSemicolon = input.indexOf(";", nextIndexOfLogin);
        int lastIndexOfSemicolon = input.lastIndexOf(";");
        StringBuilder builder = new StringBuilder();

        while (nextIndexOfSemicolon <= lastIndexOfSemicolon) {
            builder.append(input.substring(nextIndexOfLogin, nextIndexOfSemicolon)); //login is added
            builder.append(" ==> ");
            nextIndexOfSemicolon = input.indexOf(";", nextIndexOfSemicolon + 1); //name is ignored
            nextIndexOfLogin = input.indexOf("\n", nextIndexOfLogin) + 1;

            if (nextIndexOfLogin == 0) {
                builder.append(input.substring(nextIndexOfSemicolon + 1, input.length()));
                break;
            }
            else {
                builder.append(input.substring(nextIndexOfSemicolon + 1, nextIndexOfLogin)); //email is added; with line break
            }

            nextIndexOfSemicolon = input.indexOf(";", nextIndexOfLogin);
        }

        return builder.toString();
    }


    public static String convert2(String input) {
        ArrayList<String> lines = new ArrayList<String>();
        int indexOfLineBreak = input.indexOf("\n");

        while (indexOfLineBreak != input.length()) {
            int indexOfNextLineBreak = input.indexOf("\n", indexOfLineBreak + 1);
            if (indexOfNextLineBreak == -1) {
                indexOfNextLineBreak = input.length();
            }
            lines.add(input.substring(indexOfLineBreak + 1, indexOfNextLineBreak));
            indexOfLineBreak = indexOfNextLineBreak;
        }

        ArrayList<String> names = new ArrayList<String>();
        for (String str : lines) {
            int firstSemicolonIndex = str.indexOf(";");
            int secondSemicolonIndex = str.indexOf(";", firstSemicolonIndex + 1);
            names.add(str.substring(firstSemicolonIndex + 1, secondSemicolonIndex));
            }

        ArrayList<String> finalNames = new ArrayList<String>();
        for (String str : names) {
            finalNames.add(str.substring(str.indexOf(" ") + 1) + " " + str.substring(0, str.indexOf(" ")));
        }

        ArrayList<String> emails = new ArrayList<String>();
        for (String str : lines) {
            int firstSemicolonIndex = str.indexOf(";");
            int secondSemicolonIndex = str.indexOf(";", firstSemicolonIndex + 1);
            emails.add(str.substring(secondSemicolonIndex + 1));
        }


        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < finalNames.size(); i++) {
            builder.append(finalNames.get(i));
            builder.append(" (email: ");
            builder.append(emails.get(i));
            builder.append(")");
            builder.append("\n");
        }
        builder.deleteCharAt(builder.length() - 1);

        return builder.toString();
        }


    public static String convert3(String input) {
        ArrayList<String> lines = new ArrayList<String>();
        int indexOfLineBreak = input.indexOf("\n");

        while (indexOfLineBreak != input.length()) {
            int indexOfNextLineBreak = input.indexOf("\n", indexOfLineBreak + 1);
            if (indexOfNextLineBreak == -1) {
                indexOfNextLineBreak = input.length();
            }
            lines.add(input.substring(indexOfLineBreak + 1, indexOfNextLineBreak));
            indexOfLineBreak = indexOfNextLineBreak;
        }

        ArrayList<String> mailDomens = new ArrayList<String>();
        for (String str : lines) {
            if (!mailDomens.contains(str.substring(str.indexOf("@") + 1))) {
                mailDomens.add(str.substring(str.indexOf("@") + 1));
            }
        }

        StringBuilder builder = new StringBuilder();

        for (String str : mailDomens) {
            builder.append(str);
            builder.append(" ==> ");

            for (String strLine : lines) {
                if (strLine.contains(str)) {
                    builder.append(strLine.substring(0, strLine.indexOf(";")));
                    builder.append(", ");
                }
            }
            builder.replace(builder.length() - 2, builder.length(), "\n");
        }

        builder.deleteCharAt(builder.length() - 1);

        return builder.toString();
    }

    public static String convert4(String input) {
        int nextIndexOfLineBreak = input.indexOf("\n");
        StringBuilder builder = new StringBuilder(input.substring(0, nextIndexOfLineBreak)); //output is initialized with the first line
        builder.append(";Password"); //additional column is added
        int newIndexOfLineBreak;

        while (nextIndexOfLineBreak < input.length()) {
            newIndexOfLineBreak = input.indexOf("\n", nextIndexOfLineBreak + 1);

            if (newIndexOfLineBreak == -1) {
                newIndexOfLineBreak = input.length();
            }

            builder.append(input.substring(nextIndexOfLineBreak, newIndexOfLineBreak)); //next line is added; with line break at the beginning
            nextIndexOfLineBreak = newIndexOfLineBreak;
            builder.append(";"); //semicolon is added

            for (int i = 0; i < 4; i++) {
                int x = (int) (Math.random() * 10);
                builder.append("" + x);  //four-digit password is added
            }

        }

        return builder.toString();

    }


    public static void main(String[]args) {
        System.out.println("Input Text: ");
        String input = Part1.getInput("part1.txt");
        System.out.println(input);
        System.out.println("");
        System.out.println("convert1() Output: ");
        System.out.println(convert1(input));
        System.out.println("");
        System.out.println("convert2() Output: ");
        System.out.println(convert2(input));
        System.out.println("");
        System.out.println("convert3() Output: ");
        System.out.println(convert3(input));
        System.out.println("");
        System.out.println("convert4() Output: ");
        System.out.println(convert4(input));

    }
}
