package dsa.searching_algorithms;

public class LinearSearch {

    //returns the index of the searched item
    public static int linearSearch(int[] array, int searchedItem) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == searchedItem)
                return i;
        }
        return -1;
    }

}
