package written.ctci.ch1;

public class StringRotation19 {

  public boolean solution(String s1, String s2) {
    int len = s1.length();
    String concatStr = s1 + s1;

    for(int i = 0; i < len - 1; i++) {
      String rotatedStr = concatStr.substring(i, i + len);
      if(s2.equals(rotatedStr)){
        return true;
      }
    }
    return false;
  }

  public boolean optimizedSolution(String s1, String s2) {
    String concatStr = s1 + s1;
    return s1.length() != s2.length() ? false : concatStr.contains(s2);
  }

  public static void main(String[] args) {

    String s1 = "waterbottle";
    String s2 = "erbottlewat";

    StringRotation19 stringRotation19 = new StringRotation19();
    boolean isSubstring = stringRotation19.optimizedSolution(s1, s2);

    System.out.println("isSubString  is " + isSubstring);

    //T.C: O(N * N),
    //M.C: O(N)
  }

}
