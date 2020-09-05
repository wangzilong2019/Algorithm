package bit.algorithm.greed;

public class L1221balancedStringSplit {
    /**
     * 在一个「平衡字符串」中，'L' 和 'R' 字符的数量是相同的。
     *
     * 给出一个平衡字符串 s，请你将它分割成尽可能多的平衡字符串。
     *
     * 返回可以通过分割得到的平衡字符串的最大数量。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/split-a-string-in-balanced-strings
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * 输入：s = "RLRRLLRLRL"
     * 输出：4
     * 解释：s 可以分割为 "RL", "RRLL", "RL", "RL", 每个子字符串中都包含相同数量的 'L' 和 'R'。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/split-a-string-in-balanced-strings
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    /**
     * 因为要保证是对称的 ，可以用消去法来处理
     *  这里注意不能让平衡字符串嵌套
     * @param s
     * @return
     */
    public int balancedStringSplit(String s) {
        //统计平衡串的总数
        int cnt = 0;
        int balance = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'R') {
                balance--;
            } else if (s.charAt(i) == 'L') {
                balance++;
            }
            if (balance == 0) {
                cnt++;
            }
        }
        return cnt;
    }
}
