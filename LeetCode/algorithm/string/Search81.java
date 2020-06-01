package leetcode.algorithm.string;

public class Search81 {

    /**
     *   本题思路;二分查找
     *      首先判断num[mid] == target是否成立
     *      1、当num[low] == nums[mid}时
     *      2、当nums[low} < num[mid] 时  ，左部分升序，再判断是否在做部分，否则在又部分
     *      3、当nums[low} > nums[mid] 时 , 又部分升序，再判断是否在又部分，否则做左部分
      *
     * */

    public static void main(String[] args) {
        int[] nums = {2,5,6,0,0,1,2};
        System.out.println(new Search81().search(nums, 0));
    }

    public boolean search(int[] nums, int target) {

        //判断数组是否存在是否为空
        if (nums == null || nums.length == 0) {
            return false;
        }
        int low = 0;
        int high = nums.length - 1;
        int mid;

        while (low <= high) {
            mid = low + (high - low) / 2;
            //当找到时
            if (target == nums[mid]) {
                return true;
            }
            //当中间元素和左指针元素相等时
            if (nums[low] == nums[mid]) {
                low++;
                continue;
            }

            //当中间指针元素比左指针元素大时，即左半部分升序
            if (nums[low] < nums[mid]) {
                //当目标元素在左部分时
                if (nums[low] < target && target < nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                //当中间元素比左指针元素小时，即又半部分升序
                if (nums[mid] < target && target < nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return false;
    }
}
