package leetcode_problems.stack.largest_rectangle;

public class LargestRectangleInHistogram {

    //area = heights[i] * (endingPoint - startingPoint + 1)
    public static int largestRectangleArea(int[] heights) {

        return -1;
    }

    public int largestRectangleAreaNotOptimal(int[] heights) {
        int res = 0, n = heights.length;

        for (int i = 0; i < n; i++) {
            int curr = heights[i];

            // Traverse left while we have a greater height bar
            for (int j = i - 1; j >= 0 && heights[j] >= heights[i]; j--)
                curr += heights[i];

            // Traverse right while we have a greater height bar
            for (int j = i + 1; j < n && heights[j] >= heights[i]; j++)
                curr += heights[i];
            res = Math.max(res, curr);
        }
        return res;
    }

}