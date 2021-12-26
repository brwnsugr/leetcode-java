package written.leetcode.amazon.ArrayAndStrings;

public class IntegerToRoman12 {
  private Integer number;
  public String intToRoman(int num) {
    StringBuilder strBuilder = new StringBuilder();


    if((num / 1000) > 0) {
      num = build(strBuilder, num, "M", 1000);
    }

    if((num/900) > 0) {
      num = build(strBuilder, num, "CM", 900);
    }

    if((num / 500) > 0) {
      num = build(strBuilder, num, "D", 500);
    }

    if((num / 400) > 0) {
      num = build(strBuilder, num, "CD", 400);
    }

    if((num / 100) > 0) {
      num = build(strBuilder, num, "C", 100);
    }

    if((num / 90) > 0) {
      num = build(strBuilder, num, "XC", 90);
    }

    if((num / 50) > 0) {
      num = build(strBuilder, num, "L", 50);
    }

    if((num / 40) > 0) {
      num = build(strBuilder, num, "XL", 40);
    }

    if((num / 10) > 0) {
      num = build(strBuilder, num, "X", 10);
    }

    if((num / 9) > 0) {
      num = build(strBuilder, num, "IX", 9);
    }

    if((num / 5) > 0) {
      num = build(strBuilder, num, "V", 5);
    }

    if((num / 4) > 0) {
      num = build(strBuilder, num, "IV", 4);
    }

    if((num / 1) > 0) {
      num = build(strBuilder, num, "I", 1);
    }

    return strBuilder.toString();
  }

  private int build(StringBuilder strBuilder, int number, String c, int bar) {
    int q = number / bar;
    for(int i = 0; i <q; i++) strBuilder.append(c);
    number -= q*bar;
    return number;
  }

  public static void main(String[] args) {
    IntegerToRoman12 integerToRoman12 = new IntegerToRoman12();
    String s = integerToRoman12.intToRoman(58);
    System.out.println("dddd is " +  s);

  }

}
