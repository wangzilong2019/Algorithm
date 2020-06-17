package lanqiao.algorithm.loop;

import javax.swing.*;
import java.util.Map;

public class PerfectNumber {
    public static void main(String[] args) {
        //遍历1000以内的数字，求完数
        for (int i = 2; i <= 1000; i++) {
            if (i == factor(i)) {
                System.out.println(i);
            }
        }
    }

    /**
     *  求出一个数字的所有因子之和（不包括自身，但包括1） 入6：1+2+3
     *
     * */
    public static int factor(int num) {
        int sum = 0;
        for (int i = 1; i <= (int) Math.sqrt(num); i++) {
            if (i > num / i) {
                break;
            }
            if (i == 1) {
                sum += 1;
            } else if (num % i == 0 && i != num / i) {
                sum += (num / i + i);
            } else if (i == num / i && num % i == 0) {
                sum += i;
            }
        }
        return sum;
    }
}
