package written.ctci.ch1;

public class CheckPermutation12 {
  public boolean isPermutation(String s1, String s2) {

    int[] chars = new int[128];

    if(s1.length() != s2.length()) return false;

    for(int i = 0; i < s1.length(); i++) {
      chars[s1.charAt(i)]++;
    }

    for(int j = 0; j < s2.length(); j++) {
      char c = s2.charAt(j);
      chars[c]--;
      if(chars[c] < 0) return false;
    }
    return true;
  }


  public static void main(String[] args) {
    CheckPermutation12 checkPermutation12 = new CheckPermutation12();
    String s1 = "abcd";

    String s2 = "bcda";
    String s3 = "efgh";

    boolean permutation = checkPermutation12.isPermutation(s1, s2);
    System.out.println("dd " + permutation);

  }
}
