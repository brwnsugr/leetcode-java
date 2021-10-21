package written.bthumb;

import java.io.IOException;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class Sol1 {

  public int solution(int[] openA, int[] closeB) {
    int answer = 0;
    TreeMap<Integer, Boolean> doorTimeMap = new TreeMap<>();

    for(int openTime : openA) {
      doorTimeMap.put(openTime, true);
    }

    for(int closeTime : closeB) {
      doorTimeMap.put(closeTime, false);
    }

    boolean isOpened = false;

    Iterator<Entry<Integer, Boolean>> entries = doorTimeMap.entrySet().iterator();

    int previousTime = 0;
    while(entries.hasNext()) {
      Map.Entry<Integer, Boolean> entry = entries.next();
      boolean previousOpened = isOpened;
      if(!previousOpened && entry.getValue()) { //닫혀있었다가 열려지면
        isOpened = true;
        previousTime = entry.getKey(); //이전 시간 갱신
      }
      else if(previousOpened && entry.getValue()) { // 열러있었고, 다음도 열려 있으면
        answer += (entry.getKey() - previousTime);
        previousTime = entry.getKey();
        isOpened = true;//생략가능
      }
      else if(previousOpened && !entry.getValue()) { // 열렸다가 닫면
        answer += (entry.getKey() - previousTime);
        previousTime = entry.getKey();
        isOpened = false;
      }
      else { //닫혀있다가 닫혀있으면
        isOpened = false;
        previousTime = entry.getKey();
      }
    }
    return answer;
  }

  public static void init()  throws IOException {
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    System.out.println("최소 힙");
    runHeapTest(minHeap);


    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    System.out.println("최대 힙");
    runHeapTest(maxHeap);
  }

  private static void runHeapTest(PriorityQueue<Integer> heap) {
    heap.add(0);
    heap.add(0);
    heap.add(0);
    heap.add(0);
    heap.add(0);
    while(!heap.isEmpty()) {
      System.out.println(heap.poll());
    }
  }


  public static void main(String[] args) throws IOException {
    System.out.println();
    init();
//    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
  }

}
