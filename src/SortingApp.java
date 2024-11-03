import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class SortingApp {

    private static Scanner scanner = new Scanner(System.in);
    private static int[] array;

    public static void main(String[] args) {
        inputArray();
        showMenu();
    }

    private static void inputArray() {
        System.out.print("Введите количество элементов массива: ");
        int n = scanner.nextInt();
        array = new int[n];

        System.out.println("Введите элементы массива:");
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }

        System.out.println("Изначальный массив: " + Arrays.toString(array));
    }

    private static void showMenu() {
        while (true) {
            System.out.println("\nВыберите действие:");
            System.out.println("1. Сортировка массива (Расческой)");
            System.out.println("2. Поиск элемента по позиции");
            System.out.println("3. Поиск элемента по значению");
            System.out.println("4. Добавить элемент");
            System.out.println("5. Удалить элемент");
            System.out.println("6. Генерация и сортировка массивов (сравнения, перестановки, время)");
            System.out.println("0. Выход");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    sortArray();
                    break;
                case 2:
                    searchByIndex();
                    break;
                case 3:
                    searchByValue();
                    break;
                case 4:
                    addElement();
                    break;
                case 5:
                    removeElement();
                    break;
                case 6:
                    generateAndSortArrays();
                    break;
                case 0:
                    System.out.println("Выход из программы.");
                    return;
                default:
                    System.out.println("Неверный выбор. Попробуйте снова.");
            }
        }
    }

    private static void sortArray() {
        CombSort.combSort(array);
        System.out.println("Отсортированный массив: " + Arrays.toString(array));
    }

    private static void searchByIndex() {
        System.out.print("Введите индекс элемента для поиска: ");
        int index = scanner.nextInt();
        int result = ArrayOperations.findByIndex(array, index);
        if (result != -1) {
            System.out.println("Элемент на позиции " + index + ": " + result);
        }
    }

    private static void searchByValue() {
        System.out.print("Введите значение элемента для поиска: ");
        int value = scanner.nextInt();
        int position = ArrayOperations.findByValue(array, value);
        if (position != -1) {
            System.out.println("Элемент " + value + " находится на позиции: " + position);
        }
    }

    private static void addElement() {
        System.out.print("Введите элемент для добавления: ");
        int element = scanner.nextInt();
        array = ArrayModification.addElement(array, element);
        System.out.println("Массив после добавления: " + Arrays.toString(array));
    }

    private static void removeElement() {
        System.out.print("Введите индекс элемента для удаления: ");
        int index = scanner.nextInt();
        array = ArrayModification.removeElement(array, index);
        System.out.println("Массив после удаления: " + Arrays.toString(array));
    }

    private static void generateAndSortArrays() {
        System.out.print("Введите длину массива: ");
        int length = scanner.nextInt();

        int[] randomArray = generateRandomArray(length);
        System.out.println("\nПолностью неупорядоченный массив:");
        measureSortPerformance(randomArray);

        int[] partiallySortedArray = generatePartiallySortedArray(length);
        System.out.println("\nЧастично упорядоченный массив:");
        measureSortPerformance(partiallySortedArray);

        int[] sortedArray = generateSortedArray(length);
        System.out.println("\nПолностью отсортированный массив:");
        measureSortPerformance(sortedArray);
    }

    private static int[] generateRandomArray(int length) {
        Random random = new Random();
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = random.nextInt(length / 2);
        }
        return array;
    }

    private static int[] generatePartiallySortedArray(int length) {
        int[] array = generateSortedArray(length);
        Random random = new Random();
        int shuffleCount = length / 5;
        for (int i = 0; i < shuffleCount; i++) {
            int index1 = random.nextInt(length / 2);
            int index2 = random.nextInt(length / 2);
            int temp = array[index1];
            array[index1] = array[index2];
            array[index2] = temp;
        }
        return array;
    }

    private static int[] generateSortedArray(int length) {
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = i;
        }
        return array;
    }

    private static void measureSortPerformance(int[] array) {

        long startTime = System.nanoTime();
        CombSort.combSort(array);
        long endTime = System.nanoTime();

        long duration = endTime - startTime;
        System.out.println("Количество сравнений: " + CombSort.comparisons);
        System.out.println("Количество перестановок: " + CombSort.swaps);
        System.out.println("Время выполнения (нс): " + duration);
    }
}