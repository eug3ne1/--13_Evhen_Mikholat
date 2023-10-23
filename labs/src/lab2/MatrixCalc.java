package lab2;

public class MatrixCalc {


    //Створюємо метод з необхідними параметрами для виконання операцій над матрицями
    public void MatrOP(int rows,int colmns, short[][]matrix1, short[][]matrix2){
        short[][] resultMatrix = new short[rows][colmns]; // Матриця 3
        double[] columnAverages = new double[colmns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < colmns; j++) {
                matrix1[i][j] = (short)i; // Приклад значень для першої матриці
                matrix2[i][j] = (short)j;  // Приклад значень для другої матриці
            }
        }
        // Операція над Матрицею1 та Матрицею2
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < colmns; j++) {
                resultMatrix[i][j] = (short)(matrix1[i][j] ^ matrix2[i][j]); // опреація виключного АБО
            }
        }

        for (int j = 0; j < colmns; j++) {
            int sum = 0;
            for (int i = 0; i < rows; i++) {
                sum += resultMatrix[i][j];
            }
            columnAverages[j] = (double) sum /rows;
        }

        //Виведення Результатів
        System.out.println("Результат операції XOR:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < colmns; j++) {
                System.out.print(resultMatrix[i][j] + "\t");
            }
            System.out.println();
        }

        //Виведення результатів
        System.out.println("Середнє значення елементів кожного стовпчика:");
        for (int j = 0; j < colmns; j++) {
            System.out.println("Стовпчик " + (j + 1) + ": " + columnAverages[j]);
        }

    }

}
