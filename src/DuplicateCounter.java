import java.util.HashSet;

public class DuplicateCounter {
    public static int countDuplicates(int[] array) {
        HashSet<Integer> uniqueElements = new HashSet<>();
        int duplicatesCount = 0;

        for (int num : array) {
            if (uniqueElements.contains(num)) {
                duplicatesCount++;
            } else {
                uniqueElements.add(num);
            }
        }
        return duplicatesCount;
    }
}
