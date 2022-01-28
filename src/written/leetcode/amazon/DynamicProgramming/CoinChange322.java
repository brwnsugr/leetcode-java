package written.leetcode.amazon.DynamicProgramming;

import java.util.Arrays;

public class CoinChange322 {

  public int coinChange(int[] coins, int amount) {
    int[] dp = new int[amount+1];
    Arrays.fill(dp, Integer.MAX_VALUE - 1);

    dp[0] = 0;

    for(int i = 1; i <= amount; i++) {
      for(int j = 0; j < coins.length; j++) {
        if(coins[j] <= i) {
          dp[i] = Math.min(dp[i], dp[i-coins[j]] + 1);
        }
      }
    }
    return dp[amount] > amount ? -1 : dp[amount];
  }


  public static void main(String[] args) {
    CoinChange322 coinChange322 = new CoinChange322();

    int i = coinChange322.coinChange(new int[]{2}, 5);

    System.out.println(" ddd is " + i);
  }
}
