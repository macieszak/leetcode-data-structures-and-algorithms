package leetcode_problems.stack.daily_temperatures;

import java.util.Stack;

public class DailyTemperatures {

    public static int[] dailyTemperatures(int[] temperatures) {
        int[] results = new int[temperatures.length];
        Stack<Integer> indices = new Stack<>();
        for (int i = 0; i < temperatures.length; i++) {
            while (!indices.empty() && temperatures[indices.peek()] < temperatures[i]) {
                results[indices.peek()] = i - indices.pop();
            }
            indices.push(i);
        }
        return results;
    }

}
