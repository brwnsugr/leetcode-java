package written.leetcode.amazon3.Greedy;

import java.util.Arrays;

public class SellDiminishingValue1648 {
  public int maxProfit(int[] inventory, int orders) {
    Arrays.sort(inventory);
    long ans = 0;
    int n = inventory.length-1;
    long count = 1;
    while(orders > 0){
      if(n > 0 && inventory[n] - inventory[n-1] > 0 && orders >= count * (inventory[n] - inventory[n-1])){
        ans += count * sumFromNtoX(inventory[n], inventory[n-1]);
        orders -= count * (inventory[n] - inventory[n-1]);
      }else if(n == 0 || inventory[n] - inventory[n-1] > 0){
        long a = orders / count;
        long temp = sumFromNtoX(inventory[n], inventory[n] - a);
        ans += count * temp;
        long b = orders % count;
        ans += b * (inventory[n]-a);
        orders = 0;
      }
      ans %= 1000000007;
      n --;
      count ++;
    }
    return (int)ans;
  }

  private long sumFromNtoX(long n, long x){
    return (n * (n+1))/2 - (x * (x+1))/2;
  }

  public int maxProfit2(int[] inventory, int orders) {
        /*
        [2,5]

        -> [5,2] o = 4
         -> 2+3+4+5 o = 0
        -> [5,4,3] o = 2
         -> 4+5, o = 0
        -> [2,1] o = 4
        */
    Arrays.sort(inventory);

    //sort by descending order
    for(int i = 0 ; i < inventory.length / 2; i++) {
      int temp = inventory[i];
      inventory[i] = inventory[inventory.length - 1 - i];
      inventory[inventory.length - 1 - i] = temp;
    }
    long answer = 0;

    long count = 1;
    int idx = 0;
    int len = inventory.length;

    while(orders > 0) {
      if(idx <  len - 1 && inventory[idx] > inventory[idx+1] && orders >= count*(inventory[idx] - inventory[idx+1])) {
        answer += count * getRangeSum(inventory[idx], inventory[idx+1]);
        orders -= count * (inventory[idx] - inventory[idx+1]);
      }
      else if(idx == len - 1 || inventory[idx] > inventory[idx+1]){
        long q = orders / count ;
        long temp = getRangeSum(inventory[idx], inventory[idx] - q);
        answer += count * temp;
        long r = orders % count;
        answer += r * (inventory[idx] - q);
        orders = 0;
      }
      answer %= 1000000007;
      if(orders == 0) System.out.println("last answer is " + answer );
      count++;
      idx++;
    }

    return (int)answer;
  }

  private long getRangeSum(long i, long j) {
    return (i * (i+1))/2 - (j * (j+1))/2;
  }

  public static void main(String[] args) {
    SellDiminishingValue1648 solution = new SellDiminishingValue1648();

    int i = solution.maxProfit(new int[]{1000000000}, 1000000000);

    System.out.println("ans is " + i);
  }

}
