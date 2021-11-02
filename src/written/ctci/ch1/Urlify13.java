package written.ctci.ch1;

public class Urlify13 {

  public void urlify(char[] str, int trueLen) {
    int spaceCount = 0;
    for(int i = 0; i < trueLen; i++) {
      if(str[i] ==' ') spaceCount++;
    }
    int newLength = trueLen + 2 * spaceCount;
    int index = newLength;
    if(trueLen < str.length) str[trueLen] = '\0';
    for(int i = trueLen - 1; i >= 0; i--) {
      if(str[i] == ' ') {
        str[index-1] = '0';
        str[index-2] = '2';
        str[index-3] = '%';
        index -= 3;
      }
      else {
        str[index-1] = str[i];
        index--;
      }
    }

  }

  public static void main(String[] args) {
    Urlify13 urlify13 = new Urlify13();
    String s1 = "Mr John Smith    ";
    int len = 13;

    urlify13.urlify(s1.toCharArray(), len);
  }

}
