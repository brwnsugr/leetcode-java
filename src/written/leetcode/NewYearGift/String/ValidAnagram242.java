package written.leetcode.NewYearGift.String;

public class ValidAnagram242 {
  public boolean isAnagram(String s, String t) {
    int[] ch = new int[26];
    for(char c : s.toCharArray()) ch[c-'a']++;
    for(char c : t.toCharArray()) ch[c-'a']--;
    for(int num : ch){
      if(num != 0) return false;
    }

    return true;
  }

  public static void main(String[] args) {

  }
}
