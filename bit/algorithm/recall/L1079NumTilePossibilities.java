package bit.algorithm.recall;

import java.util.HashSet;
import java.util.Set;

public class L1079NumTilePossibilities {
    /**
     * 你有一套活字字模 tiles，其中每个字模上都刻有一个字母 tiles[i]。返回你可以印出的非空字母序列的数目。
     *
     * 注意：本题中，每个活字字模只能使用一次。
     */
    /**
     *
     * @param tiles
     * @return
     */
    public int numTilePossibilities(String tiles) {
        if (tiles == null || tiles.length() == 0) {
            return 0;
        }
        Set<String> hashSet = new HashSet<>();
        int[] book = new int[tiles.length()];
        dfs(tiles, "", hashSet, book);
        return hashSet.size();
    }

    public void dfs(String titles, String curStr, Set<String> allRet, int[] book) {
        if (!curStr.isEmpty()) {
            allRet.add(curStr);
        }

        for (int i = 0; i < titles.length(); i++) {
            if (book[i] == 0) {
                book[i] = 1;
                dfs(titles, curStr + titles.charAt(i), allRet, book);
                //回溯
                book[i] = 0;
            }
        }
    }
}
