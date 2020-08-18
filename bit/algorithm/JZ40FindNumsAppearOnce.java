package bit.algorithm;

public class JZ40FindNumsAppearOnce {
    /**
     * 一个整型数组里除了1个数字之外，其他的数字都出现了两次。请写程序找出这个只出现一次的数字。
     * 首先要清除：
     *     相同数字异或为0
     *     任何数字与1异或为它本身（1^0=1 0^0=0）
     *  方法思路：整体异或
     * @param array
     * @param num1
     * @param num2
     */
    public void FindNumsAppearOnce1(int [] array,int num1[] , int num2[]) {
        int temp = array[0];
        for (int i = 0; i < array.length; i++) {
            temp^=array[i];
        }
        System.out.println(temp);
    }

    /**
     * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
     */
    /**
     * 1、整体异或，最终的结果一定时不同数据的异或，结果一定不为0（因为不全是成对出现的数字）
     * 2、若x!=0一定有比特位为1，不同的俩个数字，该位置的比特位一定时不同的
     * 3、假设是第n个，遍历元素检测每一个数字的第n位，根据是否为1，将其分为AB俩组
     * 4、结论A or B
     * @param array
     * @param num1
     * @param num2
     */
    public void FindNumsAppearOnce2(int [] array,int num1[] , int num2[]) {
        if (array == null || array.length == 0 || num1 == null || num2 == null) {
            return;
        }
        //整体异或
        int target = array[0];
        for (int i = 1; i < array.length; i++) {
            target ^= array[i];
        }
        //根据题意最终结果一定不为0，若为0则不满足条件
        if (target == 0) {
            return;
        }
        //找比特位，从低到高
        int size = Integer.SIZE;
        int flag = 1;
        int i = 0;
        while (size > 0) {
            //找到比特位为1的位置
            if (((flag << i) & target) != 0) {
                flag <<= i;
                break;
            }
            i++;
            size--;
        }
        num1[0] = 0;
        num2[0] = 0;
        //分组
        for (i = 0; i < array.length; i++) {
            //分组且再次异或
            if ((array[i] & flag) == 0) {
                num1[0] ^= array[i];
            } else {
                num2[0] ^= array[i];
            }
        }
    }

}
