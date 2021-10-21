package written.leetcode.bytedance;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class N1352Advanced {

  private List<Integer> numbers;

  public N1352Advanced() {
    numbers = new ArrayList<>(Collections.singletonList(1));
  }

  public void add(int num) {
    if(num > 0) {
      int lastElement = numbers.get(numbers.size()-1);
      numbers.add(lastElement * num);
    }
    else {
      numbers = new ArrayList<>(Collections.singletonList(1));
    }
  }

  public int getProduct(int k) {
    if(k < numbers.size()) {
      int lastIdx = numbers.size() - 1;
      return numbers.get(lastIdx) / numbers.get(lastIdx - k);
    }
    else {
      return 0;
    }
  }

}
