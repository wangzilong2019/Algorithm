package bit.algorithm.arr;
import java.util.ArrayList;
public class JZ51Multiply{
    public int[] multiply(int[] A) {
        //求出数组长度
        int len = A.length;
        int[] b = new int[len];

        for (int i = 0; i < len; i++) {
            int mul = 1;
            for (int j = 0; j < len; j++) {
                if (i == 0) {
                    if (j == 0) {
                        continue;
                    }

                } else if (i == len-1) {
                    if (j == len-1) {
                        continue;
                    }

                } else {
                    if (i == j) {
                        continue;
                    }

                }
                mul *= A[j];
            }
            b[i] = mul;
        }
        return b;
    }

    /**
     * 这里当球B[i] 时，将A[i]看作为1，这样即可连乘法
     * 之后再将A[i] 变为原来的值
     * @param A
     * @return
     */
    public int[] multiply2(int[] A) {
        int len = A.length;
        int[] b = new int[len];

        for (int i = 0; i < len; i++) {
            int temp = A[i];
            A[i] = 1;
            b[i] = 1;
            for (int j = 0; j < len; j++) {
                b[i] *=A[j];
            }
            A[i] = temp;
        }
        return b;
    }

    /**
     * 解法三：
     *   此种方法利用图，找出b[i]与数组A和b之间的关系
     *   由题意知，可将主对角线元素看作为 1
     *   由此 1 可以分为左 和 又 俩
     * @param A
     * @return
     */
    public int[] multiply3(int[] A) {
        int len = A.length;
        int[] b = new int[len];
        b[0] =1;
        //计算left[i]
        for (int i = 1; i < len; i++) {
            b[i] = b[i-1] * A[i-1];  //b[i]相当于left[i]
        }
        //计算right[i]
        int temp = 1;
        for (int i = len - 2; i >= 0; i--) {
            temp *= A[i+1];
            b[i] *= temp;
        }
        return b;
    }
}
