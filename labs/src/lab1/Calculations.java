package lab1;


public class Calculations {


    public void Calc_method(int a, int b, int n, int m, int C){


        if (a > n || b > m) {
            System.out.println("Error: (a>n or b>m)");
        } else if (-C <= n && -C >= a) {
            System.out.println("Error : division by 0");
        } else if (a<0 || b<0) {
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
