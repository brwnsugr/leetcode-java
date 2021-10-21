package written.leetcode.graph;

public class NumberOfProvince {

  private boolean[] visited;
  private int count;
  private int len;
  public void recursive(int currVertex, int[][] connectionMap) {
    visited[currVertex] = true;
    //connecting dot 이 있으면 다음 dot 에서 recursion call
    for(int i = 0; i < len; i++) {
      if(i != currVertex && !visited[i] && connectionMap[currVertex][i] == 1) {
        recursive(i, connectionMap);
      }
    }
    return;
  }

  public int findCircleNum(int[][] isConnected) {
    count = 0;
    len = isConnected.length;
    visited = new boolean[len];
    for(int i = 0; i < len; i++) {
      if(!visited[i]) {
        recursive(i, isConnected);
        count++;
      }
    }
    return count;
  }

  public static void main(String[] args) {
    NumberOfProvince solution = new NumberOfProvince();
    int[][] isConnected1 = new int [][]{{1,1,0},{1,1,0},{0,0,1}};
    int[][] isConnected2 = new int [][]{{1,0,0},{0,1,0},{0,0,1}};

    int ans = solution.findCircleNum(isConnected2);

    System.out.println("count is .." + ans);

  }

}
