package written.nfinance;

public class Solution1 {

  public int solution(String S) {
    // write your code in Java SE 8
    if(S.contains("aaa")) return -1;
    StringBuilder strBuilder = new StringBuilder(S);

    int answer = 0;
    int len = strBuilder.length();
    int continuousA = 0;
    for(int i = 0; i < len; i++) {
      if(strBuilder.charAt(i) == 'a' && i == len -1 && continuousA == 0) {
        strBuilder.append('a');
        answer += 1;
      }
      else if(strBuilder.charAt(i) == 'a') {
        continuousA++;
      }
      else if(strBuilder.charAt(i) != 'a' && continuousA < 2) {
        strBuilder.insert(i, 'a');
        answer++;
        continuousA++;
        len++;
      }
      else if(strBuilder.charAt(i) != 'a' && i == len -1) {
        strBuilder.append("aa");
        answer += 2;
      }
      else if(strBuilder.charAt(i) != 'a') {
        continuousA = 0;
      }
    }
    return answer;
  }

  public static void main(String[] args) {
    Solution1 solution1 = new Solution1();
    int dog = solution1.solution("bbaa");

    System.out.println(dog);
  }

}
