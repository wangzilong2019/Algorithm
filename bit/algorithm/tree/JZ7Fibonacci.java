package bit.algorithm.tree;

import java.util.HashMap;
import java.util.Map;

public class JZ7Fibonacci {
    /**
     *  方法一：采用普通递归法
     * @param n
     * @return
     */
    public int fibonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    /**
     * 方法二：采用递归剪枝法
     * @param n
     * @return
     */
    private Map<Integer, Integer> filter = new HashMap<>();
    public int fibonacci2(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        int pre = 0;
        //判断前一项的值是否计算过
        if (filter.containsKey(n - 1)) {  //计算过取出直接用
            pre = filter.get(n - 1);
        } else {  //没有计算过则计算，且记录结果
            pre = fibonacci2(n - 1);
            filter.put(n - 1, pre);
        }

        //判断前前一项是否计算过
        int ppre = 0;
        if (filter.containsKey(n - 2)) {
            ppre = filter.get(n - 2);
        } else {
            ppre = fibonacci2(n - 2);
            filter.put(n - 2, ppre);
        }
        return pre + ppre;
    }

    public int fibonacci3(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        int s1 = 0;
        int s2 = 1;
        return s1+s2;
    }

    public static void main(String[] args) {
        System.out.println(new JZ7Fibonacci().fibonacci2(4));
    }
}
