package leetcode.algorithm.array;

public class MissingNumber53 {

    /**
     *   思路：
     *      由分析可知，缺失的元素为由部第一个元素
     *      因此查找时可使用二分查找，当数组元素等于下标时left = mid + 1
     *      当数组元素不等于下标时right = mid - 1
     *      当right > left 时结束循环
     *
     * */

    public static void main(String[] args) {

    }

    public int missingNumber(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        //二分查找
        while (left <= right) {
            int mid = (left + right) / 2;
            //判断中间元素下标是否等于元素值
            if (nums[mid] == mid) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
