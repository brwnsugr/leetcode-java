package written.leetcode.amazon.ArrayAndStrings;

public class StringToInteger8 {
  public int myAtoi(String s) {
    int result = 0;
    int sign = 1;
    int index = 0;
    int len = s.length();
    if(len == 0) return result;
    //check whitespace
    while(index < len && s.charAt(index) == ' ') index++;

    //check sign Signal(positive or negative)
    if(index < len && s.charAt(index) == '+') index++;
    else if(index < len && s.charAt(index) == '-') {
      sign = -1; index++;
    }

    //check digit til the end
    while(index < len && Character.isDigit(s.charAt(index))) {
      int digit = s.charAt(index)-'0';
      if(result > Integer.MAX_VALUE / 10 ||
          (result == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10)) {
        return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
      }
      else {
        result = (result * 10) + digit;
      }
      index++;
    }
    return result * sign;
  }

  public static void main(String[] args) {
    StringToInteger8 stringToInteger = new StringToInteger8();
    String s1 = "42";
    String s2 = "   -42";
    String s3 = "4193 with words";
    String s4 = "+-12";
    int i = stringToInteger.myAtoi(s4);

    System.out.println("the ans is " + i);
  }

}
