package net.bbelovic.adventofcode.day4;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

class Day4 {

    private final String zeroPrefix;

    Day4(String zeroPrefix) {
        this.zeroPrefix = zeroPrefix;
    }

    long solve(String input) {
        long number = 0L;
        try {
            MessageDigest digest = MessageDigest.getInstance("MD5");
            String s = input + number;
            byte[] outputBytes = digest.digest(s.getBytes("UTF-8"));
            String hexString = toHexString(outputBytes);
            while (!hexString.startsWith(zeroPrefix)) {
                s = (input + (++number));
                outputBytes = digest.digest(s.getBytes());
                hexString = toHexString(outputBytes);
            }

        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return number;
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
