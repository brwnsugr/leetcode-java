package written.leetcode.amazon.Design;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class MaximumFrequencyStack895 {

  Map<Integer, Integer> freqMap;
  Map<Integer, Stack<Integer>> maxFreqMap;
  int maxFreq;

  public MaximumFrequencyStack895() {
    freqMap = new HashMap<>();
    maxFreqMap = new HashMap<>();
    maxFreq = 0;
  }

  public void push(int val) {
    freqMap.put(val, freqMap.getOrDefault(val, 0) + 1);
    int currFreq = freqMap.get(val);
    if(currFreq > maxFreq) maxFreq = currFreq;

    if(!maxFreqMap.containsKey(currFreq)) maxFreqMap.put(currFreq, new Stack<>());
    maxFreqMap.get(currFreq).push(val);
  }

  public int pop() {
    int ret = maxFreqMap.get(maxFreq).pop();
    if(maxFreqMap.get(maxFreq).isEmpty()) maxFreq--;
    return ret;
  }


  public static void main(String[] args) {

    MaximumFrequencyStack895 maximumFrequencyStack895 = new MaximumFrequencyStack895();

    maximumFrequencyStack895.push(2);
    maximumFrequencyStack895.push(4);
    maximumFrequencyStack895.push(2);
    maximumFrequencyStack895.push(3);

    int pop = maximumFrequencyStack895.pop();

    System.out.println("first element is " + pop);

    int pop1 = maximumFrequencyStack895.pop();

    System.out.println("second element is " + pop1);

    int pop2 = maximumFrequencyStack895.pop();

    System.out.println("third element is " + pop2);


    int pop3 = maximumFrequencyStack895.pop();

    System.out.println("?Fourth Elemtn is " + pop3);
  }
}
