package written.leetcode.amazon4;

import java.util.Arrays;

public class Training2 {

  public int getMinimumNumberOfGroups(int[] awards, int k) {

    Arrays.sort(awards);

    int groups = 1;
    int maxAwardsInGroup = 0;

    for(int award : awards) {
      if(award > maxAwardsInGroup) {
        if(maxAwardsInGroup != 0) groups++;
        maxAwardsInGroup = award + k;
      }
    }

    return groups;
  }

  public static void main(String[] args) {
    Training2 training2 = new Training2();
    int minimumNumberOfGroups = training2
      .getMinimumNumberOfGroups(new int[]{5,9,10,13}, 3);

    System.out.println("answer is " + minimumNumberOfGroups);
  }

}
