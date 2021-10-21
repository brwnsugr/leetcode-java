package written.programmers;

import java.util.HashMap;
import java.util.Map;

public class Solution1 {

  public int solution(int leave, String day, int[] holidays) {
    int answer = -1;

    // day -> 토,일 일수 계산 하기
    //

    // 휴일 배열 채워넣기
    // 1일부터 시작하면서 연차를 휴일 사이에 넣으면서 가장 긴 길이를 찾아준다.

    Map<String, int[]> dayOfWeekMap = new HashMap<>();
    Map<Integer, Boolean> holidayMap = new HashMap<>();

    dayOfWeekMap.put("SUN", new int[]{1,7,8,14,15,21,22,28,29});
    dayOfWeekMap.put("MON", new int[]{6,7,13,14,19,20,26,27});
    dayOfWeekMap.put("TUE", new int[]{5,6,12,13,19,20,26,27});
    dayOfWeekMap.put("WED", new int[]{4,5,11,12,18,19,25,26});
    dayOfWeekMap.put("THU", new int[]{3,4,10,11,17,18,24,25});
    dayOfWeekMap.put("FRI", new int[]{2,3,9,10,16,17,23,24,30});
    dayOfWeekMap.put("SAT", new int[]{1,2,8,9,15,16,22,23,30});

    // 1일이 SUN -> holidays -> 1, 7,8, 14,15, 21,22, 28,29
    int[] weekends = dayOfWeekMap.get(day);
    for(int weekendHoliday : weekends) {
      holidayMap.put(weekendHoliday, true);
    }
    for(int holiday : holidays) {
      if(!holidayMap.containsKey(holiday)) {
        holidayMap.put(holiday, true);
      }
    }

    for(int i = 1; i <= 30; i++) {
      int startDay = i;
      int tempAnswer = 0;
      int leaveCount = leave;
      while(startDay <= 30) {
        if(holidayMap.containsKey(startDay)) {
          tempAnswer++;
        } else if(!holidayMap.containsKey(i)) {
          if(leaveCount > 0) {
            leaveCount--;
            tempAnswer++;
          } else {
            break;
          }
        }
        startDay++;
      }
      if(tempAnswer >= answer) {
        answer = tempAnswer;
      }
    }


    return answer;
  }




  public static void main(String[] args) {
    Solution1 solution1 = new Solution1();
    solution1.solution(4, "SAT", new int[]{7});

  }

}
