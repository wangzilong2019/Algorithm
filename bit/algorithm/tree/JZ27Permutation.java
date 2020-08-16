package bit.algorithm.tree;

import java.util.ArrayList;

public class JZ27Permutation {
    /**输入一个字符串,按字典序打印出该字符串中字符的所有排列。
     * 例如输入字符串abc,则按字典序打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
     * 多叉树的搜索剪树枝求排列
     */
    public ArrayList<String> Permutation(String str) {
        //创建一个集合对象
        ArrayList<String> res = new ArrayList<>();
        if (str == null || str.length() == 0) {
            return res;
        }
        StringBuilder sb = new StringBuilder(str);
        Permutation(sb, 0, res);
        return res;
    }

    public void Permutation(StringBuilder str, int start, ArrayList<String> res) {
        //判断是否到达叶子节点
        if (start == str.length() - 1) {
            //去重
            if (!res.contains(new String(str))) {
                res.add(new String(str));
            }
            return;
        }

        //排列
        for (int i = start; i < str.length(); i++) {
            //交换，即字符先后顺序（start始终代表当前字符串的首字符位置）
            swap(str, start, i);
            //递归（类似于划分子问题，从下一个字符开始）
            Permutation(str, start + 1, res);
            //回溯
            swap(str, start, i);
        }
    }

    //交换字符
    public void swap(StringBuilder str, int i, int j) {
        char ch = str.charAt(i);
        str.setCharAt(i, str.charAt(j));
        str.setCharAt(j, ch);
    }
}
