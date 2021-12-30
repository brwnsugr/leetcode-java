package written.leetcode.amazon.ArrayAndStrings;

import java.util.ArrayList;
import java.util.List;

public class ProductOfArrayExceptSelf238 {
  public int[] productExceptSelf(int[] nums) {

    /**
     * [1,2,3,4]
     * -> [{1, 24}, {2, 24}, {6, 12}, {24, 4}]
     * except[i] = products[i-1][0] * products[i+1][1];
     *
     * [-1,1,0,-3,3]
     * -> [{-1,0}, {-1,0}, {0,0},{0,-9},{0,3}]
     * except[2] = -1 * -9 = 9
     * except[1] = -1 * 0= 0
     */
    List<int[]> products = new ArrayList<>(nums.length);
    for(int i = 0; i < nums.length; i++) products.add(new int[2]);
    int len = nums.length;
    for(int i = 0; i < len; i++) {
      if(i == 0) {
        products.get(i)[0] = nums[0];
        products.get(len -1 -i)[1] = nums[len-1-i];
      }
      else {
        products.get(i)[0] = products.get(i-1)[0] * nums[i];
        products.get(len-1-i)[1] = products.get(len-i)[1] * nums[len-1-i];
      }
    }

    int[] exceptProducts = new int[len];

    for(int i = 0; i < len; i++) {
      if(i == 0) {
        exceptProducts[i] = products.get(i+1)[1];
      }
      else if(i == len -1) {
        exceptProducts[i] = products.get(i-1)[0];
      }
      else {
        exceptProducts[i] = products.get(i-1)[0] * products.get(i+1)[1];
      }
    }
    return exceptProducts;
  }

  public static void main(String[] args) {
    ProductOfArrayExceptSelf238 productOfArrayExceptSelf238 = new ProductOfArrayExceptSelf238();
    int[] arr1 = new int[]{1,2,3,4};
    int[] arr2 = new int[]{-1,1,0,-3,3};
    int[] ints = productOfArrayExceptSelf238.productExceptSelf(arr2);

    System.out.println("absdfsfsd");

  }

}


