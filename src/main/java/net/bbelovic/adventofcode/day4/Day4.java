package net.bbelovic.adventofcode.day4;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Day4 {
    public long computeNumericpart(String input) {
        long number = 0L;
        try {
            MessageDigest digest = MessageDigest.getInstance("MD5");
            String s = input + number;
            byte[] outputBytes = digest.digest(s.getBytes("UTF-8"));
            String hexString = toHexString(outputBytes);
            while (!hexString.startsWith("000000")) {
                s = (input + (++number));
                outputBytes = digest.digest(s.getBytes());
                hexString = toHexString(outputBytes);
            }

        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return number;
    }

    public static void main(String[] args) {
        String input = "iwrupvqb";
        Day4 day4 = new Day4();
        long numericpart = day4.computeNumericpart(input);
        System.out.println(numericpart);
    }

    private String toHexString(byte[] outputBytes) {
        StringBuilder sb = new StringBuilder();
        for (byte outputByte : outputBytes) {
            String substring = Integer.toString((outputByte & 0xff) + 0x100, 16).substring(1);
            sb.append(substring);
        }
        return sb.toString();
    }
}
