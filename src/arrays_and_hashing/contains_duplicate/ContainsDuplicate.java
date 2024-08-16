package arrays_and_hashing.contains_duplicate;

import java.util.*;

public class ContainsDuplicate {

    public static boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }



    public static boolean containsDuplicateMoreOptimally(int[] nums) {
        Set<Integer> numbers = new HashSet<>();
        for (int num : nums) {
            if (numbers.contains(num)) {
                return true;
            }
            numbers.add(num);
        }
        return false;
    }




}
