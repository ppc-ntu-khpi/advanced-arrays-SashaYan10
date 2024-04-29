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
