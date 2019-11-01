class Solution {
    /**
     * 动态规划
     *
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int cur = nums[0];
        int max = nums[0];
        int maxl = 1; // 最大子序列的长度
        int maxI = 0;
        for (int i = 1; i < nums.length; i++) {
            if (cur >= 0) {
                if (cur + nums[i] > cur) maxl++;
                cur += nums[i];
            } else {
                cur = nums[i];
                maxl = 1;
            }
            if (cur > max) {
                max = cur;
                maxI = i;
            }
        }
        int left = maxI - maxl;
        for (int i = left + 1; i <= maxI; i++) {
            System.out.print(nums[i] + ", ");
        }
        System.out.println();
        return max;
    }
}