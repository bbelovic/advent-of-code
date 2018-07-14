package net.bbelovic.adventofcode.day4;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

class Day4Puzzle {

    private final String zeroPrefix;

    Day4Puzzle(String zeroPrefix) {
        this.zeroPrefix = zeroPrefix;
    }

    long solve(String input) {
        long result = -1L;
        String hexString = "";
        var md5 = getMD5();
        while (!hexString.startsWith(zeroPrefix)) {
            var candidate = (input + (++result));
            var outputBytes = md5.digest(candidate.getBytes());
            hexString = toHexString(outputBytes);
        }

        return result;
    }

    private static MessageDigest getMD5() {
        try {
            return MessageDigest.getInstance("MD5");
        } catch (final NoSuchAlgorithmException e) {
            throw new IllegalStateException("MD5 hash function is not available.", e);
        }
    }

    private static String toHexString(byte[] outputBytes) {
        StringBuilder sb = new StringBuilder();
        for (byte outputByte : outputBytes) {
            String substring = Integer.toString((outputByte & 0xff) + 0x100, 16).substring(1);
            sb.append(substring);
        }
        return sb.toString();
    }
}
