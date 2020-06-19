package leetcode.algorithm.string;

public class RomanToInt {
    /**

     由题意分析可知
     遍历字符串：当当前字符比下一个字符小时则当前字符左减法
     当当前字符比下一个大时则当前字符左加法
     最后一个字符永远做加法

     */
    public int romanToInt(String s) {
        //首先判断字符串是否有效
        if (s == null || s.length() == 0) {
            return 0;
        }

        //用的求和
        int sum = 0;
        //从索引1开始遍历字符串，所以0为前一个字符，依次
        int preNum = getValue(s.charAt(0));

        //遍历字符串
        for (int i = 1; i < s.length(); i++) {
            //获取当前罗马字符表示的数字
            int num = getValue(s.charAt(i));

            //判断当前字符和前一个的大小
            if (preNum < num) {
                sum -= preNum;
            } else {
                sum += preNum;
            }

            preNum = num;
        }

        sum += preNum;
        return sum;
    }

    public int getValue(char ch) {
        //用分支语句获得每个罗马字符的返回值
        switch (ch) {
            case 'I' : return 1;
            case 'V' : return 5;
            case 'X' : return 10;
            case 'L' : return 50;
            case 'C' : return 100;
            case 'D' : return 500;
            case 'M' : return 1000;
            default : return 0;
        }
    }
}
