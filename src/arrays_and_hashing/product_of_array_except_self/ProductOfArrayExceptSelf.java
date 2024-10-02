package arrays_and_hashing.product_of_array_except_self;

public class ProductOfArrayExceptSelf {

    //brute-force method - not optimal
    public static int[] productExceptSelf(int[] nums) {
        int[] resultTab = new int[nums.length];
        int multiplicationResult = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (j == i) {
                    continue;
                }
                multiplicationResult *= nums[j];
            }
            resultTab[i] = multiplicationResult;
            multiplicationResult = 1;
        }
        return resultTab;
    }

    //more optimal approach, but not the best
    public static int[] productExceptSelfMoreOptimal(int[] nums) {
        int length = nums.length;
        int[] leftNumbers = new int[length];
        int[] rightNumbers = new int[length];
        int[] finalNumbers = new int[length];
        leftNumbers[0] = 1;
        rightNumbers[length-1] = 1;
        for (int i = 1; i < length; i++) {
            leftNumbers[i] = leftNumbers[i-1] * nums[i-1];
        }
        for (int i = length-2; i >= 0; i--) {
            rightNumbers[i] = rightNumbers[i+1] * nums[i+1];
        }
        for (int i = 0; i < finalNumbers.length; i++) {
            finalNumbers[i] = leftNumbers[i] * rightNumbers[i];
        }
        return finalNumbers;
    }

    //the best
    public static int[] productExceptSelfBestApproach(int[] nums) {
        int[] answer = new int[nums.length];
        int prefix = 1;
        for (int i = 0; i < nums.length; i++) {
            answer[i] = prefix;
            prefix *= nums[i];
        }
        int suffix = 1;
        for(int j=nums.length-1; j>=0; j--) {
            answer[j] *= suffix;
            suffix *= nums[j];
        }
        return answer;
    }

}
