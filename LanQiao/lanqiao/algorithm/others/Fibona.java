package lanqiao.algorithm.others;

public class Fibona {
    public static void main(String[] args) {
        //求斐波那契数列的每一项
        int s1 = 1;
        int s2 = 2;
        System.out.println(s1);
        System.out.println(s2);
        //从第三项开始
        for (int i = 3; i <= 20; i++) {
            s2 = s1 + s2;
            s1 = s2 - s1;
            System.out.println(s2);
        }
    }
}
