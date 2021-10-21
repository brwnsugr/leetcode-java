package written.leetcode.bytedance;

import java.util.ArrayList;
import java.util.List;

public class N1352ProductOfTheLastKNumbers {

  private List<Integer> numbers;

  public N1352ProductOfTheLastKNumbers() {
    numbers = new ArrayList<>();
  }

  public void add(int num) {
    numbers.add(num);
  }

  public int getProduct(int k) {
    int productVal = 1;
    if(numbers.size() == 1) return numbers.get(0);
    int lastIdx = numbers.size() - 1;
    for(int i = lastIdx; i > lastIdx - k; i--) {
      productVal *= numbers.get(i);
    }
    return productVal;
  }

  public static void main(String[] args) {

  }

}
