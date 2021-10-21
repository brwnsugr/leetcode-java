package live.graph;

public class QuickFind {

  /**
   * find 메소드의 퍼포먼스가 O(1) 로 빠른 자료구조
   * root[i] 라는 선형 배열을 사용하여 표현함 (i는 vertex, root[i] 는 i vertex 의 root 값을 나타냄)
   * 즉, 모든 root[i] 값은 parent 가 아닌, root 를 다이렉트로 가리키게 만든다.
   */
  private int[] root;

  public QuickFind(int size) {
    root = new int[size];
    for(int i = 0; i < size; i++) {
      root[i] = i;
    }
  }

  //x 라는 노드의 root 노드 값을 return
  public int find(int x) {
    return root[x];
  }

  public void union(int x, int y) {
    // x 의 루트 노드 값, y의 루트 노드 값을
    int rootX = find(x);
    int rootY = find(y);
    if(rootX != rootY) {
      for(int i = 0; i < root.length; i++) {
        if(root[i] == rootY) {
          root[i] = rootX;
        }
      }
    }
  }

  public boolean isConnected(int x, int y) {
    return find(x) == find(y);
  }

  public static void main(String[] args) {
    QuickFind unionFind = new QuickFind(5);

    unionFind.union(0,1);
    unionFind.union(1, 4);
    boolean connected = unionFind.isConnected(0, 1);

    boolean connected2 = unionFind.isConnected(1, 4);

    System.out.println("1 and 4 is Connected ? " + connected2);

    System.out.println("root of 4 is " + unionFind.find(4));
    System.out.println("root of 1 is " + unionFind.find(1));

  }
}


