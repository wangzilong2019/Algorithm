package lanqiao.algorithm.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

/**
 *
 *    暴力解法：
 *       hashMap统计出所有长度为n的连续字符串的出现次数
 *       找出出现次数最多的
 *       若某次字符串的出现次数与最优值相同，则选择字符串较长的那个
 *
 * */
public class StringCount {
    public static void main(String[] args) {
        //创建输入流对象
        Scanner in = new Scanner(System.in);
        //输入整数
        int n = in.nextInt();
        //输入字符串
        String str = in.next();

        //创建hashMap来存储长度为n的字符串出现的次数
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        //记录最大出现次数
        int maxValue = 0;
        String maxString = "";
        //遍历字符串，每次截取长度为n的字符串
        for (int i = 0; i < str.length() - n + 1; i++) {
            for (int j = i + n; j < str.length(); j++) {
                //截取长度为n的字符串
                String split = str.substring(i, j);
                //判断字符串是否出现过
                if (map.containsKey(split)) {
                    //获取次出现的次数
                    int value = map.get(split);
                    value++;
                    //判断是否大于最优解
                    if (value > maxValue) {
                        maxValue = value;
                        maxString = split;
                    } else if (value == maxValue) {
                        //当字串次数出现相同时记录最长字符串
                        if (split.length() > maxString.length()) {
                            maxString = split;
                        }
                    }
                    map.put(split, value);
                } else {
                    map.put(split, 1);
                }
            }
        }
        System.out.println(maxString);
    }
}
