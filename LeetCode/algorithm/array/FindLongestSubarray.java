package leetcode.algorithm.array;

import java.util.Arrays;

public class FindLongestSubarray {
    public static String[] findLongestSubarray(String[] array) {
        //创建一个字符串数组
        String[] resString = null;
        //判断数组是否有效
        if (array == null || array.length == 0) {
            return resString;
        }

        //创建数组用来替换内容
        int[] replaceNums = new int[array.length];
        //进行数字和字符替换
        for (int i = 0; i < array.length; i++) {
            for (char ch : array[i].toCharArray()) {
                if (ch >= '0' && ch <= '9') {
                    replaceNums[i] = 1;
                } else {
                    replaceNums[i] = -1;
                }
            }
        }

        System.out.println(Arrays.toString(replaceNums));

        //求替换数组的前序和
        int sum = 0;
        for (int i = 0; i < replaceNums.length; i++) {
            sum += replaceNums[i];
            replaceNums[i] = sum;
        }

        System.out.println(Arrays.toString(replaceNums));

        //搜索相等的且长度最大的前序和索引
        int left = 0;
        int right = replaceNums.length - 1;
        int maxLen = 0;
        int R = 0;
        int L = 0;
        while (left < right) {
            //判断前序和是否相等
            if (replaceNums[left] == replaceNums[right]) {
                //若前序和相等判断是否为最长子数组
                if (right - left > maxLen) {
                    //记录最优解位置
                    R = right;
                    L = left;
                    maxLen = R - L;
                } else if (right - left == maxLen){
                    //若此此长度与最长的相等，返回左端点最小的
                    if (left < L) {
                        L = left;
                        R = right;
                    }
                }
            }
            left++;
            right--;
        }

        return Arrays.copyOfRange(array, L + 1, R + 1);
    }

    public static void main(String[] args) {
        String[] strings = {"A","1","B","C","D","2","3","4","E","5","F","G","6","7","H","I","J","K","L","M"};
        findLongestSubarray(strings);
    }
}
