package leetcode_problems.stack.generate_parentheses;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

    public static List<String> generateParenthesis(int n) {
        List<String> outputArr = new ArrayList<>();
        backtrack(outputArr, "", 0, 0, n);
        return outputArr;
    }

    private static void backtrack(List<String> outputArr, String currentString, int open, int close, int max) {
        if (currentString.length() == max * 2) {
            outputArr.add(currentString);
            return;
        }
        if (open < max){
            backtrack(outputArr, currentString + "(", open + 1, close, max);
        }
        if (close < open) {
            backtrack(outputArr, currentString + ")", open, close + 1, max);
        }
    }

}
