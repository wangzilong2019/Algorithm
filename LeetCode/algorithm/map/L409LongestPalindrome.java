package leetcode.algorithm.map;

public class L409LongestPalindrome {

    //每次最长字符串开始索引
    int index = 0;
    //每次最长回文串长度
    int len = 0;
    /**
     * 给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
     *
     * 在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。
     *
     * 注意:
     * 假设字符串的长度不会超过 1010。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/longest-palindrome
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    /**
     * 思路：
     *    找到最长回文串，然后再求出长度
     *    回文串的长度有奇数和偶数
     * @param s
     * @return
     */
    public int longestPalindrome(String s) {
        for (int i = 0; i < s.length() - 1; i++) {
            longestPalindromeHelper(s, i, i + 1);
            longestPalindromeHelper(s, i, i);
        }
        return len;
    }

    public void longestPalindromeHelper(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        if (len < right - left -1) {
            index = left + 1;
            left = right - left - 1;
        }
    }
}
