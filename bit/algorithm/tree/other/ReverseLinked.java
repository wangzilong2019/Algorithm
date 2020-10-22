package bit.algorithm.other;

import java.time.temporal.JulianFields;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class ReverseLinked {
    public static void main(String[] args) {
        List<String> list = new LinkedList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");

        //反转k个链表
        int k = 2;
        int start = 0;
        while (start + k - 1 < list.size()) {
            reverse(list, start, start + k - 1);
            start += k;
        }

        for (String str : list) {
            System.out.println(str + "->");
        }
    }

    public static void reverse(List<String> list, int start, int end) {
        while (start < end) {
            String temp = list.get(start);
            list.set(start, list.get(end));
            list.set(end, temp);
            start++;
            end--;
        }
    }
}
