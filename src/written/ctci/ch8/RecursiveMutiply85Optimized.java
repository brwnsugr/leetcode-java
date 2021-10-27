package written.ctci.ch8;

public class RecursiveMutiply85Optimized {


  public int getMultiply(int smaller, int bigger, int[] cache) {
    if(smaller == 0) {
      return 0;
    }
    else if(smaller == 1) {
      return bigger;
    }
    else if(cache[smaller] > 0) {
      return cache[smaller];
    }
    int half = smaller >> 1;
    int side1 = getMultiply(half, bigger, cache);
    int side2 = side1;

    if(half % 2 == 1) {
      side2 = getMultiply(smaller - half, bigger, cache);
    }

    cache[smaller] = side1 + side2;
    return cache[smaller];
  }


  public int solution(int a, int b) {
    int smaller = a < b ? a : b;
    int bigger = a > b ? a : b;
    int[] cache = new int[a+1];
    return getMultiply(smaller,bigger,cache);

  }

  public static void main(String[] args) {
    RecursiveMutiply85Optimized recursiveMutiply85Optimized = new RecursiveMutiply85Optimized();

    int solution = recursiveMutiply85Optimized.solution(8, 6);

    System.out.println("sol is " + solution);
  }

}
