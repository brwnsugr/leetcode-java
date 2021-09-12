package kmp;

import java.util.ArrayList;
import java.util.List;

public class Kmp {

  private static List<Integer> ret = new ArrayList<>();
  private int[] partialTable;


  private void kmpSearch(String whole, String subStr) {
    int m = whole.length();
    int n = subStr.length();

    int matched = 0; int begin = 0;

    setPartialTable(subStr);

    while(begin <= m - n) {
      if(matched < n && subStr.charAt(matched) ==  whole.charAt(begin + matched)) {
        matched++;
        if(matched == n) {
          ret.add(begin);
        }
      }
      else {
        if(matched == 0) {
          begin++;
        }
        else {
          begin += matched - partialTable[matched -1];
          matched = partialTable[matched-1];
        }
      }
    }
  }

  private void setPartialTable(String subStr) {
    int n = subStr.length();
    partialTable = new int[n];

    int begin = 1; int matched = 0;
    while(begin + matched < n) {
      if(subStr.charAt(matched) == subStr.charAt(begin + matched)) {
        matched++;
        partialTable[begin+matched-1] = matched;
      }
      else {
        if(matched == 0) {
          begin += 1;
        }
        else {
          begin += matched - partialTable[matched -1];
          matched = partialTable[matched-1];
        }
      }
    }
  }





  public static void main(String[] args) {
    Kmp kmp = new Kmp();

    String N = "aabaabac";
    String H = "aabaabacaabaabaabac";

    kmp.kmpSearch(H, N);

    for(Integer a : ret) {
      System.out.println(a);
    }
  }


}
