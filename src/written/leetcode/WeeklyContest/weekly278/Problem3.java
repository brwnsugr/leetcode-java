package written.leetcode.WeeklyContest.weekly278;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Problem3 {
  public String subStrHash(String s, int power, int modulo, int k, int hashValue) {
    String ans ="";
    int[] vals = new int[s.length()];

    for(int i = 0; i < s.length(); i++) {
      vals[i] = s.charAt(i) - 'a' + 1;
    }

    for(int i = 0; i < s.length()-k; i++) {
      int sum = 0;
      int multiplier = 0;
      boolean getHashValue = false;
      for(int j = i; j < s.length(); j++) {
        sum += power(vals[j], power, multiplier, modulo);
        if(j+1 -i > k) break;
        if(j+1-i == k && sum % modulo == hashValue) {
          getHashValue = true;
          ans = s.substring(i,j+1);
          break;
        }
        multiplier++;
      }
      if(getHashValue) {
        break;
      }
    }
    return ans;
  }

  public int power(int base, int power, int multiplier, int modulo) {
    Map<Integer, Integer> m = new HashMap<>();
    if(multiplier == 0) return base;
    else {
      boolean fastForward = false;
      while(multiplier > 0) {
        if(!fastForward) {
          if(m.containsKey(base)) {
            multiplier %= m.get(base) - multiplier;
            fastForward = true;
          }
          else {
            m.put(base, multiplier);
          }
        }
        if(multiplier > 0) {
          multiplier--;
          base *= power;
          base %= modulo;
        }
      }
    }
    return base;
  }

  public static void main(String[] args) {
    Problem3 problem3 = new Problem3();

//    String leetcode = problem3.subStrHash("leetcode", 7, 20, 2, 0);
    String leetcode = problem3.subStrHash("fbxzaad", 31, 100, 3, 32);

    System.out.println("ddd is   " + leetcode);
  }

}
