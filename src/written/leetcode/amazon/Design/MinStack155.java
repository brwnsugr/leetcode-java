package written.leetcode.amazon.Design;

import java.util.LinkedList;
import java.util.List;

public class MinStack155 {


  private List<Integer> list;

  public MinStack155() {
    list = new LinkedList<>();
  }

  public void push(int val) {
    list.add(val);
  }

  public void pop() {
    if(list.size() == 0) return;
    list.remove(list.size()-1);
  }

  public int top() {
    return list.get(list.size()-1);
  }

  public int getMin() {
    int min = Integer.MAX_VALUE;
    for(int i : list) {
      min = Math.min(min, i);
    }
    return min;
  }


  public static void main(String[] args) {
    MinStack155 minStack155 = new MinStack155();
    minStack155.push(-2);
    minStack155.push(0);
    minStack155.push(-3);

    int min = minStack155.getMin();
    System.out.println("ddd is " + min);

    minStack155.pop();
    int top = minStack155.top();

    System.out.println(" top is" + top);

    int min1 = minStack155.getMin();
    System.out.println("mins is " + min1);
  }
}
