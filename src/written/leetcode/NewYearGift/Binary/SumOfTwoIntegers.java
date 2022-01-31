package written.leetcode.NewYearGift.Binary;

public class SumOfTwoIntegers {

  public int getSum(int a, int b) {
    int ans = 0;
    while(b != 0) {
      String s = Integer.toBinaryString(a);
      String s1 = Integer.toBinaryString(b);
      int length = s1.length();


      String s2 = Integer.toBinaryString(-3);
      ans = a ^ b;
      String s3 = Integer.toBinaryString(ans);

      int x = 3^4;
      int carry = (a & b) << 1;
      a = ans;
      b = carry;
    }


    return ans;
  }

  public static void main(String[] args) {
    SumOfTwoIntegers sumOfTwoIntegers = new SumOfTwoIntegers();

    sumOfTwoIntegers.getSum(5, -2);
  }
}
