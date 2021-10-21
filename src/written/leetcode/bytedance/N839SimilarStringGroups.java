package written.leetcode.bytedance;

public class N839SimilarStringGroups {

  private int[] parent;

  private boolean union(int u, int v) {
    if(parent[u] == parent[v]) return false;
    else {
      int rootU = find(u);
      int rootV = find(v);
      parent[rootV] = rootU;
      return true;
    }
  }

  private int find(int u) {
    if(u == parent[u]) return u;
    return parent[u] = find(parent[u]);
  }

  public int numSimilarGroups(String[] strs) {
    int N = strs.length;
    int groups = N;
    parent = new int[N];
    for(int i = 0; i < N; i++) {
      parent[i] = i;
    }

    for(int i = 0; i < N; i++) {
      for(int j = i+1; j < N; j++) {
        if(i == j) continue;
        if(isSimilar(strs[i], strs[j]) && union(i,j)) {
          groups--;
        }
      }
    }
    return groups;
  }

  private boolean isSimilar(String str1, String str2) {
    int firstDiffIdx = -1;
    int secondDiffIdx = -1;
    int len = str1.length();
    for(int i = 0; i < len; i++) {
      if(str1.charAt(i) != str2.charAt(i)) {
        if(firstDiffIdx == -1) firstDiffIdx = i;
        else if(secondDiffIdx == -1) secondDiffIdx = i;
        else return false;
      }
    }
    if (firstDiffIdx == -1) return true;
    if (secondDiffIdx == -1) return false;
    return str1.charAt(firstDiffIdx) == str2.charAt(secondDiffIdx) && str1.charAt(secondDiffIdx) == str2.charAt(firstDiffIdx);
  }


}
