package arrays_and_hashing.longest_consecutive_sequence;

import java.util.*;

public class LongestConsecutiveSequence {

    public static int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        Set<Integer> setIntegers = new HashSet<>();
        for (Integer num : nums) {
            setIntegers.add(num);
        }
        int[] newTab = new int[setIntegers.size()];
        int j = 0;
        for (Integer setInteger : setIntegers) {
            newTab[j++] = setInteger;
        }
        Arrays.sort(newTab);
        int start = newTab[0];
        int counter = 1;
        int max = 1;
        for (int i = 1; i < newTab.length; i++) {
            if (newTab[i] == start + 1) {
                counter++;
                if (counter > max) {
                    max = counter;
                }
            } else {
                counter = 1;
            }
            start = newTab[i];
        }
        return max;
    }

}
