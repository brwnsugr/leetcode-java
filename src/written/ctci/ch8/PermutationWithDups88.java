package written.ctci.ch8;

import java.util.HashSet;
import java.util.Set;

public class PermutationWithDups88 {


  public Set<String> getPerms(String s) {
    if(s == null) return null;

    Set<String> permutations = new HashSet<>();
    if(s.length() == 0) {
      permutations.add("");
      return permutations;
    }

    char first = s.charAt(0);
    String remainder = s.substring(1);

    Set<String> words = getPerms(remainder);

    for(String word : words) {
      for(int i = 0; i <= word.length(); i++) {
        String newWord = insert(word, first, i);
        permutations.add(newWord);
      }
    }

    return permutations;
  }

  private String insert(String originWord, char charToInsert, int idx) {
    String first = originWord.substring(0,idx);
    String end = originWord.substring(idx);
    return first + charToInsert + end;
  }


  public static void main(String[] args) {
    PermutationWithDups88 permutationWithDups88 = new PermutationWithDups88();

    Set<String> abc = permutationWithDups88.getPerms("aac");

    System.out.println("ddd");
  }

}
