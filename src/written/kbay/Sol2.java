package written.kbay;

public class Sol2 {


  public void removeStr(StringBuilder strBuilder) {
    int removeCount = 0;
    if(strBuilder.length() == 0) return;
    for(int i = 0; i < strBuilder.length()-1; i++) {
      if(strBuilder.charAt(i) != strBuilder.charAt(i+1)) {
        removeCount++;
        strBuilder.delete(i, i+2);
      }
    }
    if(removeCount == 0) return;
    removeStr(strBuilder);
  }

  public int solution2(String s) {
    StringBuilder stringBuilder = new StringBuilder(s);
    removeStr(stringBuilder);

    System.out.println(stringBuilder.length());
    return stringBuilder.length();
  }

  public static void main(String[] args) {
    Sol2 sol2 = new Sol2();

    int solution = sol2.solution2("000111");

  }

}
