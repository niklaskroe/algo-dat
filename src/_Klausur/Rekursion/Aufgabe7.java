package _Klausur.Rekursion;

public class Aufgabe7 {

}

class DuddeDa {
    static int z = 0;
    public static int Du (int i, int j) {
        System.out.println("i:" + i + ", j:" + j);
        if ((i <= 5) || (j == 4))
        {
            System.out.println(z++);
            return z;
        }
        else
        {
            System.out.println(i+j);
            return Du(i-4,j-3);
        }
    }
    public static void main (String[] args) {
        int n = 13, k = 6;
        System.out.println("Du(n,k) + Du(k,n) != " + Du(n,k) + Du(k,n));
    }
}
