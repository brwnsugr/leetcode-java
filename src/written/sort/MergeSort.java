package written.sort;

public class MergeSort {

  public void mergeSort(int start, int end, int[] arr, int[] sortedArr) {

    if(start < end) {
      int mid = (start + end)/2;

      mergeSort(start, mid, arr, sortedArr);
      mergeSort(mid+1, end, arr, sortedArr);

      int p = start;
      int q = mid + 1;
      int idx = p;

//      while( p <= mid || q <= end) {
//        if(q > end || (p<=mid && arr[p] <= arr[q])) {
//          sortedArr[idx++] = arr[p++];
//        }
//        else {
//          sortedArr[idx++] = arr[q++];
//        }
//      }
      while( p <= mid && q <= end) {
        if(arr[p] > arr[q]) {
          sortedArr[idx++] = arr[q++];
        }
        else{
          sortedArr[idx++] = arr[p++];
        }
      }

      while (p <= mid) {
        sortedArr[idx++] = arr[p++];
      }

      while (q <= end) {
        sortedArr[idx++] = arr[q++];
      }

      for(int i = start; i <= end; i++){
        arr[i] = sortedArr[i];
      }
    }
  }



  public static void main(String[] args) {
    MergeSort mergeSort = new MergeSort();
    int[] arr1 = new int[]{6,2,4,1,3,7,5,8};
    int[] sortedArr = new int[arr1.length];
    mergeSort.mergeSort(0, arr1.length - 1, arr1, sortedArr);
    for(int num : sortedArr) {
      System.out.println("num is " + num);
    }
  }
}
