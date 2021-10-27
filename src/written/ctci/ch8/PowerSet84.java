package written.ctci.ch8;

import java.util.ArrayList;
import java.util.List;

public class PowerSet84 {

  public List<List<Integer>> getSubsets(List<Integer> elements, int index) {
    List<List<Integer>> allSubsets;
    if(index == elements.size()) {
      allSubsets = new ArrayList<>();
      allSubsets.add(new ArrayList<>()); // add empty set at base case
    } else {
      allSubsets = getSubsets(elements, index+1);
      int item = elements.get(index);
      List<List<Integer>> moreSubsets = new ArrayList<>();
      for(List<Integer> subset : allSubsets) {
        List<Integer> newSubset = new ArrayList<>();
        newSubset.addAll(subset);
        newSubset.add(item);
        moreSubsets.add(newSubset);
      }
      allSubsets.addAll(moreSubsets);
    }
    return allSubsets;
  }


  public static void main(String[] args) {
    PowerSet84 powerSet84 = new PowerSet84();
    List<Integer> input = new ArrayList<>();
    input.add(1);
    input.add(2);
    input.add(3);

    List<List<Integer>> subsets = powerSet84.getSubsets(input, 0);

    for (List<Integer> subset : subsets) {
      System.out.println("subset is " + subset);
    }

    System.out.println("dddd");
  }

}
