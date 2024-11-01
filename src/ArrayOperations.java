public class ArrayOperations {
    public static int findByIndex(int[] array, int index) {
        if (index >= 0 && index < array.length) {
            return array[index];
        } else {
            System.out.println("Индекс вне диапазона.");
            return -1;
        }
    }

    public static int findByValue(int[] array, int value) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                return i;
            }
        }
        System.out.println("Элемент не найден.");
        return -1;
    }
}