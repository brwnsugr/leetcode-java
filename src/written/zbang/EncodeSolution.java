package written.zbang;

public class EncodeSolution {


  public String solution(String s1, int num) {

    StringBuilder stringBuilder = new StringBuilder();

    String ii = "1 5";

    String[] s = ii.split(" ");

    for(int i = 0; i < s1.length(); i++) {
      int step = (int) Math.pow(num, i + 1);
      stringBuilder.append(convert(s1.charAt(i), step));
    }
    return stringBuilder.toString();
  }

  public char convert(char c1, int step) {
    int optimizedStep = ('a'-c1 + step) % 26;
    return (char) (optimizedStep + 'a');
  }

  public static void main(String[] args) {
    int aa = 'a'-'a' + 2;
    int zzz = ('a'-'a' + 1) % 26;

    char processed = (char) (zzz + 'a');
    int zz = 'z'-'a'; // 25

    System.out.println(aa);
    System.out.println(zzz);
    System.out.println(processed);
  }


}


