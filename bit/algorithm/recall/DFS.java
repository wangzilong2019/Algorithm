package bit.algorithm.recall;

import java.util.List;
import java.util.Scanner;

public class DFS {
    public static void dfs(int[] book, int[] box, int idex, int n) {
        if (idex == n+1) {
            for (int i = 1; i <= n; i++) {
                System.out.print(box[i] + " ");
            }
            System.out.println();
        }

        //排列
        for (int i = 1; i <= n; i++) {
            if (book[i] == 0) {
                box[idex] = i;
                book[i] = 1;
                dfs(book, box, idex+1, n);
                //回溯
                book[i] = 0;
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        //创建俩个数组
        int[] book = new int[n+1];
        int[] box = new int[n+1];

        dfs(book, box, 1, n);
    }
}
