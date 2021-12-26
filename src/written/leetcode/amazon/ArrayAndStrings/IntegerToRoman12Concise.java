package written.leetcode.amazon.ArrayAndStrings;

import java.util.Arrays;

public class IntegerToRoman12Concise {

  public static int[] numbers = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
  public static String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

  public String intToRoman(int num) {
    StringBuilder stringBuilder = new StringBuilder();
    for(int i = 0; i < numbers.length; i++) {
      while(num - numbers[i] >= 0) {
        num -= numbers[i];
        stringBuilder.append(symbols[i]);
      }
    }
    return stringBuilder.toString();
  }

  public static void main(String[] args) {
    IntegerToRoman12Concise integerToRoman12Concise = new IntegerToRoman12Concise();
    String s = integerToRoman12Concise.intToRoman(1994);

    System.out.println("ssss" + s);
  }
}
