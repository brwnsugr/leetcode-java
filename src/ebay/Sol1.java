package ebay;

public class Sol1 {

  private String temp;



  public void removeZeroOneString(String str) {
    if(str.length() == 0) {
      temp = str;
      return;
    }
    String nextStr = str.replaceAll("01", "");

    if(nextStr.equals(str)) {
      temp = str;
      return;
    }
    removeZeroOneString(nextStr);
    return;
  }

  public int solution(String s) {
    temp = s;
    removeZeroOneString(s);
    return temp.length();
  }

  public static void main(String[] args) {
    Sol1 sol1 = new Sol1();

    int solution = sol1.solution("1011");

  }

}
