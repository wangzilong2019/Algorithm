package lanqiao.algorithm.string;

public class StrToInt {
    /**
     * 剑指offer: 将一个字符串转换成一个整数(实现Integer.valueOf(string)的功能，但是string不符合数字要求时返回0)，
     * 要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0。
     */
    /**
     * 将一个字符串转为整数
     *   首先考虑正负问题
     *   之后进行转换
     * @param s
     * @return
     */
    public static int strToInt(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] arr = s.toCharArray();
        int flag = 0;
        int start;  //开始遍历的位置（由是否带符号位决定）
        //判断是否存在符号
        if (arr[0] == '+') {
            flag = 1;
        } else if (arr[0] == '-') {
            flag = 2;
        }
        start = flag > 0 ? 1 : 0;
        int res = 0;
        //从数字为开始遍历字符数组
        for (int i = start; i < arr.length; i++) {
            //判断是否为数字
            if (Character.isDigit(arr[i])) {
                res += res * 10 + arr[i] - '0';
            } else {
                //非数字字符直接返回0
                return 0;
            }
        }

        //结果是需要判断是否要带负数字符
        return flag == 2 ? -res : res;

    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String s = "-12312312";
        System.out.println("使用库函数转换：" + Integer.valueOf(s));
        int res = strToInt(s);
        System.out.println("使用自己写的方法转换：" + res);
    }
}
