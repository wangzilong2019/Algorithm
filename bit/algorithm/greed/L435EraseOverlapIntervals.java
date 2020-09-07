package bit.algorithm.greed;

import java.util.Arrays;
import java.util.Comparator;

public class L435EraseOverlapIntervals {
    /**
     * 给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。
     *
     * 注意:
     *
     * 可以认为区间的终点总是大于它的起点。
     * 区间 [1,2] 和 [2,3] 的边界相互“接触”，但没有相互重叠。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/non-overlapping-intervals
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    /**
     * 首先对又闭区间升序排序
     * 首先找出可以满足条件的区间互不重叠的数量
     * 然后再用总区间减去所求的
     * @param intervals
     * @return
     */
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        //按照结束顺序来递增排序
        Arrays.sort(intervals, new MyCop2());
        //初始化、第一个区间一定满足
        int num = 1;
        int i = 0;
        for (int j = 1; j < intervals.length; j++) {
            //判断当前区间的开始是否满足大于上一个区间的结束
            if (intervals[j][0] >= intervals[i][1]) {
                num++;
                i = j;
            }
        }
        return intervals.length - num;
    }

    /** 分析区间的三种情况
     *   1  2  3   4
     *   1  2
     *     3    4
     *   1     2
     *     3  4
     * @param intervals
     * @return
     */
    public int eraseOverlapIntervals2(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        //按照结束顺序来递增排序
        Arrays.sort(intervals, new MyCop2());
        //初始化、第一个区间一定满足
        int num = 0;
        int i = 0;
        for (int j = 1; j < intervals.length; j++) {
            //判断当前区间的开始是否满足大于上一个区间的结束
            if (intervals[j][0] >= intervals[i][1]) {
                //说明活动不冲突
                i = j;
            } else  {
                if (intervals[j][1] < intervals[i][1]) {
                    i = j;
                }
                num++;
            }

        }
        return num;
    }



}

// 按照区间结束大小升序排序
class MyCop implements Comparator<int[]> {
    @Override
    public int compare(int[] ints, int[] t1) {
        return ints[1] - t1[1];
    }
}

// 按照区间起始位置递增排序
class MyCop2 implements Comparator<int[]> {
    @Override
    public int compare(int[] ints, int[] t1) {
        return ints[0] - t1[0];
    }
}