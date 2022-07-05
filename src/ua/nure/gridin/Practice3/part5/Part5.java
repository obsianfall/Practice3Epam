package ua.nure.gridin.Practice3.part5;

public class Part5 {
    public static String decimal2Roman (int x) {
        if (x <= 10) {
            return decimal2RomanInner(x, 0);
        }

        if (x > 10 && x <= 100) {
            StringBuilder builder = new StringBuilder();
            int y = x / 10;
            builder.append(decimal2RomanInner(y, 2));
            int z = x % 10;
            builder.append(decimal2RomanInner(z, 0));
            return builder.toString();
        }

        return null;
    }

    public static String decimal2RomanInner(int x, int offset) {
        String[] numbersBank = new String[] {"I", "V", "X", "L", "C"};
        StringBuilder builder = new StringBuilder();
        if (x == 1) {
            builder.append(numbersBank[0 + offset]);
        }
        if (x == 2) {
            builder.append(numbersBank[0 + offset]);
            builder.append(numbersBank[0 + offset]);
        }
        if (x == 3) {
            builder.append(numbersBank[0 + offset]);
            builder.append(numbersBank[0 + offset]);
            builder.append(numbersBank[0 + offset]);
        }
        if (x == 4) {
            builder.append(numbersBank[0 + offset]);
            builder.append(numbersBank[1 + offset]);
        }
        if (x == 5) {
            builder.append(numbersBank[1 + offset]);
        }
        if (x == 6) {
            builder.append(numbersBank[1 + offset]);
            builder.append(numbersBank[0 + offset]);
        }
        if (x == 7) {
            builder.append(numbersBank[1 + offset]);
            builder.append(numbersBank[0 + offset]);
            builder.append(numbersBank[0 + offset]);
        }
        if (x == 8) {
            builder.append(numbersBank[1 + offset]);
            builder.append(numbersBank[0 + offset]);
            builder.append(numbersBank[0 + offset]);
            builder.append(numbersBank[0 + offset]);
        }
        if (x == 9) {
            builder.append(numbersBank[0 + offset]);
            builder.append(numbersBank[2 + offset]);
        }
        if (x == 10) {
            builder.append(numbersBank[2 + offset]);
        }

        return builder.toString();
    }

    public static int roman2Decimal(String s) {
        String[] chars = s.split("");
        int[] numbers = new int[chars.length];
        for (int i = 0; i < chars.length; i++) {
            numbers[i] = roman2DecimalInner(chars[i]);
        }

        int result = 0;

        if (numbers.length == 1) {
            result = numbers[0];
        }

        for (int i = 0; i < numbers.length - 1; i++) {
            int x;

            if (numbers[i + 1] > numbers[i]) {
                x = numbers[i + 1] - numbers[i];
                result += x;
                i++;

                if (i == numbers.length - 2) {
                    result += numbers[numbers.length - 1];
                }
            }
            else {
                result += numbers[i];
                if (i == numbers.length - 2) {
                    result += numbers[numbers.length - 1];
                }
            }
        }

        return result;
    }

    public static int roman2DecimalInner(String s) {
        if (s.equals("I")) {
            return 1;
        }
        if (s.equals("V")) {
            return 5;
        }
        if (s.equals("X")) {
            return 10;
        }
        if (s.equals("L")) {
            return 50;
        }
        if (s.equals("C")) {
            return 100;
        }

        return -1;
    }

    public static void main(String[] args) {
        StringBuilder builder = new StringBuilder();
        for (int i = 1; i <= 100; i++) {
            builder.append( i + " ====> " + decimal2Roman(i) + " ====> " + roman2Decimal(decimal2Roman(i)) + "\n");
        }
        System.out.println(builder.toString());
    }

}