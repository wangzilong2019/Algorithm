package bit.algorithm.string;

public class JZ53IsNumeric {
    /**
     * 解法一：
     *    -123.45e-67
     *   1、+-号后面必定为数字或.
     *   2、+-号只能出现在第一位或eE的后一位
     *   3、.号后必定为数字或是最后一位
     *   4、eE后必定为数字或是+-号
     * @param str
     * @return
     */
    public boolean isNumeric(char[] str) {
        //表示小数点
        boolean point = false;
        //表示指数
        boolean exp = false;
        for (int i = 0; i < str.length; i++) {
            if (str[i] == '+' || str[i] == '-') {
                //+-号后必定为数字或.
                if (i + 1 == str.length || !(str[i+1] > '0' && str[i+1] <= '9' || str[i+1] == '.')) {
                    return false;
                }
                //+=号只出现在第一位或是eE的后一位
                if (!(i == 0 || str[i-1] == 'e' || str[i-1] == 'E')) {
                    return false;
                }
            } else if (str[i] == '.') {
                //.号后必定为数字或是最后一位
                if (point || exp || !(i + 1 < str.length && str[i+1] >= '0' && str[i+1] <= '9')) {
                    return false;
                }
                point = true;
            } else if (str[i] == 'e' || str[i] == 'E') {
                //eE后必定为数字或是+-号
                if (exp || i + 1 == str.length || !(str[i+1] >= '0' && str[i+1] <= '9' || str[i+1] == '+' || str[i+1] == '-')) {
                    return false;
                }
                exp = true;
            } else if (str[i] >= '0' && str[i] <= '9') {

            } else {
                return false;
            }
        }
        return true;
    }
}
