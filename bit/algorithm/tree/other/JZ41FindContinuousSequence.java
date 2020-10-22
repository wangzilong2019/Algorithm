package bit.algorithm.other;

import java.util.ArrayList;

public class JZ41FindContinuousSequence {
    /**
     * 小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。
     * 但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。
     * 没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。
     * 现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列? Good Luck!
     */
    /**
     * 使用滑动窗口方法
     * @param sum
     * @return
     */
    public ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        //定义俩个指针，滑动窗口
        int low = 1;
        int high = 2;

        while (low < high) {
            //求和
            int total = (low + high) * (high - low + 1) / 2;
            //找到一组值满足条件
            if (total == sum) {
                ArrayList<Integer> temp = new ArrayList<>();
                for (int i = low; i <= high; i++) {
                    temp.add(i);
                }
                //将结果放入集合中
                lists.add(temp);
                //找下一组
                low++;
            } else if (total < sum) {
                high++;
            } else {
                low++;
            }
        }
        return lists;
    }
}
