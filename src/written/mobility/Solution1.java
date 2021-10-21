package written.mobility;

import java.util.HashMap;
import java.util.Map;

public class Solution1 {

  public String solution(String S, String C) {
    // write your code in Java SE 8

    C = C.toLowerCase();
    String names[] = S.split(", ");

    StringBuilder strBuilder = new StringBuilder();
    Map<String, Integer> emailMap = new HashMap<>();
    for(String name : names) {
      String[] separatedName = name.split(" ");
      String eachEmailName = "";
      for(int i = separatedName.length -1 ; i >=0; i--) {
        if(i == separatedName.length -1) { //last name
          String lastName = separatedName[i]
              .toLowerCase()
              .replaceAll("-", "");
          lastName = lastName.length() > 8 ? lastName.substring(0,8) : lastName;
          eachEmailName += lastName;
        } else {
          String firstOrMiddleName = separatedName[i]
              .substring(0, 1)
              .toLowerCase();
          eachEmailName = firstOrMiddleName + eachEmailName;
        }
      }
      if(emailMap.containsKey(eachEmailName)) {
        emailMap.put(eachEmailName, emailMap.get(eachEmailName) + 1);
        eachEmailName += emailMap.get(eachEmailName);
      }
      else {
        emailMap.put(eachEmailName, 1);
      }
      eachEmailName += "@" + C + ".com>, ";
      strBuilder.append(name);
      strBuilder.append(" <");
      strBuilder.append(eachEmailName);
    }

    return strBuilder.substring(0, strBuilder.length()-2).toString();
  }

  public static void main(String[] args) {

    Solution1 sol = new Solution1();
    String S1 = "John Doe, Peter Parker, Mary Jane Watson-Parker, James Doe, John Elvis Doe, Jane Doe, Penny Parker";
    String C1 = "Example";
    String S2 = "John Doe";


//    System.out.println(abc);
    String solution = sol.solution(S2, C1);

    System.out.println(solution);

  }



}
