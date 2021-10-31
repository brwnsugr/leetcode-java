package written.ctci.ch10;

public class SparseSearch105 {

  private int binarySearchSkippingEmpty(String[] words, String targetWord, int start, int end) {



    while(start < end) {
      int mid = (start + end) / 2;
      if(words[mid].isEmpty()) {
        int left = mid - 1;
        int right = mid + 1;
        while(true) {
          if(left < start && right > end) return -1; // out of range
          else if(!words[left].isEmpty() && left >= start) {
            mid = left;
            break;
          }
          else if(!words[right].isEmpty() && right <= end) {
            mid = right;
            break;
          }
          left--; right++;
        }
      }
      if(words[mid].equals(targetWord)) return mid;
      else if(words[mid].compareTo(targetWord) < 0) {
        //find right
        start = mid + 1;
      }
      else if(words[mid].compareTo(targetWord) > 0) {
        //find left
        end = mid;
      }
    }
    return start;
  }


  public int findIdx(String[] words, String targetWord) {

    int i = binarySearchSkippingEmpty(words, targetWord, 0, words.length - 1);
    return i;
  }

  public static void main(String[] args) {

    String[] input1 = new String[]{
        "at", "", "", "", "ball", "","","car","","","dad","",""
    };

    SparseSearch105 sparseSearch105 = new SparseSearch105();
    int ball = sparseSearch105.findIdx(input1, "ball");

    System.out.println(ball);




  }

}
