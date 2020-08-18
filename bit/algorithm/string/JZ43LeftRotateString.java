package bit.algorithm.string;

public class JZ43LeftRotateString {
    /**
     *  方法一：通过连接俩个字符串然后截取
     * @param str
     * @param n
     * @return
     */
    public String LeftRotateString(String str,int n) {
        if (str == null || str.length() == 0 || n <= 0) {
            return str;
        }
        //记录源字符串长度
        int len = str.length();
        n = n % str.length();
        StringBuilder sb = new StringBuilder(str + str);
        //截取字符串
        String res = sb.substring(n, n + len).toString();
        return res;
    }

    /**
     *  方法二：将原字符串按照旋转长度截取俩部分，然后分别逆置，然后合并，然后再逆置为结果
     * @param str
     * @param n
     * @return
     */
    public String LeftRotateString2(String str,int n) {
        return null;
    }

}
