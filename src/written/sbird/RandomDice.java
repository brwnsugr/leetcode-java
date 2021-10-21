package written.sbird;

import java.util.Random;

public class RandomDice {

  public static void main(String[] args) {
    Random random = new Random();
    System.out.println(random.nextInt(6) + 1);
  }

}
