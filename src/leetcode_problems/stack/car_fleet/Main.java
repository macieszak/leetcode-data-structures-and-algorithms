package leetcode_problems.stack.car_fleet;

public class Main {
    public static void main(String[] args) {
        int result = CarFleet.carFleet(12, new int[]{10,8,0,5,3}, new int[]{2,4,1,1,3});
        System.out.println(result);

        int result2 = CarFleet.carFleetBetter(10, new int[]{1, 4}, new int[]{3, 2});
        System.out.println(result2);
    }
}
