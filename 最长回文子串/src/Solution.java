class Solution {
    public String longestPalindrome(String s) {
        int length = s.length();
        int[][] matrix = new int[length][length];
        // 从后往前赋值
        for (int i = length - 1; i >= 0 ; i--) {
            for (int j = i; j < length ; j++) {
                if (j - i <= 2 && s.charAt(i) == s.charAt(j)) {
                    matrix[i][j] = 1;
                } else if (s.charAt(i) == s.charAt(j) && matrix[i+1][j-1] == 1) {
                    matrix[i][j] = 1;
                } else {
                    matrix[i][j] = 0;
                }
            }
        }
        // 找最大的
        int start = 0, end = 0, max = -1;
        for (int i = 0; i < length; i++) {
            for (int j = i; j < length; j++) {
                if (matrix[i][j] == 1 && j - i + 1 > max) {
                    start = i;
                    end = j;
                    max = j - i + 1;
                }
            }
        }
        return s.substring(start, Math.min(end + 1, length));
    }
}