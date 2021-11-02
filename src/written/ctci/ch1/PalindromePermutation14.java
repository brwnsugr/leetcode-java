package written.ctci.ch1;

public class PalindromePermutation14 {
  public boolean isPalindrome(String s1) {
    int oddCount = 0;
    int[] chars = new int[128];
    s1 = s1.trim().toLowerCase();
    for(int i = 0; i < s1.length(); i++) {
      chars[s1.charAt(i)]++;
    }

    for(int c : chars) {
      if (c != 0 && c % 2 != 0) {
        oddCount++;
      }
    }

    if(oddCount > 1) return false;
    return true;
  }

  public static void main(String[] args) {
    PalindromePermutation14 palindromePermutation14 = new PalindromePermutation14();
    String s1 = "aba";
    boolean palindrome = palindromePermutation14.isPalindrome(s1);
    System.out.println("truth is" + palindrome);
  }

}
