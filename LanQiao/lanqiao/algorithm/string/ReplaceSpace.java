package lanqiao.algorithm.string;

public class ReplaceSpace {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("we are happy ");
        System.out.println(replaceSpace(sb));
        System.out.println(replaceSpace2(sb));
    }

    /**
     * 替换字符串中的空格
     *   方法一：使用API提供的方法
     * @param sb
     * @return
     */
    public static String replaceSpace(StringBuilder sb) {
        if (sb == null || sb.length() == 0) {
            return sb.toString();
        }

        StringBuilder newSb = new StringBuilder();
        int len = sb.length();
        for (int i = 0; i < len; i++) {
            char ch = sb.charAt(i);
            //判断此字符是否为空格字符
            if (ch == ' ') {
                newSb.append("%20");
            } else {
                newSb.append(ch);
            }
        }
        return newSb.toString();
    }

    /**
     * 方法二：
     *   利用API一步解决
     */
    public static String replaceSpace2(StringBuilder sb) {
        return sb.toString().replaceAll(" ", "%20");
    }
}
