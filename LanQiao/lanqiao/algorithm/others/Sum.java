package lanqiao.algorithm.others;

import java.util.Scanner;

public class Sum {
    public static void main(String[] args) {
        //求和
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        int sum = 0;
        for (int i = 1; i <= num; i++) {
            sum += i;
        }
        System.out.println(sum);
    }
}
