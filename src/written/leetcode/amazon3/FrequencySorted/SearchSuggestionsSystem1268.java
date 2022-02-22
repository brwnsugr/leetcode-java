package written.leetcode.amazon3.FrequencySorted;

import java.util.Arrays;
import java.util.List;

public class SearchSuggestionsSystem1268 {


  public static void main(String[] args) {

    String prefix = "";


    String word = "abcd";

    String word2 = "abc";

    System.out.println(word.compareTo(word2));


    prefix += word.charAt(0);

    System.out.println(prefix);

    List<Integer> dd = Arrays.asList(new Integer[3]);

    System.out.println("dddd");
  }

//  int check(int a,int b){
//    if (abs(a)!=abs(b)) return abs(a)-abs(b);
//    return a-b;
//  }
//  void quickSort(vector<int>& nums,int l,int r){
//    if (l>=r) return;
//    int i=l-1,j=r+1,x=nums[l+r>>1];
//    while (i<j){
//      while (check(nums[++i],x)<0);
//      while (check(nums[--j],x)>0);
//      if (i<j) swap(nums[i],nums[j]);
//    }
//    quickSort(nums,l,j);
//    quickSort(nums,j+1,r);
//  }
//  vector<int> absSort(const vector<int>& arr)
//  {
//    // your code goes here
//    auto nums=arr;
//    quickSort(nums,0,nums.size()-1);
//    return nums;
//  }

}
