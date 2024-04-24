package blatt06.Aufgabe18;

import java.util.*;
import Prog1Tools.IOTools;

public class sieb {
    public static void main(String[] args) {
        // Step 1
        int n = 0;
        while (n < 2) {
            n = IOTools.readInteger("n (> 2): ");
        }

        //Step 2
        Set<Integer> T = new TreeSet<Integer>();
        for(int i = 2; i <= n; i++) {
            T.add(i);
        }

        // Step 3
         Set<Integer> S = new TreeSet<Integer>();

        // Step 4
        int p = 2;

        // Step 5
        while (!(Math.pow(p, 2) > n)) {
            for (int i = 2; p * i > n; i++) {
                S.add(p*i);
            }
            if (p == 2) {
                p = 3;
            } else {
                do {
                    p = p + 2;
                } while(S.contains(p));
            }
        }

        // Step 6
        T.removeAll(S);

        // Step 7
        Iterator<Integer> result = T.iterator();
        int r = 0;
        while (result.hasNext()){
            if (r % 10 == 0){
                System.out.println();
            }
            System.out.print(result.next() + " ");
            r++;
        }
        System.out.println("\nEs sind " + T.size() + " Primzahlen gefunden worden.");
    }
}
