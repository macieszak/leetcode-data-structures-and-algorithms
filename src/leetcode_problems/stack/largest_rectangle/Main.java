package leetcode_problems.stack.largest_rectangle;

public class Main {
    public static void main(String[] args) {
        int[] heights = new int[] {2, 1, 5, 6, 2, 3};
        int result = LargestRectangleInHistogram.largestRectangleArea(heights);
        System.out.println(result);

        LargestRectangleInHistogram largestRectangleInHistogram = new LargestRectangleInHistogram();
        int result2 = largestRectangleInHistogram.largestRectangleAreaNotOptimal(heights);
        System.out.println(result2);
    }
}
