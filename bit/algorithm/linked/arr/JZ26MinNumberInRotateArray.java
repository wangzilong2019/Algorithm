package bit.algorithm.arr;

public class JZ26MinNumberInRotateArray {

    /**
     *   注意事项：
     *     1、旋转并不改变顺序，每部分仍然是非递减
     */

    /**
     * 查找旋转数组最小值
     * 方法一：线性查找比较相邻的俩个数字的大小
     * @param array
     * @return
     */
    public int minNumberInRotateArray(int [] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int res = 0;
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] <= array[i+1]) {
                continue;
            } else {
                return array[i+1];
            }
        }
        return array[0];
    }

    /**
     *   方法二：二分查找
     * @param array
     * @return
     */
    public int minNumberInRotateArray2(int [] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int left = 0;
        int right = array.length - 1;
        int mid = 0;
        while (left < right) {
            //当相邻时，因为左半部分始终大于又半部分，
            if (right - left == 1) {
                mid = right;
                break;
            }
            mid = (left + right) >> 1;
            //当左中右三者值相等时,采用线性方式查找
            if (array[left] == array[right] && array[mid] == array[left]) {
                int res = array[left];
                for (int i = left + 1; i < right; i++) {
                    if (res > array[i]) {
                        res = array[i];
                    }
                }
                return res;
            }
            //正常情况下判断在左半部分还是在右半部分
            if (array[left] < array[mid]) {
                //说明左半部分连续，最小值在右半部分
                left = mid;
            } else {
                right = mid;
            }
        }
        return array[mid];
    }
}
