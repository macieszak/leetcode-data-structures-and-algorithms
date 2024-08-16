package searching_algorithms;

public class BinarySearch {

    public static int binarySearch(int[] array, int searchedValue) {
        int low = 0;
        int high = array.length - 1;
        while (low <= high) {
            int middleIndex = low + (high - low) / 2;
            int middleValue = array[middleIndex];
            System.out.println("middle:" + middleValue + " at index " + middleIndex);
            if (middleValue < searchedValue) {
                low = middleIndex + 1;
            } else if (middleValue > searchedValue) {
                high = middleIndex - 1;
            } else {
                return middleIndex;
            }
        }
        return -1;
    }



}
