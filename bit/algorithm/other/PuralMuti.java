package bit.algorithm.other;

import java.util.Scanner;

public class PuralMuti {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //输入第一个复数
        String str1 = in.next();
        String str2 = in.next();

        //分解为整数部分和复数部分
        String[] arr1 = str1.split("\\+");
        String s1Int = arr1[0];
        String s1F = arr1[1];
        String[] arr2 = str2.split("\\+");
        String s2Int = arr2[0];
        String s2F = arr2[1];

        int s1I = strToInt(s1Int);
        int s1FF = strToInt(s1F);

        int s2I = strToInt(s2Int);
        int s2FF = strToInt(s2F);

        int IRet = s1I * s2I - s1FF * s2FF;
        int FRet = s1I * s2FF + s1FF * s2I;
        System.out.println(IRet + "+" + FRet + "i");
    }

    public static int strToInt(String str) {
        int num = 0;
        int flag = 1;
        char[] arr = str.toCharArray();
        for (char ch : arr) {
            if (ch == '-') {
                flag = -1;
            } else if (ch >= '0' && ch <= '9') {
                num = num * 10 + ch - '0';
            }
        }
        return num * flag;
    }
}
