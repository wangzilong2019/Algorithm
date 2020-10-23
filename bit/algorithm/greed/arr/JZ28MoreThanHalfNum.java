package bit.algorithm.arr;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class JZ28MoreThanHalfNum {
    /**

     方法一：建立一个map键对应数字，值对应元素对应数字的出现的次数
     */
    public int MoreThanHalfNum_Solution(int [] array) {
        if (array == null || array.length == 0) {
            return 0;
        }

        Arrays.sort(array);
        int max = array[array.length - 1];

        int half = array.length / 2;
        //创建一个Map集合
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            if (map.get(array[i]) == null) {
                map.put(array[i], 1);
            } else {
                map.put(array[i], map.get(array[i]) + 1);
            }
            int x = map.get(array[i]);
            if (x > half) {
                return array[i];
            }
        }
        return 0;
    }

    /**

     方法二：
        首先排序：当出现元素出现的次数大于长度一半时，一定会出现在中间位置
         记录此元素出现的次数
     */
    public int MoreThanHalfNum_Solution2(int [] array) {
        if (array == null || array.length == 0) {
            return 0;
        }

        Arrays.sort(array);
        int mid = array[array.length / 2];
        int half = array.length / 2;
        int count = 0;
        //统计出现次数
        for (int i = 0; i < array.length; i++) {
            if (mid == array[i]) {
                count++;
            }
            if (count > half) {
                return mid;
            }
        }
        return 0;
    }

    /**

     方法三：
         阵地问题：首先寻找数组中出现次数最大的元素（阵地法），在判断此元素值出现的次数
     */
    public int MoreThanHalfNum_Solution3(int [] array) {
        if (array == null || array.length == 0) {
            return 0;
        }

        int num = array[0];
        //记录num出现的次数
        int times = 1;
        //士兵阵地，找到出现次数最大元素
        for (int i = 1; i < array.length; i++) {
            if (times == 0) {
                num = array[i];
                times = 1;
            } else if (array[i] == num) {
                times++;
            } else if (array[i] != num){
                times--;
            }
        }

        //判断找到的的次数最大的数字是否大于数组长度一般
        times = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == num) {
                times++;
            }
        }

        return times > array.length / 2 ? num : 0;
    }

    public static void main(String[] args) {
        StringBuilder s = new StringBuilder("dd");
        System.out.println(s);
    }
}
