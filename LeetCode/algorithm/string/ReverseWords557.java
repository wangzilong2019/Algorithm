package leetcode.algorithm.string;

import java.util.Scanner;

public class ReverseWords557 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        System.out.println(new ReverseWords557().reverseWords(str));
    }

    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        String[] words = s.split(" ");
        for (String str : words) {
            sb.append(new StringBuilder(str).reverse() + " ");
        }
        return sb.toString().trim();
    }
}
