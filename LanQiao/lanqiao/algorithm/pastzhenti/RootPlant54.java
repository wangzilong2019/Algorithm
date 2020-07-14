package lanqiao.algorithm.pastzhenti;

import javax.security.sasl.SaslClient;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class RootPlant54 {
    /**
     *  本体采用并查集的思想，具体实现见下
     */
    static int[] head;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //输入行数和列数和数据行数
        int r = in.nextInt();
        int c = in.nextInt();
        int n = in.nextInt();

        head= new int[r*c];
        for (int i = 0; i < r*c; i++) {
            head[i] = i;
        }
        //输入每行元素
        for (int i = 0; i < n; i++) {
            int a = in.nextInt()-1;
            int b = in.nextInt()-1;
            u(a, b);
        }

        Set<Integer> set = new HashSet<Integer>();
        for (int i  = 0; i < r*c; i++) {
            set.add(f(i));
        }

        System.out.println(set.size());

    }

    //加入点
    private static void u(int a, int b) {
        if (f(a) == f(b)) {
            return;
        }
        //这里最好要设置一个规则，比如将小的集合号赋值给大集合号，或者大的集合号赋值给小的集合号
        head[f(a)] = f(b);
    }

    //找祖宗
    private static int f(int i) {
        //head[i] == i时此节点为祖宗节点
        if (head[i] == i) {
            return i;
        }

        //把当前集合好改为祖宗集合号
        return head[i] = f(head[i]);
    }
}
