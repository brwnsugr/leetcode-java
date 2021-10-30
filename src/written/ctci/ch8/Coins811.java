package written.ctci.ch8;

public class Coins811 {


  private static final int[] changes = new int[]{25,10,5,1};
  private int[][] cache;

  public int makeChanges(int remainder, int index) {
    if(index >= changes.length-1) return 1;
    if(cache[remainder][index] > 0) return cache[remainder][index];
    int currentCoinUnit = changes[index];
    int ways = 0;
    for(int i = 0; currentCoinUnit*i <= remainder; i++) {
      ways += makeChanges(remainder - currentCoinUnit*i, index+1);
    }
    cache[remainder][index] = ways;
    return ways;
  }

  public int solution(int n) {
    cache = new int[n+1][4];
    int answer = makeChanges(n, 0);
    return answer;
  }

  public static void main(String[] args) {
    Coins811 coins811 = new Coins811();
    int solution = coins811.solution(10);
    System.out.println("sol is" + solution);
  }


}
