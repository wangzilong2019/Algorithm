package bit.algorithm.other;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;

public class JZ49StrToInt {
    public static int StrToInt(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }

        char[] arr = str.toCharArray();
        //判断输入的是正数还是负数
        int flag = 0;

        if (arr[0] == '+' || Character.isDigit(arr[0])) {
            flag = 1;
        } else if (arr[0] == '-') {
            flag = -1;
        }
        if (flag == 0) {
            return 0;
        }
        int p = 10;
        int ans = 0;
        int idx = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            if (i == 0) {
                if (arr[0] == '+' || arr[0] == '-') {
                    continue;
                }
            }
            //判断是否合法
            if (!Character.isDigit(arr[i])) {
                return 0;
            } else {
                ans = ans * 10 + arr[i] - '0';
            }

        }
        return flag == -1 ? -ans : ans;

    }

    public static void main(String[] args) {
        System.out.println(StrToInt("123"));

    }
}
