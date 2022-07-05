package ua.nure.gridin.Practice3;

import ua.nure.gridin.Practice3.part1.Part1;
import ua.nure.gridin.Practice3.part2.Part2;
import ua.nure.gridin.Practice3.part3.Part3;
import ua.nure.gridin.Practice3.part5.Part5;

public class Demo {
    public static void main(String[] args) {
        System.out.println("---Part1---");
        System.out.println("Input Text: ");
        String input1 = Part1.getInput("part1.txt");
        System.out.println(input1);
        System.out.println("");
        System.out.println("convert1() Output: ");
        System.out.println(Part1.convert1(input1));
        System.out.println("");
        System.out.println("convert2() Output: ");
        System.out.println(Part1.convert2(input1));
        System.out.println("");
        System.out.println("convert3() Output: ");
        System.out.println(Part1.convert3(input1));
        System.out.println("");
        System.out.println("convert4() Output: ");
        System.out.println(Part1.convert4(input1));
        System.out.println("");
        System.out.println("---Part2---");
        String input2 = Part2.getInput("part2.txt");
        System.out.println("Input Text: ");
        System.out.println(input2);
        System.out.println("");
        System.out.println("Output: ");
        System.out.println(Part2.words());
        System.out.println("");
        System.out.println("---Part3---");
        String input3 = Part3.getInput("part2.txt");
        System.out.println("Input Text: ");
        System.out.println(input3);
        System.out.println("");
        System.out.println("Output Text: ");
        System.out.println(Part3.firstLettersToUpperCase());
        System.out.println("");
        System.out.println("---Part5---");
        StringBuilder builder = new StringBuilder();
        for (int i = 1; i <= 100; i++) {
            builder.append( i + " ====> " + Part5.decimal2Roman(i) + " ====> " + Part5.roman2Decimal(Part5.decimal2Roman(i)) + "\n");
        }
        System.out.println(builder.toString());
    }
}