public class CombSort {
    public static int comparisons = 0;
    public static int swaps = 0;

    public static void combSort(int[] array) {
        int gap = array.length;
        boolean swapped = true;
        double shrinkFactor = 1.3;

        comparisons = 0;
        swaps = 0;

        while (gap > 1 || swapped) {
            if (gap > 1) {
                gap = (int)(gap / shrinkFactor);
            }

            swapped = false;
            for (int i = 0; i + gap < array.length; i++) {
                comparisons++;
                if (array[i] > array[i + gap]) {
                    int temp = array[i];
                    array[i] = array[i + gap];
                    array[i + gap] = temp;
                    swapped = true;
                    swaps++;
                }
            }
        }
    }
}
