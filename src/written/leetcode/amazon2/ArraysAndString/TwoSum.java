package written.leetcode.amazon2.ArraysAndString;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
  public int[] twoSum(int[] nums, int target) {

    /**
     * I'm gonna use The Complement.
     * Go through the nums array, look at our target, So track the value
     * Then
     * Complement is target - current element while we're in the loop
     * and if that already exist in our(the) hash map, then we have the number.
     * Otherwise, we're gonna store.
     */
    Map<Integer, Integer> m = new HashMap<>();
//    int[] res =
    //the thing w  e're gonna return, so we make an integer array called result and contains two things in it.

    //I Said I just had to go through all the numbers
    //for an i equal zero and i is less then num plusplus
    for(int i = 0; i < nums.length; i++) {

      /**
       * if the number we're at subtracted from the target we're looing for is in the hashmap
       * so we'll make it a variable called it complement(difference) set equal to like we just said the target minus the number that we're on
       * so, now we've done that calculation we set the check of our map contains so if map that contains key difference
       * and we actually have an answer now so We could just put in the zeroth(0th) index (i) because that's the first index. and otherwise
       * result of 1 (1번 인덱스) equals map get difference which we still need to put into our map and then
       * we just need to return result
       * and so if the difference is not in our map this is where we're gonna place it in here, so we won't even using
       * map put the number that we're on with the index
       * once this loop finishes all we should have to do is return this old.
       *
       * we passed 29 out of 29 test cases.  We're in the 99th percentile which is awesome
       * That's how I solve Two Sum Problem
       */
      int complement = target - nums[i];
      if(m.containsKey(nums[i])) {
        return new int[]{m.get(nums[i]), i};
      }
      m.put(complement, i);
    }
    return null;
  }



}
