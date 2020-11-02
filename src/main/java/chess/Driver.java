package chess;

public class Driver {

  public static void main(String[] args) {
    int count = 0;
    String s = "a carrot and car";
    String sub = "car";
    int pos = s.indexOf(sub);
    while (pos >= 0) {
      s = s.substring(pos);
      count++;
      pos = s.indexOf(sub);
    }
    System.out.println(count);
  }
}
