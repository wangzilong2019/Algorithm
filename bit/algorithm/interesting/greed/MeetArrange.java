package bit.algorithm.interesting.greed;

import java.util.Arrays;
import java.util.Comparator;

public class MeetArrange {
    /**
     * 贪心算法：
     *    会议问题：
     *      思路：为了可以安排最多的会议，选择不相容的会议且结束时间最早的
     *      排序的目的是为了选择结束时间最早的
     *      遍历会议判断是为了选择不相容的会议
     * @param args
     */
    public static void main(String[] args) {
        //创建几个会议
        Meet[] meets = new Meet[6];
        meets[0] = new Meet(1, 1, 3);
        meets[1] = new Meet(2, 2, 4);
        meets[2] = new Meet(3, 5, 7);
        meets[3] = new Meet(4, 6, 9);
        meets[4] = new Meet(5, 9, 11);
        meets[5] = new Meet(6, 12, 13);

        //对会议结束时间排序
        Arrays.sort(meets, new Comparator<Meet>() {
            @Override
            public int compare (Meet m1, Meet m2) {
                if (m1.end == m2.end) {
                    return m2.begin - m1.begin;
                }
                return m1.end - m2.end;
            }
        });

        //首先选择第一个会议
        int ans = 1;
        int last = meets[0].end;
        System.out.println("选择第" + meets[0].id + "个会议");
        //遍历
        for (int i = 0; i < meets.length; i++) {
            //当会议不相容时
            if (meets[i].begin >= last) {
                ans++;
                last = meets[i].end;
                System.out.println("选择第" + meets[i].id + "个会议");
            }
        }
    }
}

class Meet {
    int id;
    int begin;
    int end;

    public Meet(int id, int begin, int end) {
        this.id = id;
        this.begin = begin;
        this.end = end;
    }

    @Override
    public String toString() {
        return "Meet{" +
                "id=" + id +
                "begin=" + begin +
                ", end=" + end +
                '}';
    }
}
