package written.snow;

public class Playtime {

  public int solution(int[] playList, int userPlayTime) {
    if(userPlayTime == 0) return 0;
    if(userPlayTime == 1) return 1;
    int[] cumulativePlayList = new int[playList.length * 2];

    for(int i = 0; i < playList.length * 2; i++) {
      if(i > 0) {
        cumulativePlayList[i] = cumulativePlayList[i-1] + playList[i % playList.length];
      }
      else {
        cumulativePlayList[i] = playList[i % playList.length];
      }
    }

    int left;
    int right;
    int answer = 0;

    for(int i = 0; i < cumulativePlayList.length; i++) {
      int startIdx = i;
      left = cumulativePlayList[i]-1;
      right = left + userPlayTime;
      int tempAnswer = 1;
      while(startIdx < cumulativePlayList.length && right > cumulativePlayList[startIdx] ) {
        tempAnswer++;
        startIdx++;
        if(tempAnswer == playList.length) break;
      }
      if(tempAnswer > answer) answer = tempAnswer;
    }
    return answer;
  }

  public static void main(String[] args) {
    Playtime playtime = new Playtime();
    int[] a = new int[]{2,3,1,4};
    int[] b = new int[]{1,2,3,4};
    int[] c = new int[]{2,3,4,5};

    int solution = playtime.solution(c, 3);

    System.out.println(solution);
  }

}
