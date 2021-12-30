package written.leetcode.amazon.ArrayAndStrings;

import java.util.ArrayList;
import java.util.List;

public class IntegerToEnglishWords273 {

  public static String[] threeDigitUnits = {
    "Hundred","Thousand","Million", "Billion"
  };

  public static String[] oneDigitUnits = {
      "",
      "One",
      "Two",
      "Three",
      "Four",
      "Five",
      "Six",
      "Seven",
      "Eight",
      "Nine"
  };

  public static String[] tenDigitUnits = { // tendigits == 1x -> direct to downside
      null,
      "Twenty",
      "Thirty",
      "Forty",
      "Fifty",
      "Sixty",
      "Seventy",
      "Eighty",
      "Ninety"
  };

  public static String[] teens = {
      "Ten",
      "Eleven",
      "Twelve",
      "Thirteen",
      "Fourteen",
      "Fifteen",
      "Sixteen",
      "Seventeen",
      "Eighteen",
      "Nineteen",
  };

  public String numberToWords(int num) {

    List<Integer> threeDigitsList = new ArrayList<>();
    if(num == 0 ) return "Zero";

    while(num > 0) {
      int r = num % 1000;
      num = num / 1000;
      threeDigitsList.add(r);
    }

    StringBuilder answerStringBuilder = new StringBuilder();
    int threeDigitsOrder = 0;
    for(int i = 0; i < threeDigitsList.size(); i++) {
      String threeUnitDigitNumber = buildThreeUnitDigit(threeDigitsList.get(i), threeDigitsOrder);
      answerStringBuilder.insert(0, threeUnitDigitNumber);
      threeDigitsOrder++;
    }
    return answerStringBuilder.toString().trim();
  }

  String buildThreeUnitDigit(int number, int threeDigitUnitsOrder) {
    StringBuilder stringBuilder = new StringBuilder();
    if(number == 0) return "";
    if(threeDigitUnitsOrder == 0) {
      stringBuilder.append(buildUnderThousand(number));
    }
    else {
      stringBuilder.append(buildUnderThousand(number) + threeDigitUnits[threeDigitUnitsOrder] + " ");
    }

    return stringBuilder.toString();
  }

  String buildUnderThousand(int number) {
    int hundredDigit = number / 100;
    int tenDigit = number % 100 / 10;
    int oneDigit = number % 10;
    StringBuilder stringBuilder = new StringBuilder();
    if(hundredDigit != 0) {
      stringBuilder.append(oneDigitUnits[hundredDigit] + " " + threeDigitUnits[0]+ " ");
    }
    if(tenDigit != 0) {
      if(tenDigit == 1) {
        stringBuilder.append(teens[oneDigit] + " ");
      }
      else {
        stringBuilder.append(tenDigitUnits[tenDigit-1] + " " + oneDigitUnits[oneDigit]);
        if(oneDigit != 0) stringBuilder.append(" ");
      }
    }
    if(tenDigit == 0){
      stringBuilder.append(oneDigitUnits[oneDigit]);
      if(oneDigit != 0) stringBuilder.append(" ");
    }
    return stringBuilder.toString();
  }

  public static void main(String[] args) {
    IntegerToEnglishWords273 integerToEnglishWords273 = new IntegerToEnglishWords273();

    String s = integerToEnglishWords273.numberToWords(1000000);

    System.out.println("ddd is " + s);
  }

}
