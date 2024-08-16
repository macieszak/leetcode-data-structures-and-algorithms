package two_pointers.three_sum;

import java.util.*;

public class ThreeSum {

    public static List<List<Integer>> threeSum(int[] nums) {    //brute force method. n^3, time limit exceeded
        List<List<Integer>> list = new ArrayList<>();
        int n = nums.length;

        if (n < 3) return list;

        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    List<Integer> l = new ArrayList<>();

                    if (nums[i] + nums[j] + nums[k] == 0) {
                        l.add(nums[i]);
                        l.add(nums[j]);
                        l.add(nums[k]);
                        Collections.sort(l);

                        if (!list.contains(l))
                            list.add(l);
                    }
                }
            }
        }

        return list;
    }

    public static List<List<Integer>> threeSum_2(int[] nums) {  // n^2
        Arrays.sort(nums);
        List<List<Integer>> outputArr = new LinkedList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
                int low = i + 1;
                int high = nums.length - 1;
                int sum = 0 - nums[i];

                while (low < high) {
                    if (nums[low] + nums[high] == sum) {
                        outputArr.add(Arrays.asList(nums[i], nums[low], nums[high]));
                        while (low < high && nums[low] == nums[low + 1]) {
                            low++;
                        }
                        while (low < high && nums[high] == nums[high - 1]) {
                            high--;
                        }
                        low++;
                        high--;
                    } else if (nums[low] + nums[high] > sum) {
                        high--;
                    } else {
                        low++;
                    }
                }

            }
        }

        return outputArr;
    }


}
