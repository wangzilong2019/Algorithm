package lanqiao.algorithm;

import java.util.Scanner;

public class StringOperation {
    public static void main(String[] args) {
        //创建Scanner对象
        Scanner in = new Scanner(System.in);
        //输入操作
        int num = in.nextInt();
        //输入字符串
        String str = in.next();

        StringBuilder sb;
        //根据不同操作分别处理
        switch (num) {
            case 1 :
                //将字符串转换为大写
                System.out.print(str.toUpperCase());
                break;
            case 2 :
                //将字符串转换为小写
                System.out.print(str.toLowerCase());
                break;
            case 3 :
                sb = new StringBuilder(str);
                //将字符串反转
                System.out.print(sb.reverse().toString());
                break;
            case 4 :
                sb = new StringBuilder(str);
                //将字符串中字符大小写互相转换
                for (int i = 0; i < sb.length(); i++) {
                    char temp = sb.charAt(i);
                    //若为大写转小写
                    if (temp >= 'A' && temp <= 'Z') {
                        sb.setCharAt(i, (char)(temp + 32));
                    } else {
                        //小写转大写
                        sb.setCharAt(i, (char)(temp - 32));
                    }
                }
                //输出
                System.out.print(sb.toString());
                break;
            case 5 :
                //由分析可知，至少出现三个连续升序字符才有可能出现 -
                //先将三个以上连续的字符除开头和结尾外用 - 替换
                //先将字符串转换为小写
                str = str.toLowerCase();
                char[] a = str.toCharArray();
                char[] b = new char[a.length];
                b[0] = a[0];
                for (int i = 1; i < a.length; i++) {
                    //判断是否连续三个以上字符升序
                    if ( i < a.length - 1 && a[i] == a[i-1] + 1 && a[i] + 1 == a[i+1]) {
                        b[i] = '-';
                    } else {
                        b[i] = a[i];
                    }
                }

                //去除多余的 -
                sb = new StringBuilder();
                for (char ch : b) {
                    //因为 - 不能是连续的，判断 - 是否加入要判断当前字符是否是 - 且已经生成的字符串最后一个字符是否是 -
                    if (ch == '-' && sb.charAt(sb.length() - 1) != '-') {
                        sb.append(ch);
                    } else if (ch != '-') {
                        sb.append(ch);
                    }
                }
                System.out.print(sb.toString());
                break;
            default:
                break;
        }

    }
}
