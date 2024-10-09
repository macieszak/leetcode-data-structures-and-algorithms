package leetcode_problems.stack.car_fleet;

import java.util.Arrays;
import java.util.Stack;

public class CarFleet {

    public static int carFleet(int target, int[] position, int[] speed) {
        if (position == null || position.length == 0) {
            return 0;
        }
        int n = position.length;
        int[][] distance_speed = new int[n][2];
        for (int i = 0; i < n; i++) {
            distance_speed[i][0] = position[i];
            distance_speed[i][1] = speed[i];
        }
        Arrays.sort(distance_speed, (a, b) -> b[0] - a[0]);
        int res = 1;
        double pre_arrive_time = (target - distance_speed[0][0]) * 1.0 / distance_speed[0][1];
        for (int i = 1; i < n; i++) {
            double cur_arrive_time = (target - distance_speed[i][0]) * 1.0 / distance_speed[i][1];
            if (cur_arrive_time > pre_arrive_time) {
                res++;
                pre_arrive_time = cur_arrive_time;
            }
        }
        return res;
    }

    public static int carFleetBetter(int target, int[] position, int[] speed) {
        int res = 0;
        double[] timeArr = new double[target];
        for (int i = 0; i < position.length; i++)
        {
            timeArr[position[i]]= (double)(target - position[i]) / speed[i];
        }
        double prev = 0.0;
        for (int i = target-1; i >=0 ; i--)
        {
            double cur = timeArr[i];
            if (cur > prev)
            {
                prev = cur;
                res++;
            }
        }
        return res;
    }

    public static int carFleetStackSolution(int target, int[] position, int[] speed) {
        // Number of cars
        int n = position.length;

        // Create pairs of position and speed
        double[][] pair = new double[n][2];
        for (int i = 0; i < n; i++) {
            pair[i][0] = position[i];
            pair[i][1] = speed[i];
        }

        // Sort the pairs based on position in ascending order
        Arrays.sort(pair, (a, b) -> Double.compare(a[0], b[0]));

        // Stack to keep track of car fleets
        Stack<Double> stack = new Stack<>();

        // Iterate from the car closest to the target to the farthest
        for (int i = n - 1; i >= 0; i--) {
            // Calculate the time it takes for the current car to reach the target
            double time = (target - pair[i][0]) / pair[i][1];

            // If the stack is not empty and the current car will reach the target
            // earlier or at the same time as the car at the top of the stack, it means
            // the current car will join the fleet of the car at the top of the stack
            if (!stack.isEmpty() && time <= stack.peek()) {
                continue; // Current car joins the fleet of the car at the top of the stack
            }

            // If the current car does not join any existing fleet, push its time to the stack
            stack.push(time);
        }

        // The size of the stack represents the number of car fleets
        return stack.size();
    }

}


