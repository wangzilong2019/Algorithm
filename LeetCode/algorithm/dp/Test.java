package lanqiao.algorithm.dp;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        long sum = 0;

        for (int n = a; n <= b; n++) {
            sum += n*n;
        }
        System.out.println(sum);
    }
}
