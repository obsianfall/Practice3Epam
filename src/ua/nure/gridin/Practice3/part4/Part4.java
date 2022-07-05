package ua.nure.gridin.Practice3.part4;

import java.security.*;
import java.util.Arrays;

public class Part4 {
    public static String hash(String input, String algorithm) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance(algorithm);
        digest.update(input.getBytes());
        byte[] hash = digest.digest();
        String[] binaryHash = new String[hash.length];

        for (int i = 0; i < binaryHash.length; i++) {
            binaryHash[i] = Integer.toBinaryString(hash[i]);
        }

//        return Arrays.toString(binaryHash);
        return Arrays.toString(hash);
    }

    public static void main(String[]args) throws NoSuchAlgorithmException {
        System.out.println(hash("password","SHA-256"));
        System.out.println(hash("passwort","SHA-256"));
        System.out.println(hash("password to hash","MD5"));
    }
}
