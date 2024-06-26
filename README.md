# Завдання №12 – Знайти рядок матриці розміром N x M з максимальною сумою елементів
## Код класу finderMaxRow:
````java
import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

/**
 * Клас для генерації випадкової матриці та пошуку рядка з максимальною сумою елементів
 */
public class finderMaxRow {

    private finderMaxRow() {
    }

    /**
     * Генерування випадкової матриці 3x3 з випадковими цілими числами в діапазоні [0; 99]
     * @param rows кількість рядків у матриці
     * @param columns кількість стовпців у матриці
     * @return згенерована матриця
     */
    public static int[][] generateRandomMatrix(int rows, int columns) {
        Random random = new Random();
        return random.ints(rows, 0, 100)
                .mapToObj(row -> random.ints(columns, 0, 100).toArray())
                .toArray(int[][]::new);
    }

    /**
     * Знаходження індекса рядка у матриці, сума елементів якого є максимальною
     * @param matrix вхідеа матриця для аналізу
     * @return індекст рядка з максимальною сумою елементів
     */
    public static int findMaxSumRow(int[][] matrix) {
        int[] sums = new int[matrix.length];
        Arrays.setAll(sums, i -> Arrays.stream(matrix[i]).sum());

        int maxSum = Arrays.stream(sums).max().orElse(Integer.MIN_VALUE);
        int maxSumIndex = IntStream.range(0, sums.length)
                .filter(i -> sums[i] == maxSum)
                .findFirst()
                .orElse(-1);

        return maxSumIndex;
    }
}
````

## Код класу Main:
````java
/**
 * Клас для тестування роботи програми
 */
public class Main {
/**
 * Метод для виведення результату
 * @param args аргументи командного рядка
 */
    public static void main(String[] args) {
        int rows = 3;
        int cols = 3;

        //Генерування випадкової матриці
        int[][] matrix = finderMaxRow.generateRandomMatrix(rows, cols);

        System.out.println("Матриця:");
        for (int[] row : matrix) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }

        //Знаходження рядка з максимальною сумою елементів у матриці
        int maxSumRow = finderMaxRow.findMaxSumRow(matrix);

        if (maxSumRow != -1) {
            System.out.println("Рядок з максимальною сумою елементів: " + maxSumRow);
        } else {
            System.out.println("Матриця пуста.");
        }
    }
}
````

## Результат:
![](/misc/screen.png)