package blatt06.Aufgabe17;
import java.util.*;

public class lotto {
    public static void main(String[] args) {
        HashSet<Integer> zahlen = new HashSet<Integer>();
        for(int i = 0; i < 7; i++) {
            zahlen.add((int) (1 + Math.random() * 49));
        }
        System.out.println(zahlen);
    }
}
