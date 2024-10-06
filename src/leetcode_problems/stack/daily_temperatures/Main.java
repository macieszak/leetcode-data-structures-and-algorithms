package leetcode_problems.stack.daily_temperatures;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] temperatures = {73,74,75,71,69,72,76,73};
        int[] results = DailyTemperatures.dailyTemperatures(temperatures);
        System.out.println(Arrays.toString(results));
    }
}
