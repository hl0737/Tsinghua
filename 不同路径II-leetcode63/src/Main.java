public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.uniquePathsWithObstacles(new int[][]{{0, 0}, {1, 0}, {0, 1}, {0, 0}});
        System.out.println(i);
    }
}
