import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        //______генерируем_рандомный_массив__________________________________
        int size = 10000; // Размерность массива
        int upperBound = 100;// Верхняя граница рандомных чисел, не включая 100
        Integer[] arr = new Integer[size]; // Создаем массив с заданной размерностью
        Random random = new Random(); // Создаем объект для генерирования рандомных чисел
        IntStream.range(0, size) // С помощью стрима проходим по всему массиву
                // Заносим рандомное число в ячейку массива
                // Рандомные значения могут быть в диапазоне от 0 до 99 включительно
                .forEach(index -> arr[index] = random.nextInt(upperBound));
//        System.out.print(Arrays.toString(arr));
// _________________________________________________________


        Integer[] arr1 = Arrays.copyOf(arr, 10000);
        Integer[] arr2 = Arrays.copyOf(arr, 10000);

        long start = System.currentTimeMillis();
        sortBubble(arr);
        long res = System.currentTimeMillis() - start;
        System.out.println("Пузырьковая сортировка - " + res);

        long start1 = System.currentTimeMillis();
        sortSelection(arr1);
        long res1 = System.currentTimeMillis() - start1;
        System.out.println("Сортировка выбором - " + res1);

        long start3 = System.currentTimeMillis();
        sortInsertion(arr2);//"Сортировка вставкой"
        long res2 = System.currentTimeMillis() - start3;
        System.out.println("Сортировка вставкой - " + res2);

        System.out.println("****************************");


        if (res < res1) {
            System.out.println("Winner - '\"'Пузырьковая сортировка\"  " + res);
        } else if (res1 < res2) {
            System.out.println("Winner - '\"Сортировка выбором\"  " + res1);
        }else  System.out.println("Winner - \"Сортировка вставкой\"  " + res2);
        System.out.println("****************************");
    }

    private static void swapElements(Integer[] arr, Integer indexA, Integer indexB) {
        int tmp = arr[indexA];
        arr[indexA] = arr[indexB];
        arr[indexB] = tmp;
    }

    public static void sortBubble(Integer[] arr) {
//        System.out.println("Пузырьковая сортировка");
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swapElements(arr, j, j + 1);
                }
            }
        }
    }

    public static void sortSelection(Integer[] arr) {
//        System.out.println("Сортировка выбором");
        for (int i = 0; i < arr.length - 1; i++) {
            int minElementIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minElementIndex]) {
                    minElementIndex = j;
                }
            }
            swapElements(arr, i, minElementIndex);
        }
    }

    public static void sortInsertion(Integer[] arr) {
//        System.out.println("Сортировка вставкой");
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i;
            while (j > 0 && arr[j - 1] >= temp) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = temp;
        }
    }

    public static boolean lineSearch(int[] arr, int element) {
//        System.out.println("Линейный поиск");
        for (int i : arr) {
            if (i == element) {
                return true;
            }
        }
        return false;
    }

    public static boolean binarySearch(int[] arr, int element) {
        int min = 0;
        int max = arr.length - 1;

        while (min <= max) {
            int mid = (min + max) / 2;

            if (element == arr[mid]) {
                return true;
            }

            if (element < arr[mid]) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return false;
    }
}
