package lanqiao.algorithm.string;

public class KMP {
    public static void main(String[] args) {

    }

    /**
     * KMP算法找出俩个字符串最长相同字串
     *    首先找到长度较小的字符串
     *    然后依次减小长度判断是否被较长字符串包含
     *  注意事项：
     *    因为要寻找最长相同字符串，所以长度要从大到小
     * @param str1
     * @param str2
     * @return
     */
    public static String getMaxString(String str1, String str2) {
        //获取俩个字符串中最大字符串和最小字符串
        String maxStr = (str1.length() >= str2.length()) ? str1 : str2;
        String minStr = (str1.length() < str2.length()) ? str1 : str2;

        //获取较小字符串长度
        int len = minStr.length();

        for (int i = 0; i < len; i++) {
            for (int start = 0, end = len - i; end <= len; start++, end++) {
                //获取每次比较的字符串
                String sub = minStr.substring(start, end);
                //判断此字符串是否被大字符串包含
                if (maxStr.contains(sub)) {
                    return sub;
                }
            }
        }
        return null;
    }

    /**
     * 拓展：找到所有的最长字串数组
     * @param str1
     * @param str2
     * @return
     */
    public static String[] getMaxString2(String str1, String str2) {
        //获取俩个字符串中最大字符串和最小字符串
        String maxStr = (str1.length() >= str2.length()) ? str1 : str2;
        String minStr = (str1.length() < str2.length()) ? str1 : str2;

        //获取较小字符串长度
        int len = minStr.length();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            for (int start = 0, end = len - i; end <= len; start++, end++) {
                //获取每次比较的字符串
                String sub = minStr.substring(start, end);
                //判断此字符串是否被大字符串包含
                if (maxStr.contains(sub)) {
                    sb.append(sub + ",");
                }
            }

            //此时判断sb是否为空，若不为空则表明已找到所有满足答案条件直接返回，因为下一个循环长度会减1
            if (sb.length() != 0) {
                break;
            }
        }

        //获取字符串数组
        String[] arr = sb.toString().split("\\,");
        return arr;
    }
}
