package written.leetcode.amazon4;

public class Training1 {


  public int getMinHealth(int[] powers, int armor) {

    //12
    //[1,2,6,2], armor = 5
    //1+2+6+2+1 = 12

    int maxPower = Integer.MIN_VALUE;
    int totalPower = 0;
    for(int power : powers){
      maxPower = Math.max(maxPower, power);
      totalPower += power;
    }
    int powerOffset = Math.min(armor, maxPower);
    return totalPower - powerOffset + 1;
  }

  public static void main(String[] args) {
    Training1 training1 = new Training1();
    int minHealth = training1.getMinHealth(new int[]{1, 2, 6, 7}, 5);

    System.out.println("answer is " + minHealth);
  }


}
