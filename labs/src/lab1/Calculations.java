package lab1;

import java.util.Scanner;



public class Calculations {
    int C = 2;
    int a;
    int b;
    int n;
    int m;

    public void Calc_method(){

        Scanner scaner = new Scanner(System.in);
        // Отримуємо змінні a, b, n, m від користувача
        System.out.println("Input a");
        a = scaner.nextInt();
        System.out.println("Input n");
        n = scaner.nextInt();
        System.out.println("Input b");
        b = scaner.nextInt();
        System.out.println("Input m");
        m = scaner.nextInt();

        if (a > n || b > m) {
            System.out.println("Error: (a>n or b>m)");
        } else if (-C <= n && -C >= a) {
            System.out.println("Error : division by 0");
        } else if (a<0 || b<0 || n<0 || m<0) {
            System.out.println("Error: parameters cant be negative");
        } else {
            int sum = 0;
            for (int i = a; i <= n; i++) {
                for (int j = b; j <= m; j++) {
                    sum += (i + j) / (i + C);
                }
            }
            System.out.println("S = "+ sum);
        }
    }
}
