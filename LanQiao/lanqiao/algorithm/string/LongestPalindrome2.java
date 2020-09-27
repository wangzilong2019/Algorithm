package lanqiao.algorithm.string;

public class LongestPalindrome2 {
    // index记录每次更新到的最长回文字串的开始索引
    //len 记录每次更新到的最长回文字符串的长度
    private int index, len;
    /**
     * Leetcode: LeetCode: 最长回文子串 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为1000。
     *
     */
    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        LongestPalindrome2 obj = new LongestPalindrome2();
        System.out.println(obj.longestPalindrome("babad"));
    }


    /**
     * 以某个元素为中心，分别计算偶数长度的回文最大长度和奇数长度的回文最大长度。给大家大致花了个草图，不要嫌弃！
     *   从俩种情况考虑：一个是奇数长度的回文字符串、另一个是偶数长度的回文字符串
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        if (s.length() < 2) {
            return s;
        }

        //从字符串的每个开始开始（按照以上分析的俩种情况分析找出最长公共回文字串）
        //最后一个字符除外因为要考虑俩种情况
        for (int i = 0; i < s.length() - 1; i++) {
            //第一种情况假设最长回文串长度为奇数，即从中心开始
            palindromeHelper(s, i, i);
            //第二种情况假设最长回文串的长度为偶数，即从中心俩侧开始
            palindromeHelper(s, i, i + 1);
        }
        return s.substring(index, index + len);
    }
    public void palindromeHelper(String s, int l, int r) {
        //寻找最大的回文字串
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        //判断是否要更新最长回文字串长度
        if (len < r - l - 1) {
            //更新开始索引和长度
            len = r - l -1;
            index = l + 1;
        }
    }
}