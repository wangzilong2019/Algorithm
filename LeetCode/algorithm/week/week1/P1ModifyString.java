package leetcode.algorithm.week.week1;

public class P1ModifyString {
    public String modifyString(String s) {
        if (s.length() == 0 || s == null) {
            return null;
        }
        //创建一个StringBuilder类
        StringBuilder sb = new StringBuilder(s);
        //遍历字符串
        for (int i = 0; i < sb.length(); i++) {
            //当第一个字符时只需要与后一个字符相比较
            if (i == 0) {
                //判断是否是'?'字符
                if (sb.charAt(i) == '?') {
                    sb.replace(i, i + 1, getOneChar(0, (int)sb.charAt(i+1)));
                }
            } else if (i == sb.length()-1) {
                //当为最后一个字符时，只需要和前一个字符作比较
                if (sb.charAt(i) == '?') {
                    sb.replace(i, i + 1, getOneChar((int)sb.charAt(i-1), 0));
                }
            } else {
                if (sb.charAt(i) == '?') {
                    sb.replace(i, i + 1, getOneChar((int)sb.charAt(i-1), (int)sb.charAt(i+1)));
                }
            }
        }
        return sb.toString();
    }

    //定义一个函数返会一个和前后的字符不相同的字符
    public String getOneChar(int left, int right) {
        int mid = (int)'a';
        while (true) {
            if (mid != left && mid != right) {
                return "" + (char)mid;
            } else {
                mid++;
            }
        }
    }

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("abbab");
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == 'b') {
                sb.replace(i, i+1, "c");
            }
        }
        System.out.println(sb.toString());
    }
}
