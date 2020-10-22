package bit.algorithm.arr;

public class JZ37GetNumberOfK {
    public int GetNumberOfK(int [] array , int k) {
        int ans = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[k] == k) {
                ans++;
            }
        }
        return ans;
    }
}
