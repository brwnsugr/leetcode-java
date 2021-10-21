package written.kbay;

public class Sol3 {

  public int maxMargin(int[] prices, int start, int end, int count, boolean visited[]) {
    if(end <= start) return 0;
    if(count == 0) return 0;

    int profit = 0;

    for(int i = start; i < end; i++) {
      for(int j = i + 1; j <= end; j++) {
        if(prices[j] > prices[i] && !visited[i] && !visited[j]) {
          visited[i] = true;
          visited[j] = true;
          int currProfit = prices[j] - prices[i] + maxMargin(prices, start, end, count-1, visited);
          visited[i] = false;
          visited[j] = false;
          profit = Math.max(profit, currProfit);
        }
      }
    }
    return profit;
  }

  public int solution(int[] prices) {
    int answer = -1;
    boolean[] visited = new boolean[prices.length];
    int i = maxMargin(prices, 0, prices.length - 1, 2, visited);
    System.out.println(i);
    return answer;
  }

  public static void main(String[] args) {
    Sol3 sol3 = new Sol3();
    int[] ddd = {1, 2, 4, 1, 2, 3};
    sol3.solution(ddd);
  }

}
