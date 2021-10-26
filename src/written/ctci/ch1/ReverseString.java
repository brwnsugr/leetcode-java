package written.ctci.ch1;

public class ReverseString {

  public String solution(String s1) {
    int len = s1.length();
    if(len == 0 || len == 1) {
      return s1;
    }
    StringBuilder reversedStringBuilder = new StringBuilder();
    for(int i = len-1; i >= 0; i--) {
      reversedStringBuilder.append(s1.charAt(i));
    }

    return reversedStringBuilder.toString();
  }




  public static void main(String[] args) {
    String s1 = "abcd";

    ReverseString reverseString = new ReverseString();

    String reversedWord = reverseString.solution(s1);

    System.out.println("reversed word is " + reversedWord);
  }

}
