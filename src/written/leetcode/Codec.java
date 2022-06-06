package written.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Codec {

  // Encodes a list of strings to a single string.
  public String encode(List<String> strs) {
    if(strs.size() == 0) return Character.toString((char) 258);

    String d = Character.toString((char) 257);

    StringBuilder strBuilder = new StringBuilder();
    for(String s : strs) {
      strBuilder.append(s);
      strBuilder.append(d);
    }

    strBuilder.deleteCharAt(strBuilder.length() -1);
    return strBuilder.toString();
  }

  // Decodes a single string to a list of strings.
  public List<String> decode(String s) {
    String d = Character.toString((char) 258);
    if(s.equals(d)) return new ArrayList<>();

    d = Character.toString((char) 257);

    String[] split = s.split(d, -1);

    List<String> strings = Arrays.asList(split);


    return null;
  }


  public static void main(String[] args) {
    Codec codec = new Codec();
    List<String> strs = new ArrayList<>();
    strs.add("Hello"); strs.add("World");
    List<String> hello_world = codec.decode("Hello World");

    String encode = codec.encode(strs);

    System.out.println("ddd is " + encode);
  }

}
