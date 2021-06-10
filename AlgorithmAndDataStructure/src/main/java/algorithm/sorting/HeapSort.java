package algorithm.sorting;

public class HeapSort {

    /**
     * heap sort
     * @param array - the array for sorting
     */
    public static void heapSort(int[] array) {
        // 1. check null or just one item
        if (array == null || array.length == 1) {
            return;
        }
        // 2. set an int variable for heap size
        int heapSize = array.length;
        // 3. adjust the array to a max heap by adjust from the top item
        for (int i = heapSize - 1; i >= 0; i--) {
            adjustFromTop(array, i, heapSize);
        }
        // 4. swap the top item with the last item
        swap(array, 0, --heapSize);
        // 5. loop until the heapSize == 0
        while (heapSize > 0) {
            adjustFromTop(array, 0, heapSize);
            swap(array, 0, --heapSize);
        }
    }

    /**
     * check and swap the ensure the max heap from the top item
     * @param maxHeap - the array for the max heap
     * @param topIndex - the topIndex of the top item
     * @param heapSize - the valid range of the heap
     */
    public static void adjustFromTop(int[] maxHeap, int topIndex, int heapSize) {
        // 1. get the left child
        int leftChildIndex = topIndex * 2 + 1;
        // 2. loop: stop the loop if there is no children
        while (leftChildIndex < heapSize) {
            // 2.1 compare left child and right child and get the max child topIndex
            int maxChildIndex = (leftChildIndex + 1 < heapSize && maxHeap[leftChildIndex + 1] > maxHeap[leftChildIndex]) ?
                    leftChildIndex + 1 : leftChildIndex;
            // 2.2 stop the loop if father > children
            if (maxHeap[topIndex] >= maxHeap[maxChildIndex]) {
                break;
            }
            // 2.3 swap father and the max children if children > father
            swap(maxHeap, topIndex, maxChildIndex);
            // 2.4 move the current topIndex to the max child and update the left child topIndex
            topIndex = maxChildIndex;
            leftChildIndex = topIndex * 2 + 1;
        }
    }

    /**
     * swap two items in the heap by their index
     * @param maxHeap - the array for the max heap
     * @param index1 - an index of one item
     * @param index2 - an index of the other item
     */
    public static void swap(int[] maxHeap, int index1, int index2) {
        int temp = maxHeap[index1];
        maxHeap[index1] = maxHeap[index2];
        maxHeap[index2] = temp;
    }
}
