package leetcode_problems.arrays_and_hashing.top_k_frequent_elements;

import java.util.*;
import java.util.stream.Collectors;

public class TopKFrequentElements {
    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> topKFrequentMap = new HashMap<>();
        for (int num : nums) {
            if (topKFrequentMap.containsKey(num)) {
                int counter = topKFrequentMap.get(num);
                counter += 1;
                topKFrequentMap.put(num, counter);
            } else {
                topKFrequentMap.put(num, 1);
            }
        }
        LinkedHashMap<Integer, Integer> sortedByValue = topKFrequentMap.entrySet()
                .stream()
                .sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new));
        int[] returnTab = new int[k];
        Set<Integer> integers = sortedByValue.keySet();
        int i = 0;
        for (Integer integer : integers) {
            returnTab[i] = integer;
            i++;
            if (i == k)
                break;

        }
        return returnTab;
    }

}
