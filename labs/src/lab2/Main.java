// Заліковка  №1318
//C5 = 1318 % 5; // C = A xor B
//C7 = 1318 % 7; // type - short
//C11 = 1318 % 11; //Знайти середнє значення елементів кожного стовпчика матриця

package lab2;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть кількість рядків: ");
        int rows = scanner.nextInt();
        System.out.print("Введіть кількість стовпців: ");
        int cols = scanner.nextInt();
        if (cols<=0 || rows<=0){
            System.out.println("введіть праметри рядок та стовпець більше нуля");
        }else {
            // Створюємо дві матриці
            short[][] matrix1 = new short[rows][cols];
            short[][] matrix2 = new short[rows][cols];

            // Введення даних для першої матриці
            System.out.println("Введіть дані для першої матриці:");
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    System.out.print("Елемент [" + i + "][" + j + "]: ");
                    matrix1[i][j] = scanner.nextShort();
                }
            }

            // Введення даних для другої матриці
            System.out.println("Введіть дані для другої матриці:");
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    System.out.print("Елемент [" + i + "][" + j + "]: ");
                    matrix2[i][j] = scanner.nextShort();
                }
            }

            MatrixCalc matrix = new MatrixCalc();
            matrix.MatrOP(rows,cols,matrix1,matrix2);

        }
    }
}