package arrays_and_hashing.group_anagrams;

import java.util.*;

public class GroupAnagrams {

    public static List<List<String>> groupAnagramsMethod(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] charTab = str.toCharArray();
            Arrays.sort(charTab);
            String sortedWord = Arrays.toString(charTab);
            if (map.containsKey(sortedWord)) {
                List<String> listOfAnagrams = map.get(sortedWord);
                listOfAnagrams.add(str);
            } else {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(sortedWord, list);
            }
        }

        List<List<String>> finalListOfAnagrams = new ArrayList<>();
        for (List<String> value : map.values()) {
            List<String> anagramsList = new ArrayList<>(value);
            finalListOfAnagrams.add(anagramsList);
        }
        return finalListOfAnagrams;
    }
}
