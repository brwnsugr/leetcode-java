package written.ctci.ch1;

import java.util.HashMap;
import java.util.Map;

public class StringCompression16 {

  public String buildCompression(String s) {
    Map<Character, Integer> map = new HashMap<>();
    if(s.length() == 0) return null;

    char prev = ' ';
    char curr;
    StringBuilder stringBuilder = new StringBuilder();
    for(int i = 0; i < s.length(); i++) {
      curr = s.charAt(i);
      if(prev != curr && i != 0) {
        stringBuilder.append(prev + Integer.toString(map.get(prev)));
        map.clear();
        map.put(curr, map.getOrDefault(curr, 0) + 1);
      }
      else {
        map.put(curr, map.getOrDefault(curr, 0) + 1);
      }
      prev = curr;
    }
    stringBuilder.append(prev + Integer.toString(map.get(prev)));
    return new String(stringBuilder);
  }

  public static void main(String[] args) {
    String a1 = "aaabbc";
    StringCompression16 stringCompression16 = new StringCompression16();

    String s = stringCompression16.buildCompression(a1);

    System.out.println(s);
  }

}
