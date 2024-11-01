import java.util.Arrays;

public class SortAnalysis {
    public static void analyzeSorting(int[] array) {
        long startTime, endTime;

        startTime = System.nanoTime();
        CombSort.combSort(array.clone());
        endTime = System.nanoTime();
        System.out.println("Время для неупорядоченных данных: " + (endTime - startTime) + " нс");

        int[] partiallySorted = array.clone();
        Arrays.sort(partiallySorted, 0, array.length / 2);
        startTime = System.nanoTime();
        CombSort.combSort(partiallySorted);
        endTime = System.nanoTime();
        System.out.println("Время для частично упорядоченных данных: " + (endTime - startTime) + " нс");

        int[] sorted = array.clone();
        Arrays.sort(sorted);
        startTime = System.nanoTime();
        CombSort.combSort(sorted);
        endTime = System.nanoTime();
        System.out.println("Время для отсортированных данных: " + (endTime - startTime) + " нс");
    }
}
