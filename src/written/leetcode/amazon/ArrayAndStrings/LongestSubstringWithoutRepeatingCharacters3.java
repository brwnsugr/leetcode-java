package written.leetcode.amazon.ArrayAndStrings;

public class LongestSubstringWithoutRepeatingCharacters3 {

  public int lengthOfLongestSubstring(String s) {
    int[] c = new int[128];
    int left = 0;
    int right = 0;
    int len = s.length();
    int answer = Integer.MIN_VALUE;
    if (s.length() == 0)
      return 0;

    while (right < len) {
      c[s.charAt(right)]++;
      if(c[s.charAt(right)] > 1) {
        while (left < right && c[s.charAt(right)] > 1) {
          c[s.charAt(left)]--;
          left++;
        }
      }
      answer = Math.max(right - left + 1, answer);
      right++;
    }
    return answer;
  }

  public int bruteForce(String s) {
    int answer = Integer.MIN_VALUE;
    if(s.length() == 0) return 0;
    for(int i = 0; i < s.length(); i++) {
      for(int j = i; j < s.length(); j++) {
        String subWord = s.substring(i, j + 1);
        if(!checkIfDupExists(subWord)) {
          answer = Math.max(answer, subWord.length());
        }
      }
    }
    return answer;
  }

  private boolean checkIfDupExists(String word) {
    int[] c = new int[128];
    for(int i = 0; i < word.length(); i++) {
      if(c[word.charAt(i)] == 1) return true;
      else c[word.charAt(i)]++;
    }
    return false;
  }

  public static void main(String[] args) {
    LongestSubstringWithoutRepeatingCharacters3 longestSubstringWithoutRepeatingCharacters3 = new LongestSubstringWithoutRepeatingCharacters3();

    String a1 = "bcbb";

    int abca = longestSubstringWithoutRepeatingCharacters3.bruteForce("abbbcb");
    System.out.println("the answer is " + abca);
  }

}
