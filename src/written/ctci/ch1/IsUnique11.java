package written.ctci.ch1;

public class IsUnique11 {

  //what if you can't use additional Datat structures?(such like hash map.. etc..)

  static int taxRate = 10;

  public boolean solution(String s1) {

    //Considering to convert to ASCII value

    if (s1.length() > 128) return false;

    boolean[] charArr = new boolean[128];

    for(int i = 0; i < s1.length(); i++) {
      if(charArr[s1.charAt(i)]) {
        return false;
      }
      else{
        charArr[s1.charAt(i)] = true;
      }
    }

    System.out.println(IsUnique11.taxRate);
    return true;
  }

  public boolean solution2(String s1) {
    int checker = 0;
    for(int i = 0; i < s1.length(); i++) {
      int val = s1.charAt(i) - 'a';

      int i1 = 1 << val;

      int i2 = 1 << 2;
      int i3 = 2<<3;
      int i4 = 1 << 4;

      if((checker & i1) > 0) {
        return false;
      }
      checker |= (1 <<val);
    }
    return true;
  }

  public static void main(String[] args) {


    String s = "!0abc";

    IsUnique11 isUnique11 = new IsUnique11();

    boolean abcde = isUnique11.solution2("abecde");

    System.out.println("is unique?" + abcde);

  }
}
