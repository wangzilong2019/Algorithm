package leetcode.algorithm.string;

import java.awt.desktop.SystemEventListener;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class ArrangeWords {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String s = input.nextLine();
        System.out.println((new ArrangeWords()).arrangeWords(s));
    }

    public String arrangeWords(String text) {
        //将字符串以空格作为分割符分割为字符串数组
        String[] strings = text.split(" ");

        //首先将首个单词首字母变为小写
        strings[0] = strings[0].toLowerCase();

        //对分割后的字符串数组按照字符串长度排序(升序)
        Arrays.sort(strings, new Com());

        //用字符串构造器构造输出
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strings.length; i++) {
            //最后一个字符串后不用加空格
            if (i == strings.length - 1) {
                sb.append(strings[i]);
            } else {
                //非最后一个字符串加空格
                sb.append(strings[i] + " ");
            }
        }

        //将排序后的首个字符串的首字母变成大写
        if (sb.charAt(0) >= 97 ) {
            sb.setCharAt(0, (char)(sb.charAt(0) - 32));
        }
        //将其转换为字符串输出
        return sb.toString();
    }
}

class Com implements Comparator<String> {
    @Override
    public int compare(String s, String t1) {
        return s.length() - t1.length();
    }
}
