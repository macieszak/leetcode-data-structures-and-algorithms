package two_pointers.container_with_most_water;

public class ContainerWithMostWater {

    public static int maxArea(int[] height) {
        int waterContainerMax = 0;
        int waterContainerFinal = 0;
        for (int i = 0; i < height.length; i++) {
            int low = i;
            int max = height.length-1;
            int lengthBetweenPointers = max - low;
            while (low <= max) {
                if (height[low] <= height[max]) {
                    waterContainerMax = height[low] * lengthBetweenPointers;
                    low++;
                } else {
                    waterContainerMax = height[max] * lengthBetweenPointers;
                    max--;
                }
                lengthBetweenPointers = max - low;

                if (waterContainerFinal < waterContainerMax) {
                    waterContainerFinal = waterContainerMax;
                }
            }
        }
        return waterContainerFinal;
    }

    public static int maxArea_2(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;

        while (left < right) {
            int width = right - left;
            int currentHeight = Math.min(height[left], height[right]);
            int currentArea = width * currentHeight;
            maxArea = Math.max(maxArea, currentArea);

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }




}
