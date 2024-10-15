package leetcode_problems.stack.largest_rectangle;

import java.util.Arrays;
import java.util.Stack;

public class LargestRectangleInHistogram {

    public int largestRectangleAreaNotOptimal(int[] heights) {
        int res = 0, n = heights.length;
        for (int i = 0; i < n; i++) {
            int curr = heights[i];
            for (int j = i - 1; j >= 0 && heights[j] >= heights[i]; j--)
                curr += heights[i];
            for (int j = i + 1; j < n && heights[j] >= heights[i]; j++)
                curr += heights[i];
            res = Math.max(res, curr);
        }
        return res;
    }

    public int largestRectangleArea(int[] heights) {
        int[] previousSmallerTab = previousSmaller(heights);
        int[] nextSmallerTab = nextSmaller(heights);
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            int width = nextSmallerTab[i] - previousSmallerTab[i] - 1;
            int area = heights[i] * width;
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }

    public int[] nextSmaller(int[] heights) {
        int n = heights.length;
        int[] nextSmallerTab = new int[n];
        Arrays.fill(nextSmallerTab, n);
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && heights[i] < heights[st.peek()]) {
                nextSmallerTab[st.pop()] = i;
            }
            st.push(i);
        }
        return nextSmallerTab;
    }

    public int[] previousSmaller(int[] heights) {
        int n = heights.length;
        int[] previousSmallerTab = new int[n];
        Arrays.fill(previousSmallerTab, -1);
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && heights[i] < heights[st.peek()]) {
                st.pop();
            }
            if (!st.isEmpty()) {
                previousSmallerTab[i] = st.peek();
            }
            st.push(i);
        }
        return previousSmallerTab;
    }

}