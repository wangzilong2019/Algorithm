package lanqiao.algorithm;


import java.util.Scanner;
import java.util.TreeSet;

public class GatherOperation {
    public static void main(String[] args) {

        //创建集合分别存放元素
        TreeSet<Integer> setA = new TreeSet<Integer>();
        TreeSet<Integer> setB = new TreeSet<Integer>();
        //创建输入流对象
        Scanner in = new Scanner(System.in);
        //输入集合a张元素个数
        int n = in.nextInt();
        //创建数组存放元素
        for (int i = 0; i < n; i++) {
            setA.add(in.nextInt());
        }

        //输入集合b中元素个数
        int m = in.nextInt();
        //输入元素
        for (int i = 0; i < m; i++) {
            setB.add(in.nextInt());
        }
        in.close();

        printDivide(setA, setB);
        printAdd(setA, setB);
        printRemain(setA, setB);
    }

    //俩个集合进行交运算
    public static void printDivide(TreeSet<Integer> a, TreeSet<Integer> b) {
        //创建a集合副本
        TreeSet<Integer> tempA = (TreeSet<Integer>) a.clone();
        //从集合a中移出相交元素
        a.removeAll(b);
        //从a的副本集合中移出a中的元素得到相交元素
        tempA.removeAll(a);

        //打印结果
        for (int i : tempA) {
            System.out.println(i + " ");
        }
        System.out.println();
    }

    //求俩个集合的并集
    public static void printAdd(TreeSet<Integer> a, TreeSet<Integer> b) {
        //利用TreeSet集合元素的唯一性直接俩个集合相加
        a.addAll(b);

        //打印结果
        for (int i : a) {
            System.out.println(i + " ");
        }
        System.out.println();
    }

    //求俩个集合的余集
    public static void printRemain(TreeSet<Integer> a, TreeSet<Integer> b) {
        //从集合a中去除俩个集合的交集
        a.removeAll(b);

        //打印结果
        for (int i : a) {
            System.out.println(i + " ");
        }
        System.out.println();
    }
}
