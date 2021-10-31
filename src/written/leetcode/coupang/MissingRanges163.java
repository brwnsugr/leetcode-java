package written.leetcode.coupang;

import java.util.ArrayList;
import java.util.List;

public class MissingRanges163 {

  public List<String> findMissingRanges(int[] nums, int lower, int upper) {
    int prev = lower - 1;
    List<String> ans = new ArrayList<>();

    for(int i = 0; i <= nums.length; i++) {
      int curr = i < nums.length ? nums[i] : upper + 1;
      if(prev + 1 <= curr -1) {
        appendRangeStr(prev+1, curr-1, ans);
      }
      prev = curr;
    }
    return ans;
  }

  private void appendRangeStr(int startIdx, int endIdx, List<String> ans) {
    if(startIdx == endIdx) ans.add(Integer.toString(startIdx));
    else ans.add(Integer.toString(startIdx) + "->" + Integer.toString(endIdx));
  }



  public static void main(String[] args) {

  }

}
