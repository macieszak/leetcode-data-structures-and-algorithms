package others;

public class LexicalOrderWord {

    public static String getSmallestWordLexicographicallyLargerThanGiven(String word) {
        char[] letters = word.toCharArray();
        int i = letters.length - 2;

        // (STEP I) Find the first letter that is smaller than the next one (from the end)
        while (i >= 0 && letters[i] >= letters[i + 1]) {
            i--;
        }

        // If no such letter is found, then there is no greater permutation
        if (i == -1) {
            return word;
        }

        // (STEP II) Find the smallest letter greater than letters[i] on the right
        int j = letters.length - 1;
        while (letters[j] <= letters[i]) {
            j--;
        }

        // (STEP III) Swap letters[i] with letters[j]
        swap(letters, i, j);

        // (STEP IV) Flip the part by position 'i'
        reverse(letters, i + 1, letters.length - 1);

        return new String(letters);
    }

    private static void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

    private static void reverse(char[] chars, int start, int end) {
        while (start < end) {
            swap(chars, start, end);
            start++;
            end--;
        }
    }

}
