package algorithm.sorting;

public class QuickSort {
    /**
     * quick sort method for array
     * @param array - original array
     * @param left - left edge index
     * @param right - right edge index
     */
    public static void quickSortZ(int[] array, int left, int right) {
        // step 1:
        // when left is equal to or more than right, stop recursion
        if (left < right) {
            // step 2:
            // find a random position between left and right, swap it with right
            swapZ(array, right, left + (int) (Math.random() * (right - left + 1)));
            // step 3:
            // put all numbers as "less, equal, right", and return the edges of "equal"
            int[] edges = partitionZ(array, left, right);
            // step 4:
            // recurse the left part of the quickSortZ()
            quickSortZ(array, left, --edges[0]);
            // recurse the right part of the quickSortZ()
            quickSortZ(array, ++edges[1], right);
        }
    }

    /**
     * divide the part(between left and right) of the array into three parts:
     *      1. less than pivot part
     *      2. equal to pivot part
     *      3. more than pivot part
     * @param array - original array
     * @param left - left edge index
     * @param right - right edge index
     * @return - an int array with 2 items for recording the edge index of the "equal to pivot part"
     *           array[0] = left edge index of the "equal to pivot part"
     *           array[1] = right edge index of the "equal to pivot part"
     */
    private static int[] partitionZ(int[] array, int left, int right) {
        // step 3.1:
        // initialize variables for the index of less edge and right edge
        int lessEdge = left - 1;
        int moreEdge = right;
        // step 3.2:
        // stop the loop when left index is equal to or more than more edge index
        while (left < moreEdge) {
            // (1) if current index(left) is less than the pivot(right), put it to "less zone"
            if (array[left] < array[right]) {
                swapZ(array, left++, ++lessEdge);
            }
            // (2) if more than it, put to "more zone"
            else if (array[left] > array[right]) {
                swapZ(array, left, --moreEdge);
            }
            // (3) if equals, put to the middle zone
            else {
                left++;
            }
        }
        // step 3.3:
        // swap the pivot(right) and the more edge
        swapZ(array, right, moreEdge);
        // step 3.4:
        return new int[]{++lessEdge, moreEdge};
    }

    /**
     * swap the two items in the array
     * @param array - original array
     * @param index1 - a index of the item
     * @param index2 - a index of the item
     */
    private static void swapZ(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}
