package bit.algorithm.interesting.greed;

import java.util.Scanner;

public class Dijkstra {
    static final int INF = 88888;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("请输入城市的个数：");
        int n = in.nextInt();

        //创建一个矩阵存储带权图
        int[][] map = new int[n + 1][n + 1];
        int[] dist = new int[n + 1];
        int[] pre = new int[n + 1];
        boolean[] flag = new boolean[n + 1];

        //对矩阵初始化
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                map[i][j] = INF;
            }
        }
        System.out.println("输入城市之前的路线以及距离：");
        int m = in.nextInt();
        while (m-- != 0) {
            int u = in.nextInt();
            int v = in.nextInt();
            int w = in.nextInt();
            map[u][v] = w;
        }
        System.out.println("输入小明所在的位置：");
        int st = in.nextInt();
        dijkstra(st, map, dist, pre, flag, n);
        for (int i = 1; i <= n; i++) {
            System.out.print("小明：" + st + " - 要去的位置：");
            if (dist[i] == INF) {
                System.out.println("sorry,无路可达");
            } else {
                System.out.println("最短距离为：" + dist[i]);
            }
        }

    }

    public static void dijkstra(int u,int[][] map, int[] dist, int[] pre, boolean[] flag, int n) {
        //初始化
        for (int i = 1; i <= n; i++) {
            flag[i] = false;  //所有点都在V集合中
            dist[i] = map[u][i];
            if (dist[i] == INF) {
                pre[i] = -1;
            } else {
                pre[i] = u;
            }
        }

        //讲u点加入集合S
        flag[u] = true;
        dist[u] = 0;
        //初始时S集合中只有一个元素即为源点u
        for (int i = 1; i <= n; i++) {
            int temp = INF;
            int t = u;
            //在V-S集合中找到一个距离源点u最近的顶点t
            for (int j = 1; j <= n; j++) {
                if (!flag[j] && dist[j] < temp) {
                    t = j;
                    temp = dist[j];
                }
            }


            //判断是否找到
            if (t == u) {
                return;
            }
            //找到将此点加入S集合中
            flag[t] = true;
            //更新V-S集合中与他相连的顶点到源点u的距离
            for (int j = 1; j <= n; j++) {
                if (!flag[j] && map[t][j] < temp) {
                    if (dist[j] > dist[t] + map[t][j]) {
                        dist[j] = dist[t] + map[t][j];
                        pre[j] = t;
                    }
                }
            }
        }
    }
}
