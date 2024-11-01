class ArrayModification {
    public static int[] addElement(int[] array, int element) {
        int[] newArray = new int[array.length + 1];
        System.arraycopy(array, 0, newArray, 0, array.length);
        newArray[array.length] = element;
        CombSort.combSort(newArray);
        return newArray;
    }

    public static int[] removeElement(int[] array, int index) {
        if (index < 0 || index >= array.length) {
            System.out.println("Неверный индекс.");
            return array;
        }

        int[] newArray = new int[array.length - 1];
        System.arraycopy(array, 0, newArray, 0, index);
        System.arraycopy(array, index + 1, newArray, index, array.length - index - 1);
        CombSort.combSort(newArray);
        return newArray;
    }
}
