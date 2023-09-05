import java.util.Random;
import java.util.stream.IntStream;

public class TestCode {
    public static void main(String[] args) {
        int size = 20; // Размерность массива
        int upperBound = 20;// Верхняя граница рандомных чисел, не включая int upperBound
//        Integer[] arr = new Integer[size]; // Создаем массив с заданной размерностью
        IntegerListImp integers = new IntegerListImp(20);
        IntegerListImp integers2 = new IntegerListImp(20);

        Random random = new Random(); // Создаем объект для генерирования рандомных чисел
        IntStream.range(0, size) // С помощью стрима проходим по всему массиву
                // Заносим рандомное число в ячейку массива
                // Рандомные значения могут быть в диапазоне от 0 до 99 включительно
                .forEach(index -> integers.add(index, random.nextInt(upperBound)));

        System.out.println();

        for (int i = 0; i < integers.size(); i++) {
            System.out.print(i + "=" + integers.get(i) + " ");
        }
        integers.set(0, 12);
        System.out.println();
        System.out.println(integers.contains(12));

        System.out.println();
        for (int i = 0; i < integers.size(); i++) {
            System.out.print(i + "=" + integers.get(i) + " ");
        }
        for (int i = 0; i < integers.size(); i++) {
            integers2.add(i, integers.get(i));
        }
        System.out.println();
        System.out.println("integers.equals(integers2) = " + integers.equals(integers2));
        integers.remove(0);

        System.out.println("integers.equals(integers2) = " + integers.equals(integers2));
        for (int i = 0; i < integers.size(); i++) {
            System.out.print(i + "=" + integers2.get(i) + " ");
        }
    }

}
