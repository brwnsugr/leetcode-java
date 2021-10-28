package written.hackerrank;

import java.util.List;

public class ArrayLeftRotation {

  public static List<Integer> rotLeft(List<Integer> a, int d) {
    // Write your code here
    //1,2,3,4,5,1,2,3,4,5
    int len = a.size();
    a.addAll(a);

    List<Integer> rotatedList = a.subList(d, d + len);

    return rotatedList;
  }


  public static void main(String[] args) {



  }

}
