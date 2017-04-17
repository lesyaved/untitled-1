package problem;

import java.util.Scanner;

/**
 * Created by vedoa.18 on 17.04.2017.
 */
public class problem_slove {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int max = 0;
        Point max1 = new Point();
        Point max2 = new Point();
        Point max3 = new Point();
        int n = sc.nextInt();
        Point arr[] = new Point[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new Point(sc.nextDouble(), sc.nextDouble());
        }
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j  < n; j++) {
                for (int k = i+2; k  < n; k++) {
                    int Contest = 0;
                    Triangle t = new Triangle(arr[i], arr[j], arr[k]);
                    if (t.checkTriangle() == true) {
                        for (int m = 0; m < n; m++) {
                            if (t.checkPoint(arr[m]) == true)
                                Contest++;}
                        if (Contest > max) {
                            max = Contest;
                            max1 = new Point(t.a.x, t.a.y);
                            max2 = new Point(t.b.x, t.b.y);
                            max3 = new Point(t.c.x, t.c.y);
                        }
                    }

                }
            }

        }
        System.out.println(max1);
        System.out.println(max2);
        System.out.println(max3);
        System.out.println(max);

    }
}
