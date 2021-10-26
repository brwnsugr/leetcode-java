package written.leetcode.coupang;

import java.util.ArrayList;
import java.util.List;

public class MinStack155 {

  private List<Integer> list;

  public MinStack155() {
    list = new ArrayList<>();
  }

  public void push(int val) {
    list.add(val);
  }

  public void pop() {
    if(list.size() < 1) return;
    list.remove(list.size() - 1);
  }

  public int top() {
    return list.get(list.size()-1);
  }

  public int getMin() {
    int minVal = Integer.MAX_VALUE;
    for(int i = 0; i < list.size(); i++) {
      if(list.get(i) < minVal) {
        minVal = list.get(i);
      }
    }
    return minVal;
  }

}
