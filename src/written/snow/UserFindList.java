package written.snow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.stream.Collectors;

public class UserFindList {

  private PriorityQueue<Integer> userIndexList;
  private Set<Integer> userIndexSet;
  private List<Integer> cachedSorted;
  private boolean recentlyAdded;
  private int size;

  public UserFindList() {
    size = 0;
    userIndexSet = new HashSet<>();
    userIndexList = new PriorityQueue<>(Collections.reverseOrder());
    cachedSorted = new ArrayList<>();
    recentlyAdded = false;
  }

  public void addUserNumbers(List<Integer> list) {
    if(list.size() == 0 || list == null) return;
    for(int userIdx : list) {
      if(userIndexSet.contains(userIdx)) continue;
      userIndexList.add(userIdx);
      userIndexSet.add(userIdx);
      size++;
    }
    recentlyAdded = true;
  }

  public List<Integer> findSorted() {
    if(size == 0) return new ArrayList<>();
    if(recentlyAdded) {
      recentlyAdded = false;
      Integer[] sortedList = userIndexList.toArray(new Integer[size]);
      cachedSorted = Arrays.asList(sortedList);
    }
    return cachedSorted;
  }

  public List<Integer> findUpper(int index, int count) {
    if(count == 0 || size == 0) return new ArrayList<>();
    return findSorted().stream().filter(idx -> idx > index).limit(count).collect(Collectors.toList());
  }

  public static void main(String[] args) {
    UserFindList userFindList = new UserFindList();
    List<Integer> list = new ArrayList<>();
    list.add(5);
    list.add(2);
    list.add(4);
    list.add(1);
    list.add(7);
    list.add(3); // 5,2,1,4 만 넣고, idx:1, count:2로 하는 경우, 정렬이 안
    userFindList.addUserNumbers(list);
    List<Integer> sorted = userFindList.findSorted();
    List<Integer> upper = userFindList.findUpper(2, 4);
    for(int idx : upper) {
      System.out.println(idx);
    }
  }

  /**
   * 개선방안:
   * - cache를 arraylist 가 아닌 배열로 바꿔서 메모리 스페이스를 고정시킬 것
   * - 만약 findUpper 에서도 순서를 지켜서 내려줘야 한다면? ->
   */

}
