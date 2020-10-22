package bit.algorithm.arr;

public class JZ6MinNumberInRotateArray {
    /**
     *   分三种情况：
     *      1、情况一：arr[mid] > target：4 5 6 1 2 3
     *         arr[mid] = 6 target为右端端点为3，此时arr[mid] > target
     *         所求的结果范围比在mid-right;
     *      2、情况二：arr[mid] < target:5 6 1 2 3 4
     *         arr[mid] 为 1， target为右端点 4， arr[mid] < target
     *         此时答案不可能在mid+1 - right中，所以有可能在left - mid中
     *      3、情况三：arr[mid] == target:
     *         如果是 1 0 1 1 1， arr[mid] = target = 1, 显然答案在左边
     *         如果是 1 1 1 0 1, arr[mid] = target = 1, 显然答案在右边
     *         所以这种情况，不能确定答案在左边还是右边，那么就让last = last - 1;慢慢缩少区间，同时也不会错过答案。
     * @param array
     * @return
     */
    public int minNumberInRotateArray(int [] array) {
        if (array == null || array.length == 0) {
            return 0;
        }

        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            //判断是否进行了旋转
            if (array[left] < array[right]) {
                return array[left];
            }
            int mid = (left + right) >> 1;
            //情况一
            if (array[mid] > array[right]) {
                left = mid + 1;
            } else if (array[mid] < array[right]) {
                right = mid;
            } else {
                right--;
            }
        }
        return array[left];
    }
}
