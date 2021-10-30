package written.ctci.ch8;

import java.util.ArrayList;
import java.util.List;

public class PermutationWithoutDups87 {


//  private List<String> perms = new ArrayList<>();

  public List<String> getPerms(String s) {

    List<String> permutations = new ArrayList<>();
    if(s == null) {
      return null;
    }

    if(s.length() == 0) {
      permutations.add("");
      return permutations;
    }

    char first = s.charAt(0);
    String remainder = s.substring(1);

    List<String> words = getPerms(remainder);

    for(String word : words) {
      for(int i = 0; i<= word.length(); i++) {
        String insertedWord = insertChar(word, first, i);
        permutations.add(insertedWord);
      }
    }

    return permutations;
  }

  private String insertChar(String originWord, char charToInsert, int idx) {
    String first = originWord.substring(0,idx);
    String end = originWord.substring(idx);
    return first + charToInsert + end;
  }


  public static void main(String[] args) {
    PermutationWithoutDups87 permutationWithoutDups87 = new PermutationWithoutDups87();

    List<String> abc = permutationWithoutDups87.getPerms("aac");

    System.out.println("ddd");
  }

}
