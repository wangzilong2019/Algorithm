package bit.algorithm.recall;

public class L733FloodFill {
    /**
     * 有一幅以二维整数数组表示的图画，每一个整数表示该图画的像素值大小，数值在 0 到 65535 之间。
     *
     * 给你一个坐标 (sr, sc) 表示图像渲染开始的像素值（行 ，列）和一个新的颜色值 newColor，让你重新上色这幅图像。
     *
     * 为了完成上色工作，从初始坐标开始，记录初始坐标的上下左右四个方向上像素值与初始坐标相同的相连像素点，接着再记录这四个方向上符合条件的像素点与他们对应四个方向上像素值与初始坐标相同的相连像素点，……，重复该过程。将所有有记录的像素点的颜色值改为新的颜色值。
     *
     * 最后返回经过上色渲染后的图像。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/flood-fill
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    //定义上下左右方向
    int[][] nextP = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    /**
     *
     * @param image
     * @param sr
     * @param sc
     * @param newColor
     * @return
     */
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image == null) {
            return image;
        }

        int row = image.length;
        int col = image[0].length;
        int[][] book = new int[row][col];
        int oldColor = image[sr][sc];
        DFS(image, row, col, book, sr, sc, oldColor, newColor);
        return image;
    }

    public void DFS(int[][] image, int row, int col, int[][] book, int curX, int curY, int oldColor, int newColor) {
        //当前位置修改颜色
        image[curX][curY] = newColor;
        //标记此位置颜色已经被修改
        book[curX][curY] = 1;

        //上下左右修改颜色
        for (int i = 0; i < 4; i++) {
            int newX = curX + nextP[i][0];
            int newY = curY + nextP[i][1];

            //判断新位置是否越界
            if (newX >= row || newY >= col
            || newX < 0 || newY < 0) {
                continue;
            }

            //判断新位置是否可以渲染
            if (image[newX][newY] == oldColor && book[newX][newY] == 0) {
                DFS(image, row, col, book, newX, newY, oldColor, newColor);
            }
        }
    }


}
