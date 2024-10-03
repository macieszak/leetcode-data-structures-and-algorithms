package leetcode_problems.arrays_and_hashing.valid_anagram;

import java.util.Arrays;

public class ValidAnagram {

    public static boolean validAnagramMethod(String s, String t) {
        char[] firstWordTab = s.toCharArray();
        char[] secondWordTab = t.toCharArray();
        Arrays.sort(firstWordTab);
        Arrays.sort(secondWordTab);
        return Arrays.equals(firstWordTab, secondWordTab);
    }

    public static boolean isAnagram(String s, String t) {
        int[] alphabet = new int[26];
        for (int i = 0; i < s.length(); i++) {
            alphabet[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            alphabet[t.charAt(i) - 'a']--;
        }
        for (int i : alphabet){
            if (i != 0) {
                return false;
            }
        }
        return true;
    }

}
