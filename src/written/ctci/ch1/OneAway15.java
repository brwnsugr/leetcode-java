package written.ctci.ch1;

public class OneAway15 {


  public boolean isOneEdit(String s1, String s2) {
    int diff = s1.length() - s2.length();
    if(Math.abs(diff) >= 2) return false;
    int modifyCount = 0;

    if(diff > 0) { // remove right side
      int j = 0;
      for(int i = 0; i < s1.length(); i++) {
        if(modifyCount > 1) return false;
        if(s1.charAt(i) != s2.charAt(j)) {
          modifyCount++;
          continue;
        }
        j++;
      }
    }

    else if(diff < 0) {
      int j = 0;
      for(int i = 0; i < s2.length(); i++) {
        if(modifyCount > 1) return false;
        if(j > s2.length()) return true;
        if(s2.charAt(i) != s1.charAt(j)) {
          modifyCount++;
          continue;
        }
        j++;
      }
    }

    else {
      for(int i = 0; i < s1.length(); i++) {
        if(s1.charAt(i) != s2.charAt(i)) modifyCount++;
        if(modifyCount > 1) return false;
      }
    }

    return true;
  }



  public static void main(String[] args) {
    OneAway15 oneAway15 = new OneAway15();
    String s1 = "pale";
    String s2 = "ple";
    String s3 = "pale";
    String s4 = "pake";

    boolean oneEdit = oneAway15.isOneEdit(s3, s4);

    System.out.println("dd" + oneEdit);
  }

}
