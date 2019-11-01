import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class Solution {
    /**
     * 动态规划，这道题考虑的细节比较多，核心算法很简单
     *
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        // 如果amount == coins里面的某一个值，直接返回1
        for (int coin : coins) {
            if (amount == coin) return 1;
        }
        // 如果amount比最小的硬币面值还要小，直接返回-1
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            if (coin < min) min = coin;
        }
        if (amount < min) return -1;
        // coins里面比amount大的值，直接删去不处理
        List<Integer> list = new ArrayList<>();
        for (int coin : coins) {
            list.add(coin);
        }
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            Integer next = iterator.next();
            if (next > amount)
                iterator.remove();
        }
        coins = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            coins[i] = list.get(i);
        }
        // 如果amount=int的最大数，单独处理
        boolean maxInt = false;
        if (amount == Integer.MAX_VALUE) {
            maxInt = true;
            amount--;
        }
        // 正儿八经的开始算法
        int[] d = new int[amount + 1];
        for (int coin : coins) {
            d[coin] = 1;
        }
        for (int i = 0; i < min; i++) {
            d[i] = -1;
        }
        // 开始动态规划
        for (int i = 1; i <= amount; i++) {
            boolean wujie = true;
            boolean xiangtong = false;
            int min1 = Integer.MAX_VALUE;
            for (int coin : coins) {
                if (i == coin) {
                    xiangtong = true;
                    break;
                }
                int j = i - coin;
                if (j >= 1 && d[j] != -1) {
                    wujie = false;
                    if (d[j] + 1 < min1) min1 = d[j] + 1;
                }
            }
            if (xiangtong) {
                continue;
            }
            if (wujie) {
                d[i] = -1;
            } else {
                d[i] = min1;
            }
        }
        if (maxInt) {
            int minm = Integer.MAX_VALUE;
            for (int coin : coins) {
                if (Integer.MAX_VALUE == coin) return 1;
                int j = Integer.MAX_VALUE - coin;
                if (d[j] + 1 < minm) minm = d[j] + 1;
            }
            if (minm == Integer.MAX_VALUE) return -1;
            else return minm;
        }
        return d[amount];
    }
}