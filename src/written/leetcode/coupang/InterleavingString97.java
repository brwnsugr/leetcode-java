package written.leetcode.coupang;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class InterleavingString97 {

  private Boolean[][] cache;

  public boolean isInterleave(String s1, String s2, String s3) {
    if(s1.length() + s2.length() != s3.length()) return false;
    cache = new Boolean[s1.length()+1][s2.length()+1];
    return recursive(s1, 0, s2, 0, "", s3);
  }

  private boolean recursive(String s1, int left, String s2, int right, String res, String target) {
    if(res.equals(target) && left == s1.length() && right == s2.length()) return true;
    if(cache[left][right] != null){
      return cache[left][right];
    }
    if(left < s1.length() && s1.charAt(left) == target.charAt(left+right)) {
      boolean leftAns = recursive(s1, left+1, s2, right, res+s1.charAt(left), target);
      cache[left][right] = leftAns;
      if(leftAns) {
        return true;
      }
    }
    if(right < s2.length() && s2.charAt(right)==target.charAt(left+right)) {
      boolean rightAns = recursive(s1, left, s2, right+1, res+s2.charAt(right), target);
      cache[left][right] = rightAns;
      if(rightAns) {
        return true;
      }
    }
    cache[left][right] = false;
    return false;
  }

  public static void main(String[] args) {
    String s1 = "aabcc";
    String s2 = "dbbca";
    String s3 = "aadbbcbcac";

    String s4 = "aabcc";
    String s5 = "dbbca";
    String s6 = "aadbbbaccc";
    InterleavingString97 interleavingString97 = new InterleavingString97();
    boolean interleave = interleavingString97.isInterleave("a", "b", "a");

    System.out.println("Dd" + interleave);


  }



}
