package written.leetcode.WeeklyContest.weekly278;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Problem4 {

  public int[] groupStrings(String[] words) {
    int n = words.length;

    UnionFind uf = new UnionFind(n);

    Map<Integer, Integer> map = new HashMap<>();
    int[] mask = new int[n];

    for(int i = 0; i < n; i++) {
      int x = 0;
      char[] temp = words[i].toCharArray();
      for(int j = 0; j < temp.length; j++) {
        char c = temp[j];

        x = x | (1 << (c-'a'));
      }
      map.put(x, i);
      mask[i] = x;
    }

    for(int i = 0; i < n; i++) {
      String current = words[i];
      int len = current.length();
      int x = mask[i];

      for(int j = 0; j < len; j++) {
        char c = current.charAt(j);

        x = x & (~(1<< (c-'a')));
        if(map.containsKey(x)) {
          int next = map.get(x);
          uf.join(i, next);
        }

        for(char t = 'a'; t <= 'z'; t++) {
          int dig = (x >> (t-'a')) & 1;
          if(dig ==1) {
            continue;
          }

          x = x | (1 << (t-'a'));
          if(map.containsKey(x)) {
            int next = map.get(x);
            uf.join(i, next);
          }

          x = x & (~(1 <<(t-'a')));
        }

        x = x | (1 << (c-'a'));
      }
    }

    Set<Integer> set = new HashSet<>();
    int max = 1;
    for(int i = 0; i < n; i++) {
      int fx = uf.find(i);
      set.add(fx);
      max=Math.max(max, uf.size[i]);
    }

    return new int[]{set.size(), max};
  }

  public static void main(String[] args) {
    Problem4 problem4 = new Problem4();

    int x = 0;
    x = x | 1<<2;

    x = x | 1<<2;

    System.out.println("x is " + x);
    problem4.groupStrings(new String[]{"dd"});

  }

}

class UnionFind {
  int[] parents;
  int[] size;

  public UnionFind(int n) {
    parents = new int[n];

    for(int i = 0; i < n; i++) {
      parents[i] = i;
    }
    size = new int[n];
    Arrays.fill(size, 1);
  }

  public int find(int x) {
    if(parents[x] == x) {
      return parents[x];
    }
    else {
      return parents[x] = find(parents[x]);
    }
  }

  public void join(int x, int y) {
    int rootX = find(x);
    int rootY = find(y);

    if(rootX != rootY) {
      parents[rootX] = rootY;
      size[rootY] += size[rootX];
    }
  }

  public boolean isConnected(int x, int y) {
    return find(x) == find(y);
  }
}
