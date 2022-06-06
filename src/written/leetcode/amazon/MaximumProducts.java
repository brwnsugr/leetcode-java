package written.leetcode.amazon;

public class MaximumProducts {


  public int solution(int[] nums) {

    int maxProducts = 0;
    for(int i = nums.length - 1; i>=0; i--) {
      int currProducts = nums[i];
      int tempSumProducts = nums[i];
      for(int j = i-1; j >= 0; j--) {
        if(nums[j] >= currProducts) {
          currProducts = currProducts - 1;
        }
        else {
          currProducts = nums[j];
        }
        tempSumProducts += currProducts;
      }
      maxProducts = Math.max(maxProducts, tempSumProducts);
    }

    return maxProducts;
  }

  public int solution2(int[] nums) {
    int max = 0;
    for(int i = nums.length - 1; i >= 0; i --) {
      max = Math.max(max, findMaxNumberOfProductsHelper(nums, i));
    }
    return max;
  }

  public int findMaxNumberOfProductsHelper(int [] numProducts, int end) {
    int num = numProducts[end];
    int curr = numProducts[end];

    if(end == 0) {
      return num;
    }

    for(int i = end - 1; i >= 0; i --) {
      if(numProducts[i] >= curr) {
        curr = curr - 1;
      }else {
        curr = numProducts[i];
      }
      num += curr;
    }
    return num;
  }



  public static void main(String[] args) {
    MaximumProducts sol = new MaximumProducts();
    int[] arr1 = new int[]{7, 4, 5, 2, 6, 5};
    int[] arr2 = new int[]{5,3,2};
    int[] arr3 = new int[]{1};
    int[] arr4 = new int[]{10,1};
    int[] arr5 = new int[]{10,2};
    int[] arr6 = new int[]{5,4,3,2,1};
    int[] arr7 = new int[]{8,9,10,4,5};

    int solution = sol.solution(arr7);

    System.out.println("answ is "  +  solution);
  }


}


