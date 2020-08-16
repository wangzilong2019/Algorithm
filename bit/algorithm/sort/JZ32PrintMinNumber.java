package bit.algorithm.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.IllegalFormatCodePointException;

public class JZ32PrintMinNumber {
    /**
     * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，
     * 打印能拼接出的所有数字中最小的一个。
     * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
     */
    /**
     *  本体的核心点是字符串集合的排序
     * @param numbers
     * @return
     */
    public String PrintMinNumber(int [] numbers) {
        if (numbers == null || numbers.length == 0) {
            return "";
        }
        //创建一个集合
        ArrayList<String> list = new ArrayList<>();
        //将数组中元素放入集合中
        for (int num : numbers) {
            list.add(String.valueOf(num));
        }
        //创建一个StringBuilder类
        StringBuilder sb = new StringBuilder();
        //对集合中元素排序
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String s, String t1) {
                String A = s + t1;
                String B = t1 + s;
                //比较俩个字符串的大小即为比较ASCII值
                return A.compareTo(B);
            }
        });
        //拼接字符串
        for (String str : list) {
            sb.append(str);
        }
        return sb.toString();
    }
}
