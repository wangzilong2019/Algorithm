package bit.algorithm.greed;

import java.util.Arrays;

public class GetMatTime {
    /**
     *   n 个加工零件的时间为 ti
     *   有m台机器 加工
     *   求最小时间
     */
    public static int getMatTime(int[] taskTime, int m) {
        //求出代加工零件的个数
        int n = taskTime.length;
        //对零件加工时间排序
        Arrays.sort(taskTime);
        int[] machines = new int[m];
        if (n <= m) {
            return taskTime[n-1];
        } else {
            for (int i = n-1; i >= 0; i--) {
                //找一个最先结束的机器，分配新的任务
                int finish = 0;
                int machineTime = machines[finish];
                for (int j = 1; j < m; j++) {
                    if (machines[j] < machineTime) {
                        finish = j;
                        machineTime = machines[j];
                    }
                }

                //分配新的任务给最先结束的
                machines[finish] += taskTime[i];
           }
        }

        //找到最大机器的类及时间
        return findMat(machines);
    }

    public static int findMat(int[] machines) {
        int ret = machines[0];

        for (int i = 1; i < machines.length; i++) {
            ret = Math.max(ret, machines[i]);
        }
        return ret;
    }
}
