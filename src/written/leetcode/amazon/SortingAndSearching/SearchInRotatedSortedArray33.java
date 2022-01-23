package written.leetcode.amazon.SortingAndSearching;

public class SearchInRotatedSortedArray33 {
  public int search(int[] nums, int target) {
    int idx = getIdx(nums, target, 0, nums.length - 1);
    return idx;
  }

  private int getIdx(int[] nums, int target, int start, int end) {
    if (start > end) return -1;
    int mid = (start + end) / 2;
    if(nums[mid] == target) return mid;
    if(nums[start] == target) return start;
    if(nums[end] == target) return end;
    else {
      if(nums[start] < nums[mid]) {
        if(target >= nums[start] && target < nums[mid]) {
          return getIdx(nums, target, start, mid -1);
        }
        else {
          return getIdx(nums, target, mid+1, end);
        }
      }
      else {
        if(target > nums[mid] && target <= nums[end]) {
          return getIdx(nums, target, mid+1, end);
        }
        else {
          return getIdx(nums, target, start, mid -1);
        }
      }
    }
  }

  public static void main(String[] args) {
    SearchInRotatedSortedArray33 searchInRotatedSortedArray33 = new SearchInRotatedSortedArray33();

    int search = searchInRotatedSortedArray33.search(new int[]{3,1}, 3);

    System.out.println("ddd is " + search);
  }
}
