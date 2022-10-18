package com.carl.string;

public class LeetCode541 {
    public String reverseStr(String s, int k) {
        //记录字符串长度
        int sLen = s.length();
        char[] arr = s.toCharArray();
        //分三种情况
        if (sLen <= 2 * k) {
            if (k <= sLen) {
                swap_s(arr, k, 0);
            } else {
                swap_s(arr, sLen, 0);
            }
        } else if (sLen - 2 * k < k) {
            swap_s(arr, k, sLen - 2 * k);
        } else {
            swap_s(arr, k, k);
        }
        return s;
    }

    public void swap_s(char[] arr, int k1, int k2) {
        for (int i = 0; i < k1 / 2; i++) {
            char temp = arr[i];
            arr[i] = arr[k1 - 1 - i];
            arr[k1 - 1 - i] = temp;
        }

        for (int i = 2 * k1; i < 2 * k1 + k2 / 2; i++) {
            char temp = arr[i];
            arr[i] = arr[2 * k1 + k2 - 1 - i];
            arr[2 * k1 + k2 - 1 - i] = temp;
        }
    }
}
