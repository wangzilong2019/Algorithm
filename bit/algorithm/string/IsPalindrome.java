package bit.algorithm.string;

import java.util.Scanner;

public class IsPalindrome {
    /**
     *  判断字符串是否是回文字符串
     */
    public static boolean isPalindrome(StringBuilder str, int[] start, int[] end) {
        boolean res = true;
        int i = 0;
        int j = str.length() - 1;
        while (i < j) {
            //判断对称字符是否相等
            if (str.charAt(i) == str.charAt(j)) {
                i++;
                j--;
            } else {
                res = false;
                break;
            }
        }
        if (start != null) {
            start[0] = i;
        }
        if (end != null) {
            end[0] = j;
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //输入字符串的个数
        int num = in.nextInt();
        while (num > 0) {
            StringBuilder sb = new StringBuilder(in.next());
            //创建数组记录下标
            int[] start = new int[1];
            int[] end = new int[1];
            //判断输入的此字符串是否是回文串
            if (isPalindrome(sb, start, end)) {
                System.out.println(-1);
            } else {
                //此字符串不是回文串
                //任意首先删除一个字符
                sb.deleteCharAt(end[0]);
                //判断删除此字符之后是否是回文串
                if (isPalindrome(sb, null, null)) {
                    System.out.println(end[0]);
                } else {
                    System.out.println(start[0]);
                }
            }
            num--;
        }
    }
}
