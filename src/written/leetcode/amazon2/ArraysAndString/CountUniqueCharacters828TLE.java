package written.leetcode.amazon2.ArraysAndString;

public class CountUniqueCharacters828TLE {

  public int uniqueLetterString(String s) {
    int answer = 0;
    //init substring comb which satisfies adj chars

    for(int i = 0; i < s.length(); i++) {
      int[] chars = new int[26];
      for(int j = i; j < s.length(); j++) {
        String subStr = s.substring(i, j + 1);
        chars[s.charAt(j)-'A']++;
        //calc unique char count for this substring
        int uniqueCounts = calcUniqueChars(chars);
        answer += uniqueCounts;
      }
    }
    return answer;
  }

  private int calcUniqueChars(int[] chars) {
    int uniqueCount = 0;
    for(int i = 0; i < 26; i++){
      if(chars[i] == 1) uniqueCount++;
    }
    return uniqueCount;
  }

  public static void main(String[] args) {
    int aba = new CountUniqueCharacters828TLE().uniqueLetterString("A");
    System.out.println("the answer is " + aba);
  }

}
