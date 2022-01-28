package written.leetcode.amazon.Other;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PrisonCellsAfterNDays957 {

  /**
   * Day 0: [0, 1, 0, 1, 1, 0, 0, 1]
   * Day 1: [0, 1, 1, 0, 0, 0, 0, 0]
   * Day 2: [0, 0, 0, 0, 1, 1, 1, 0]
   * Day 3: [0, 1, 1, 0, 0, 1, 0, 0]
   * Day 4: [0, 0, 0, 0, 0, 1, 0, 0]
   * Day 5: [0, 1, 1, 1, 0, 1, 0, 0]
   * Day 6: [0, 0, 1, 0, 1, 1, 0, 0]
   * Day 7: [0, 0, 1, 1, 0, 0, 0, 0]
   * Day 8: [0, 0, 0, 0, 0, 1, 1, 0]
   * Day 9: [0, 1, 1, 1, 0, 0, 0, 0]
   * Day10: [0, 0, 1, 0, 0, 1, 1, 0]
   * Day11: [0, 0, 1, 0, 0, 0, 0, 0]
   * Day12: [0, 0, 1, 0, 1, 1, 1, 0]
   * Day13: [0, 0, 1, 1, 0, 1, 0, 0]
   */

  public int[] prisonAfterNDays(int[] cells, int n) {
    Map<Integer, Integer> s = new HashMap<>();
    boolean fastForward = false;
    while(n > 0) {
      if(!fastForward) {
        if(s.containsKey(convertToBitMap(cells))) {
          n = n % (s.get(convertToBitMap((cells))) - n);
          fastForward = true;
        }
        else {
          s.put(convertToBitMap(cells), n);
        }
      }
      if(n > 0) {
        n--;
        cells = call(cells);
      }
    }
    return cells;
  }

  private int[] call(int[] cells) {
    int[] newCells = new int[cells.length];
    newCells[0] = 0;
    newCells[cells.length-1] = 0;
    for(int i = 1; i < cells.length -1; i++) {
      newCells[i] = (cells[i-1] == cells[i+1]) ? 1 : 0;
    }
    return newCells;
  }

  private int convertToBitMap(int[] cells) {
    int stateBitMap = 0;
    for (int cell : cells) {
      stateBitMap <<= 1;
      stateBitMap = (stateBitMap | cell);
    }
    return stateBitMap;
  }




  public static void main(String[] args) {
    PrisonCellsAfterNDays957 prisonCellsAfterNDays957 = new PrisonCellsAfterNDays957();

    int[] cells1 = new int[]{0,1,0,1,1,0,0,1};
    int n1 = 7;

    int[] ints = prisonCellsAfterNDays957.prisonAfterNDays(cells1, n1);

    int[] aa = new int[]{1,2,3};

    int[] bb = new int[]{1,2,3};

    if(aa == bb) {
      return;
    }

    System.out.println("dddd is");
  }

}
