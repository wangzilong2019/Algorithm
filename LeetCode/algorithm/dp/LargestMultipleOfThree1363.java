package leetcode.algorithm.dp;

public class LargestMultipleOfThree1363 {
    /**
     *   这里要注意;
     *      若一个数为3的倍数，则这个数个各位数字之和必能被3整除
     *      首先ctn数组用来记录每个数字出现的次数
     *      mod数组用来存放每个数字除3余数出现的次数
     *    当数字之和mod3 = 1时
     *       此时可以去掉一个余数为1的数字获取去掉俩个余数为2的数字
     *    当数字之和mod3 = 2时
     *       此时可以去掉一个余数为2的数字或者去掉俩个余数为1的数字
     *     当
     */

    public String largestMultipleOfThree(int[] digits) {
        //用来记录每个数字出现的次数
        int[] cnt = new int[10];
        //用来记录每个数字除3取余出现的次数
        int[] mod = new int[3];
        int sum = 0;
        //遍历数组
        for (int e : digits) {
            ++cnt[e];
            ++mod[e%3];
            sum += e;
        }

        //移出的模3余几的元素
        int removeMod = 0;
        //删除元素的个数
        int rest = 0;
        //当sum mod 3 == 1时
        if (sum % 3 == 1) {
            //当模三余1的个数大于等于一个时
            if (mod[1] >= 1) {
                removeMod = 1;
                rest = 1;
            } else {
                removeMod = 2;
                rest = 2;
            }
        } else if (sum % 3 == 2) {
            //当模3余2的个数大于等于1个时
            if (mod[2] >= 1) {
                removeMod = 2;
                rest = 1;
            } else {
                removeMod = 1;
                rest = 2;
            }
        }

        //这里不用排序，因为是从小到大遍历元素
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= 9; i++) {
            for (int j = 0; j < cnt[i]; j++) {
                if (rest != 0 && i % 3 == removeMod) {
                    --rest;
                } else {
                    sb.append(i);
                }
            }
        }

        //求数字字符串长度
        int len = sb.length();
        //求第一个非0字符位置
        int index = 0;
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) != '0') {
                index = i;
                break;
            }
        }

        if (index >= len) {
            sb.substring(sb.length()-1);
        } else {
            sb.substring(index);
        }

        return sb.toString();
    }

}
