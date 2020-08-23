package bit.algorithm.dp;

import java.util.Set;

public class StringSplit {
    public static void main(String[] args) {

    }

    public boolean wordBreak(String s, Set<String> dict) {
        boolean[] canBreak = new boolean[s.length() + 1];
        //初始化
        canBreak[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            //j < i && f[j] && f[j+1, i]
            for (int j = 0; j < i; j++) {
                if (canBreak[j] && dict.contains(s.substring(j, i))) {
                    canBreak[i] = true;
                    break;
                }
            }
        }
        return canBreak[s.length()];
    }
}
