package written.leetcode.amazon.DynamicProgramming;

public class BestTimeToBuyAndSellStock121 {

  public int maxProfit(int[] prices) {
    int ans = 0;
    int minPrice = Integer.MAX_VALUE;
    for(int i = 0; i < prices.length; i++) {
      minPrice = Math.min(prices[i], minPrice);
      if(minPrice < prices[i]) ans = Math.max(prices[i] - minPrice, ans);
    }
    return ans;
  }

  public static void main(String[] args) {
    BestTimeToBuyAndSellStock121 bestTimeToBuyAndSellStock121 = new BestTimeToBuyAndSellStock121();
    int i = bestTimeToBuyAndSellStock121.maxProfit(new int[]{7,1,5,3,6,4,9});

    System.out.println(" ddd is " + i);
  }
}
