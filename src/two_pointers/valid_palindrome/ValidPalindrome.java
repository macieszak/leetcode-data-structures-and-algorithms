package two_pointers.valid_palindrome;

import java.util.Arrays;

public class ValidPalindrome {

    public static boolean isPalindrome(String s) {
        s = s.toLowerCase();
        s = s.replaceAll("[^a-zA-Z0-9]", "");
        char[] palindromeTab = s.toCharArray();
        char[] reversePalindromeTab = new char[palindromeTab.length];
        for (int i = 0, j = palindromeTab.length-1; i < palindromeTab.length; i++) {
            reversePalindromeTab[i] = palindromeTab[j];
            j--;
        }
        return Arrays.equals(palindromeTab, reversePalindromeTab);
    }


}
