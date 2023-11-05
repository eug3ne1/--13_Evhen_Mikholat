package lab1;
import java.util.Scanner;

// Заліковка  №1318
//C2 = 1318 % 2; // O1 - "+"
//C3 = 1318 % 3; // C = 1
//C5 = 1318 % 5; // O2 - "+"
//C7 = 1318 % 7; // type - int

public class Main {
    public static void main(String[] args) {
        int c = 2;
        int a;
        int b;
        int n;
        int m;

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

        Calculations calc = new Calculations();
        calc.Calc_method(a,b,n,m,c);
    }
}
