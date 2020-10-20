package bit.algorithm.other;

import java.util.Scanner;

public class TailZero {
    public int calNum(int number, int n) {
        int cnt = 0;
        while (number != 0) {
            if (number % n == 0) {
                cnt++;
                number /= n;
            } else {
                break;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int n;
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        int num2 = 0;
        int num5 = 0;
        for (int i = 1; i <= n; i++) {

        }
    }
}
