import java.util.Arrays;

class Solution {
    public int uniquePaths(int m, int n) {
        if (m == 1 || n == 1) return 1;
        else {
            int big = Math.max(m, n);
            int small = Math.min(m, n);
            // 哪个小，就按哪个开数组，极致压缩空间
            int[] r = new int[small];
            Arrays.fill(r, 1);
            for (int i = 1; i < big; i++) {
                for (int j = 1; j < small; j++) {
                    r[j] += r[j - 1];
                }
            }
            return r[small - 1];
        }
    }
}