package leetcode.algorithm.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PalindromePairs {
    public static void main(String[] args) {

    }

    /**
     *   暴力解法：
     *      分别遍历字符串数组，使其俩个字符串组成一个，判断是否为回文串
     * */
    public List<List<Integer>> palindromePairs(String[] words) {

        //构建一个集合用来存放结果
        List<List<Integer>> paris = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (i == j) {
                    continue;
                }

                //首先将俩个字符串连接起来
                String com = words[i] + words[j];
                //将连接后的字符串反转
                StringBuilder sb = new StringBuilder(com);
                String com1 = sb.reverse().toString();

                //判断反转后的字符串与原字符串是否相同
                if (com.equals(com1)) {
                    paris.add(Arrays.asList(i, j));
                }
            }
        }

        return paris;
    }
}
