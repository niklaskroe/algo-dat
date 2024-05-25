package _Klausur.Feldstruktur;

public class ListeF<T extends Comparable<T>> {
    private T[] element;
    private int lastIndex;

    public ListeF(int len) {
        element = (T[]) new Object[len];
        lastIndex = -1;
    }

    public void sortedInsert(T o) {
        if(lastIndex == element.length-1)
            throw new RuntimeException("Liste voll");

        int k = 0;
        for(int i = 0; i <= lastIndex; i++) {
            if(o.compareTo(element[i]) > 0)
                k++;
        }

        for(int i = lastIndex; i >= k; i--)
            element[i+1] = element[i];
        element[k] = o;
    }

    public String toString() {
        String s = "(";
        for(int i = 0; i <= lastIndex-1; i++) {
            s = s + element[i] + ",";
        }
        if(lastIndex==element.length-1)
            s = s + element[lastIndex] + ")";
        return s;
    }

    public static void main(String[] args) {
        ListeF<Integer> liste = new ListeF<Integer>(5);
        liste.sortedInsert(3);
        liste.sortedInsert(2);
        liste.sortedInsert(5);
        liste.sortedInsert(6);
        System.out.println(liste);
    }
}
