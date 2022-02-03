package written.leetcode.amazon2.ArraysAndString;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {

  private Map<String, Integer> map = new HashMap<>();

  public int romanToInt(String s) {
    /**
     * going through the string as a character array
     * if we would find the valid substring which means the specific number we defined.
     *
     * then we add it by the number and move on to the next part of the string. til the array end.
     * So, we have to define the substring set which is pointing to the specific number we promised in advance.
     */

    map.put("I", 1);
    map.put("V", 5);
    map.put("X", 10);
    map.put("L", 50);
    map.put("C", 100);
    map.put("D", 500);
    map.put("M", 1000);

    return 1;








  }


  public static void main(String[] args) {
    RomanToInteger romanToInteger = new RomanToInteger();

  }


}
