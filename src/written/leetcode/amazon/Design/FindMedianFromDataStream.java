package written.leetcode.amazon.Design;

import java.nio.channels.Pipe;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class FindMedianFromDataStream {

  List<Integer> nums;
  PriorityQueue<Integer> minHeap;
  PriorityQueue<Integer> maxHeap;
  public FindMedianFromDataStream() {
    minHeap = new PriorityQueue<>();
    maxHeap = new PriorityQueue<>(Collections.reverseOrder());
  }

  public void addNum(int num) {
    minHeap.add(num);
    maxHeap.add(minHeap.poll());
    if(minHeap.size() < maxHeap.size()) {
      minHeap.add(maxHeap.poll());
    }
  }

  public double findMedian() {
    int totalLen = minHeap.size() + maxHeap.size();
    if(totalLen == 0) return 0;
    if(totalLen % 2 == 0) {
      return (double) (minHeap.peek() + maxHeap.peek()) / 2;
    }
    else {
      return minHeap.size() > maxHeap.size() ? minHeap.peek() : maxHeap.peek();
    }
  }

  public static void main(String[] args) {
    FindMedianFromDataStream findMedianFromDataStream = new FindMedianFromDataStream();
    findMedianFromDataStream.addNum(-1);
    findMedianFromDataStream.addNum(-2);
//    double median = findMedianFromDataStream.findMedian();
    findMedianFromDataStream.addNum(-3);
    findMedianFromDataStream.addNum(6);
    double median1 = findMedianFromDataStream.findMedian();

    System.out.println("ddd is " + median1);
  }
}
