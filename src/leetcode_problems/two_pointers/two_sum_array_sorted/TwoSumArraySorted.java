package leetcode_problems.two_pointers.two_sum_array_sorted;

import java.util.HashMap;
import java.util.Map;

public class TwoSumArraySorted {

    public static int[] twoSum(int[] numbers, int target) {
        int difference;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            difference = target - numbers[i];
            if (map.containsKey(difference)) {
                return new int[]{map.get(difference), i+1};
            } else {
                map.put(numbers[i], i+1);
            }
        }
        return null;
    }

}
