package written.leetcode.amazon.SortingAndSearching;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRoomsII253 {
  public int minMeetingRooms(int[][] intervals) {
    if(intervals.length == 1) return 1;
    Arrays.sort(intervals, new Comparator<int[]>() {
      @Override
      public int compare(int[] t1, int[] t2) {
        return t1[0] - t2[0];
      }
    });
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    for(int i = 0; i < intervals.length; i++) {
      pq.add(intervals[i][1]);
      int minEndTime = pq.peek().intValue();
      if(intervals[i][0] >= minEndTime) pq.remove();
    }
    return pq.size();
  }

  public static void main(String[] args) {
    MeetingRoomsII253 meetingRoomsII253 = new MeetingRoomsII253();
    int i = meetingRoomsII253.minMeetingRooms(new int[][]{{7, 10}, {2, 4}});

    System.out.println("ssss is " + i);
  }
}
