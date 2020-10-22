package bit.algorithm.other;

import java.util.Scanner;

public class WhatDay {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.next();

        //获取年月日
        String[] arr = str.split("\\-");
        int year = Integer.parseInt(arr[0]);
        int month = Integer.parseInt(arr[1]);
        int day = Integer.parseInt(arr[2]);

        //表示次年的月份天数
        int[] days = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int ret = 0;
        for (int i = 1; i < month; i++) {
            ret += days[i];
        }
        ret += day;

        if (month > 2) {
            if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
                ret++;
            }
        }
        System.out.println(ret);
    }

}
