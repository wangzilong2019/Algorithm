package bit.algorithm.test.recall;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class FullPermutation {
    static List<String> res = new LinkedList<String>();
    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String str = "1234";
        dfs(str.toCharArray(), str.length(), 0);
        Collections.sort(res);
        for (String s : res) {
            System.out.println(s);
        }
    }

    public static void dfs(char[] arr, int len, int idx) {
        if (idx >= len) {
            res.add(new String(arr));
            return;
        }
        for (int i = idx; i < len; i++) {
            swap(arr, i, idx);
            dfs(arr, len, idx + 1);
            swap(arr, i, idx);
        }
    }

    private static void swap(char[] arr, int i, int idx) {
        // TODO Auto-generated method stub
        if (i == idx) {
            return;
        }
        char temp = arr[i];
        arr[i] = arr[idx];
        arr[idx] = temp;
    }
}
