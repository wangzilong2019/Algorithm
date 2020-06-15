package leetcode.algorithm.array;

/**
 *   分治法求最长共前缀
 *
 * */
public class LongestCommonPrefix2 {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        } else {
            return longestCommonPrefix(strs, 0, strs.length - 1);
        }
    }

    public String longestCommonPrefix(String[] strs, int start, int end) {
        if (start == end) {
            return strs[start];
        } else {
            int mid = (end - start) / 2 + start;
            String lcpLeft = longestCommonPrefix(strs, start, mid);
            String lcpRight = longestCommonPrefix(strs, mid + 1, end);
            return commonPrefix(lcpLeft, lcpRight);
        }
    }

    public String commonPrefix(String lcpLeft, String lcpRight) {
        int minLength = Math.min(lcpLeft.length(), lcpRight.length());
        for (int i = 0; i < minLength; i++) {
            if (lcpLeft.charAt(i) != lcpRight.charAt(i)) {
                return lcpLeft.substring(0, i);
            }
        }
        return lcpLeft.substring(0, minLength);
    }

    /**
     *   解法四二分查找：
     *       最长共公共前缀长度不会大于最短字符串长度
     *       每次取中间mid判断每个字符串长度为mid的前缀是否相同
     *         相同：则公共前缀一定大于等于mid
     *         不相同：一定小于mid，通过二分法将范围缩小一半在搜索判断
     *
     * */
    public String longestCommonPrefix4 (String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        //求出最短字符串长度
        int minLength = Integer.MAX_VALUE;
        for (String str : strs) {
            minLength = Math.min(minLength, str.length());
        }
        int low = 0, high = minLength;
        while (low < high) {
            int mid = (high - low + 1) / 2 + low;  //这里注意，因为mid代表字符串长度，所以不能用传统写法求出mid长度
            //长度为mid为前缀
            if (isCommonPrefix(strs, mid)) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }
        return strs[0].substring(0, low);

    }

    //判断长度为len的前缀字符串是否为公共前缀
    public boolean isCommonPrefix(String[] strs, int length) {
        String str0 = strs[0].substring(0, length);
        int count = strs.length;
        for (int i = 1; i < count; i++) {
            String str = strs[i];
            for (int j = 0; j < length; j++) {
                if (str0.charAt(j) != str.charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};
        System.out.println(new LongestCommonPrefix2().longestCommonPrefix4(strs));
    }
}
