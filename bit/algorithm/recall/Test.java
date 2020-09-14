package bit.algorithm.recall;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Test {

    public static boolean bfs(int[][] mat, int startX, int startY, int endX, int endY) {
        //有队列保证搜索到的位置
        Queue<Pair> posQ = new LinkedList<>();
        //当前位置入队列
        posQ.offer(new Pair(startX, startY));

        int row = mat.length;
        int col = mat[0].length;
        int[][] nextP = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        //创建一个标记数组
        int[][] book = new int[row][col];
        book[startX][startY] = 1;

        while (!posQ.isEmpty()) {
            //取出当前队头元素
            Pair curQ = posQ.peek();
            //当前队头元素出队
            posQ.poll();

            //判断是否到达终点位置
            if (startX == endX && startY == endY) {
                return true;
            }

            for (int i = 0; i < 4; i++) {
                int newX = curQ.x + nextP[i][0];
                int newY = curQ.y + nextP[i][1];

                //判断新位置是否越界
                if (newX < 0 || newX >= row
                || newY < 0 || newY >= col) {
                    continue;
                }

                if (mat[newX][newY] == 0 && book[newX][newY] == 0) {
                    //可以则入队
                    posQ.offer(new Pair(newX, newY));
                    //标记已经访问过
                    book[newX][newY] = 1;
                }
            }
        }
        for (int i = 0; i < book.length; i++) {
            for (int j = 0; j < book[0].length; j++) {
                System.out.print(book[i][j] + " ");
            }
            System.out.println();
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] mat = {
                {0, 0, 1, 0},
                {1, 0, 0, 1},
                {0, 0, 0, 0},
                {1, 1, 0, 0}
        };
        System.out.println(bfs(mat, 0, 0, 3, 3));

    }
}


class Pair {
    int x;
    int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
