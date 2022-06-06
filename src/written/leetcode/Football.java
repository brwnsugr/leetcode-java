package written.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Football {


  public int[] solution(int[] teamA, int[] teamB) {

    if(teamA.length == 0) return new int[teamB.length];
    Arrays.sort(teamA);

    int[] res = new int[teamB.length];

    int biggestScoreA = teamA[teamA.length - 1];
    //dp[i]: teamA 에서 i 점을 냈거나, 그 이하인 경기의 숫자
    //dp[i] = dp[i-1] + # of games of i score

    int[] dp = new int[biggestScoreA + 1];
    dp[0] = 0;

    // init number of games of each score at team A
    Map<Integer, Integer> scoreMapTeamA = new HashMap<>();
    for(int i = 0; i < teamA.length; i++) {
      int score = teamA[i];
      if(!scoreMapTeamA.containsKey(score)) {
        scoreMapTeamA.put(score, 0);
      }
      scoreMapTeamA.put(score, scoreMapTeamA.get(score) + 1);
    }

    // fill dp
    for(int i = 1; i <= biggestScoreA; i++) {
      int scoreToAdd = scoreMapTeamA.getOrDefault(i, 0);
      dp[i] = dp[i-1] + scoreToAdd;
    }

    //
    for(int i = 0; i < teamB.length; i++) {
      int bScore = teamB[i];
      res[i] = bScore >= biggestScoreA ? dp[biggestScoreA] : dp[bScore];
    }

    return res;
  }

  public int[] solution2(int[] queries, int[] arr, int x) {
    List<Integer> xIndicesArr = new ArrayList<>();

    for(int i = 0; i < arr.length; i++) {
      if(arr[i] == x) xIndicesArr.add(i+1);
    }

    int[] res = new int[queries.length];

    for(int i = 0; i < queries.length; i++) {
      if(queries[i] > xIndicesArr.size()) res[i] = -1;
      else res[i] = xIndicesArr.get(queries[i] - 1);
    }

    return res;
  }


  public static void main(String[] args) {
    Football football = new Football();

    int[] solution = football.solution(new int[]{1, 2, 3}, new int[]{2, 4});
    int[] ints = football
      .solution2(new int[]{100, 4, 2}, new int[]{1, 2, 20, 8, 8, 1, 2, 5, 8, 0}, 8);


    System.out.println("dddd ");


  }
}
