package bit.algorithm.arr;

public class JZ1FindValue {
    /**
     * 由题意可知，左下角元素是一个分界点，因为从上到下递增，从左到右递增
     * 每次通过判断此元素和目标元素可以消去一行
     * @param target
     * @param array
     * @return
     */
    public boolean Find(int target, int [][] array) {
        if (array.length == 0 || array[0].length == 0) {
            return false;
        }
        int row = array.length;
        int col = array[0].length;

        for (int i = row - 1, j = 0; i >= 0 && j >= 0; ) {
            if (array[i][j] == target) {
                return true;
            } else if (target < array[i][j]) {
                i--;
                continue;
            } else {
                j++;
                continue;
            }
        }
        return false;
    }
}
