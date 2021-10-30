package written.ctci.ch8;

import java.util.ArrayList;
import java.util.List;

public class Parens89 {


  private List<char[]> validParens;
  private List<String> valids = new ArrayList<>();

  private void addParen(int leftRemains, int rightRemains, char[] str, int count) {
    if(leftRemains == 0 && rightRemains == 0) {
      validParens.add(str);
      String s = String.copyValueOf(str);
      valids.add(s);
      return;
    }

    if(leftRemains < rightRemains) {
      str[count] = ')';
      addParen(leftRemains, rightRemains - 1, str, count+1);
    }

    if(leftRemains > 0) {
      str[count] = '(';
      addParen(leftRemains - 1, rightRemains, str, count+1);
    }
  }

  public void solution(int n) {
    validParens = new ArrayList<>();

    char[] str = new char[n*2];

    addParen(n, n, str, 0);

    System.out.println("ddd");

  }

  public static void main(String[] args) {
    Parens89 parens89 = new Parens89();

    parens89.solution(3);
  }

}
