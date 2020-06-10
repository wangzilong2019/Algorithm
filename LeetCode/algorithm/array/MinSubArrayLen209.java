package leetcode.algorithm.array;

public class MinSubArrayLen209 {

    /**
     *   双指针（滑动窗口）
     *     left与right围成窗口元素之和，left指向窗口第一个元素，right指向窗口最后一个元素的下一个
     *     当串口内元素大于s时，记录此时最小长度，窗口缩小（左向右移）直到小于s，然后右边窗口再扩大
     *     直到rgth到达边界
     *
     * */
    public int minSubArrayLen(int s, int[] nums) {
        //首先判断传入数组是否有效
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int len = nums.length;
        int left = 0;  //左指针
        int right = 0;  //右指针
        int sum = 0; //滑动窗口求和
        int min = Integer.MAX_VALUE;

        while (right < len) {
            sum += nums[right];
            right++;  //sum记录滑动窗口的和，但是right指向滑动窗口最后一个元素的下一个元素，left指向第一个，这里没什么特别，只需要注意
            //当窗口求和大于s时，窗口左边界右移动
            while (sum >= s) {
                //记录最小长度
                min = Math.min(min, right - left);
                sum -= nums[left];
                left++;
                //left始终指向滑动窗口第一个元素
            }
        }

        //判断min的值得出结果
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
