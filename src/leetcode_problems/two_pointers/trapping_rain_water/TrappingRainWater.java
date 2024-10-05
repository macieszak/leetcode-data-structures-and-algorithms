package leetcode_problems.two_pointers.trapping_rain_water;

public class TrappingRainWater {

    public static int trap(int[] height) {
        if (height.length == 0) {
            return 0;
        }
        int l = 0;
        int r = height.length - 1;
        int leftMax = height[l];
        int rightMax = height[r];
        int result = 0;
        while (l < r) {
            if (leftMax < rightMax) {
                l += 1;
                leftMax = Math.max(leftMax, height[l]);
                result += leftMax - height[l];
            } else {
                r -= 1;
                rightMax = Math.max(rightMax, height[r]);
                result += rightMax - height[r];
            }
        }
        return result;
    }

}
