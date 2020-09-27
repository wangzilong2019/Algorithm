package lanqiao.algorithm.string;

import java.util.Scanner;

public class BracketDepthMatch {
    /**
     * 爱奇艺 2018 秋招 Java： 一个合法的括号匹配序列有以下定义:
     *
     * 空串””是一个合法的括号匹配序列
     * 如果”X”和”Y”都是合法的括号匹配序列,”XY”也是一个合法的括号匹配序列
     * 如果”X”是一个合法的括号匹配序列,那么”(X)”也是一个合法的括号匹配序列
     * 每个合法的括号序列都可以由以上规则生成。
     * 例如: “”,”()”,”()()”,”((()))”都是合法的括号序列 对于一个合法的括号序列我们又有以下定义它的深度:
     *
     * 空串””的深度是0
     * 如果字符串”X”的深度是x,字符串”Y”的深度是y,那么字符串”XY”的深度为max(x,y)
     * 如果”X”的深度是x,那么字符串”(X)”的深度是x+1
     * 例如: “()()()”的深度是1,”((()))”的深度是3。牛牛现在给你一个合法的括号序列,需要你计算出其深度。
     */

    /**
     * 从第一个字符开始遍历字符串，当字符为 '(' 时则count++，否则count--，（因为只有（））
     * 每次遍历一个字符更新最大结果
     * @param args
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        int count = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                count++;
            } else {
                count--;
            }
            //更新结果
            max = Math.max(max, count);
        }
        System.out.println(max);
    }
}
