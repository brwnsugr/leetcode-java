package written.leetcode.amazon.ArrayAndStrings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ReorderDataInLogFiles937 {
  public String[] reorderLogFiles(String[] logs) {
    Comparator<String> myComp = myComp();

    Arrays.sort(logs, myComp);

    return logs;
  }

  Comparator<String> myComp() {
    Comparator<String> myComp = new Comparator<String>() {
      @Override
      public int compare(String s1, String s2) {
        String[] split1 = s1.split(" ", 2);
        String[] split2 = s2.split(" ", 2);

        boolean isDigit1 = Character.isDigit(split1[1].charAt(0));
        boolean isDigit2 = Character.isDigit(split2[1].charAt(0));

        //both are letter-logs
        if (!isDigit1 && !isDigit2) {
          int cmp = split1[1].compareTo(split2[1]);
          if( cmp != 0) {
            return cmp;
          }
          return split1[0].compareTo(split2[0]);
        }

        else if(!isDigit1 && isDigit2) { // 1번이 먼저 오는 거는 return -1
          return -1;
        }
        else if(isDigit1 && !isDigit2) { // 2 번이 먼저 오는거는 return 1
          return 1;
        } else { // both logs are digit log
          return 0;
        }
      }
    };
    return myComp;
  }

  public static void main(String[] args) {
    String[] logs = new String[]{"dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"};
    ReorderDataInLogFiles937 reorderDataInLogFiles937 = new ReorderDataInLogFiles937();
    reorderDataInLogFiles937.reorderLogFiles(logs);
  }

}
