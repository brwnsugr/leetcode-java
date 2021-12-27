package written.leetcode.amazon.ArrayAndStrings;

public class ImplementStr28 {

  public int strStr(String haystack, String needle) {
    if(needle.length() == 0) return 0;
    for(int i = 0; i < haystack.length()-needle.length()+1; i++) {
      if (haystack.substring(i, i + needle.length()).equals(needle)) return i;
    }
    return -1;
  }

  public static void main(String[] args) {
    ImplementStr28 implementStr28 = new ImplementStr28();
    int i = implementStr28.strStr("", "");
    System.out.println(" index is " + i);

  }

}
