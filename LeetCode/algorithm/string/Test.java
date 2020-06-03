package leetcode.algorithm.string;

import java.awt.desktop.ScreenSleepEvent;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();

        //求出前缀表达式符号
        char sign = s.charAt(0);
        //数字字符
        //判断数字有几位
        int num1, num2;
        if (Character.isDigit(s.charAt(3))) {
            num1 = Integer.parseInt(s.substring(2, 4));
        }
        num1 = s.charAt(2) - '0';
        if (Character.isDigit(s.charAt(5))) {
            num2 = Integer.parseInt(s.substring(4, 6));
        }
        num2 = s.charAt(4) - '0';
        int res;
        switch (sign) {
            case '+' :
                res = num1 + num2;
                System.out.println(res);
                break;
            case '-' :
                res = num1 - num2;
                System.out.println(res);
                break;
            case '*' :
                res = num1 * num2;
                System.out.println(res);
                break;
            case '/' :
                res = num1 / num2;
                System.out.println(res);
                break;
            default:
                break;
        }
    }
}
