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
