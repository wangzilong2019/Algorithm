package lanqiao.algorithm.string;

public class StringOperation {
    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        String str = "ffgghdds";
        //System.out.println(trim(str));
        System.out.println(reverse(str, 2, 4));
        System.out.println(reverse2(str, 2, 4));

    }

    /**
     * 模拟方法去去除字符串前后空格
     * @param str
     * @return
     */
    public static String trim(String str) {
        if (str != null) {
            //记录开始非空字符
            int start = 0;
            //记录结束非空字符
            int end = str.length() - 1;
            //确定开始的位置
            while (start < end && str.charAt(start) == ' ') {
                start++;
            }
            //确定结束的位置
            while (start < end && str.charAt(end) == ' ') {
                end--;
            }
            //此时通过start是否与end相等来判断是否为全空格字符串
            if (str.charAt(start) == ' ') {
                return null;
            }
            return str.substring(start, end + 1);
        }
        return null;
    }

    /**
     * 字符串反转一
     *   反转特定范围的字符串
     *   首先将字符串变为字符串数组，然后进行部分反转
     * @param str
     * @return
     */
    public static String reverse(String str, int start, int end) {
        if (str != null) {
            //首先将字符串变为字符数组
            char[] arr = str.toCharArray();
            //部分反转
            while (start < end) {
                char temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
                start++;
                end--;
            }
            //构造一个新字符串返回
            return new String(arr);
        }
        return null;
    }

    /**
     * 字符串反转方法二
     *    通过StringBuilder方法部分截取然后组合
     * @param str
     * @param start
     * @param end
     * @return
     */
    public static String reverse2(String str, int start, int end) {
        if (str != null) {
            //获取第一段
            StringBuilder sb = new StringBuilder(str.substring(0, start));
            //获取第二段
            for (int i = end; i >= start; i--) {
                sb.append(str.charAt(i));
            }
            //获取第三段
            sb.append(str.substring(end+1));
            return new String(sb);
        }
        return null;
    }

    /**
     * 获取子字符串在主串种出现的次数
     * @param mainStr
     * @param subStr
     * @return
     */
    public static int getCount(String mainStr, String subStr) {
        if (mainStr.length() < subStr.length()) {
            return -1;
        }
        int len1 = mainStr.length();
        int len2 = subStr.length();
        int count = 0;
        for (int i = 0; i < len1 - len2; i++) {
            int index = i;
            int j = 0;
            boolean flag = true;
            while (index < i + len2) {
                if (mainStr.charAt(index++) != subStr.charAt(j++)) {
                    flag = false;
                }
            }
            if (flag) {
                count++;
            }
        }
        return count;
    }

    public static int getCount2(String mainStr, String subStr) {
        if (mainStr.length() < subStr.length()) {
            return -1;
        }
        int startLoc = 0;
        int len = subStr.length();
        int count = 0;
        while ((startLoc = mainStr.indexOf(subStr, startLoc)) != -1) {
            count++;
            startLoc = startLoc + len;
        }
        return count;
    }
}
