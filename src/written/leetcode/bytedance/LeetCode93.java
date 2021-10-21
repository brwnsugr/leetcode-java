package written.leetcode.bytedance;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LeetCode93 {
  int n ;
  String s;

  private List<String> outputList = new ArrayList<>();
  private LinkedList<String> segments = new LinkedList<>();

  private void updateOutput(int currPos) {
    String lastSegment = s.substring(currPos + 1, n);
    if(isValid(lastSegment)) {
      segments.add(lastSegment);
      outputList.add(String.join(".", segments));
      segments.removeLast();
    }
  }

  private boolean isValid(String segment) {
    int segmentLength = segment.length();
    if(segmentLength > 3) return false;
    return segment.charAt(0) != 0 ? Integer.valueOf(segment) <= 256 : segmentLength == 1;
  }

  private void backTrack(int prevPos, int dot) {
    int maxPos = Math.min(prevPos + 4, n - 1);
    for(int currPos = prevPos + 1; currPos < maxPos; currPos++) {
      String segment = s.substring(prevPos + 1, currPos + 1);
      if(isValid(segment)) {
        segments.add(segment);
        if(dot - 1 == 0) {
          updateOutput(currPos);
        } else {
          backTrack(currPos, dot - 1);
        }
        segments.removeLast();
      }
    }
  }

  public List<String> restoreIpAddresses(String s) {
    this.s = s;
    n = s.length();
    backTrack(-1, 3);
    return outputList;
  }




  public static void main(String[] args) {


  }

}
