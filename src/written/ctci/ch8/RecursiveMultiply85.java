package written.ctci.ch8;

public class RecursiveMultiply85 {

  int cache[][];

  public int getMultiply(int a, int b) {
    if(cache[a][b] != 0) {
      return cache[a][b];
    }
    if(a == 1 || b == 1) {
      return a == 1 ? b : a;
    }
    else {
      int aLeft = a / 2;
      int aRight = a - aLeft;
      return getMultiply(aLeft, b) + getMultiply(aRight, b);
    }
  }

  public void solution(int a, int b) {

    cache = new int[a+1][b+1];
    int multiply = getMultiply(a, b);

    int i = 3 >> 1;
    int j = 4 >> 1;
    int k = 5 >> 1;

    System.out.println(i);

    System.out.println(multiply);

  }


  public static void main(String[] args) {

    RecursiveMultiply85 recursiveMultiply85 = new RecursiveMultiply85();

    recursiveMultiply85.solution(8,9);

  }
}
