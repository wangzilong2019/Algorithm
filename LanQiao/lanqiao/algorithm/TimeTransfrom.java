package lanqiao.algorithm;

import java.text.SimpleDateFormat;
import java.util.Scanner;

public class TimeTransfrom {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        //输入秒数
        int second = in.nextInt();

        //转换为时分秒
        int h = second / 3600;
        int m = second % 3600 / 60;
        int s = second % 3600 % 60;
        System.out.println(h + ":" + m + ":" + s);
    }
}
