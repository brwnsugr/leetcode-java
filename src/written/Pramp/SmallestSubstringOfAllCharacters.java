package written.Pramp;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SmallestSubstringOfAllCharacters {
  //Return "" (empty string) if such a substring doesn’t exist.
  static String getShortestUniqueSubstring(char[] arr, String str) {
    // your code goes here
    // arr = ['x','y'] str = "b"; -> return "";

    // going through str char array, I check all the substiring that contains
    // number of arr and number of each character in arr as well

    // then it will return the current substring that I'm on if we find it.
    //str:"xyyzyzyx"
    //left:1. right:4. [1:4] yyz  O(N*N)
    // len is str : N, len of arr : M,
    //. TC: O(N * N * M).

    //. yyz arr = ['x','y','z']
    // sliding windows -
    //
    // left: 0, right: 2(left Idx + lenghth of arr - 1)
    // "xyyzy", l:0, right:2 char[x-'a'] = 1. char[y-'a'] = 2
    // l:1, r:3, char[x-'a'] = 0 char[z-'a'] = 1 char[y-'a'] = 2 arr= ['x,'y','z'] -> char[x-'a'] = -1.
    // char[y-'a'] = 1 . char[z-'a'] = 0. -> false
    // x
    //
    // str= "xyyzyzyx"   arr=['x','y','z']
    //left=0 right=0  [left:right]
    // hashmap['x']=1
    //right++  hash['y']=1  'xy'
    //right++.  hash['y']=2  hash['x']=1 'xyy' count=2 (count of the hash)
    //right++.   hash['z']=1. 'xyyz' count=3          realanswer='xyyz'
    //left++     hash['x']--  hash['x']==0. delete(hahs['x'])  'yyz' count=2.
    //right++     'yyzy'   hash['y']=3.
    //right++      'yyzyz'
    //right++.     'yyzyzy'  hash['y']=4
    //right++        'yyzyzyx' hash['x']=1 hash['y']=4 hash['z']=2.  'yyzyzyx'
    //left++          'yzyzyx'  hash['y']=3.           'yzyzyx'
    //left++         'zyzyx'
// left++            'yzyx'
    //left++      'zyx'
    //left++        'yx'  hash['y']=1 hash['x']=1
    //right++
    //hash count of sub
    //for right=0;right<str.size();right++{
    //} TC : O(M*N)
    // 'abc'  'xyz'
    int left = 0; // ['x','y'] str = "xyyy";
    //int right = 0;
    Map<Character, Integer> countMap = new HashMap<>();
    String answer = "";

    Set<Character> s = new HashSet<>();
    for(Character c : arr) { //O(N)
      s.add(c);
    }
    // SC: O(N+M)
    for(int right = 0; right < str.length(); right++) { // M , O(M + M) = O(M) , N : len of arr
      String tempAnswer;

      if(s.contains(str.charAt(right))) {
        countMap.put(str.charAt(right), countMap.getOrDefault(str.charAt(right), 0) + 1);
      }

      if(countMap.size() == arr.length) {
        tempAnswer = str.substring(left, right + 1);
        if(answer.equals("") || tempAnswer.length() < answer.length()) answer = tempAnswer;
      }

      while(countMap.size() == arr.length && left < right) { // O()
        if(s.contains(str.charAt(left))) {
          countMap.put(str.charAt(left), countMap.get(str.charAt(left)) -1);
          if(countMap.get(str.charAt(left)) == 0) {
            countMap.remove(str.charAt(left));
            left++;
            break;
          }
        }

        left++;
        String temp = str.substring(left, right + 1);

        if(temp.length() < answer.length()) {
          answer = temp;
        }

      }
    }

    return answer;
  }

  public static void main(String[] args) {
    String ans = new SmallestSubstringOfAllCharacters().getShortestUniqueSubstring(new char[]{'x','z'}, "xyeezyzddx");
    System.out.println("answer is " + ans);
  }

}
