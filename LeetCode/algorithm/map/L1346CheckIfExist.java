package leetcode.algorithm.map;

import java.util.HashMap;
import java.util.IllegalFormatCodePointException;
import java.util.Map;

public class L1346CheckIfExist {
    /**
     *
     */
    /**
     *
     * @param arr
     * @return
     */
    public boolean checkIfExist(int[] arr) {
        if (arr == null || arr.length < 2) {
            return false;
        }
        //创建一个集合
        Map<Integer, Integer> map = new HashMap<>();
        //将元素放入map集合中，键存放元素值，值存放元素下标
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], i);
        }

        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i] * 2) && map.get(arr[i] * 2) != i) {
                return true;
            }
        }
        return false;

    }
}
