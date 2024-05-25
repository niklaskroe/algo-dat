package VL.blatt05.Aufgabe16;

public class ListeL<I extends Comparable<I>> {

    static class ElementL<K> {
        private K inhalt;           // Inhalt des Listenelements
        private ElementL<K> next;   // Verweis auf den Nachfolger

        public ElementL(K o) {
            inhalt = o;
            next = null;
        }
    }

    private ElementL<I> head;       // Referenz auf den Anfang der Liste

    public ListeL() {
        head = null;
    }

    public ListeL(I o) {
        head = new ElementL<I>(o);
    }

    public int find1(I o) {
        int i = 0;
        ElementL<I> help = head;
        while (help != null) {
            if (help.inhalt.equals(o)) {
                return i;
            } else {
                help = help.next;
            }
            i++;
        }
        return -1;
    }

    // Selectionsort
    public void sort1 () {
        // Check if list has 2 elements or more
        if (head == null || head.next == null) {
            return;
        }
        ElementL<I> pos = head;

        while (pos != null) {
            ElementL<I> min = pos;
            ElementL<I> help = min.next;
            while (help != null) {
                if (help.inhalt.compareTo(min.inhalt) < 0) {
                    min = help;
                }
                help = help.next;
            }
            if (min != pos) {
                I temp = pos.inhalt;
                pos.inhalt = min.inhalt;
                min.inhalt = temp;
            }
            pos = pos.next;
        }
    }

    // Bubblesort
    public void sort2 () {
        // Check if list has 2 elements or more
        if (head == null || head.next == null) {
            return;
        }

        ElementL<I> i = head;
        while (i != null) {
            ElementL<I> j = i.next;
            while (j != null) {
                if (i.inhalt.compareTo(j.inhalt) < 0) {
                    I temp = i.inhalt;
                    i.inhalt = j.inhalt;
                    j.inhalt = temp;
                }
                j = j.next;
            }
            i = i.next;
        }
    }

    // Insertionsort
    public void sort3 () {
        // Check if list has 2 elements or more
        if (head == null || head.next == null) {
            return;
        }

        ElementL<I> lastSorted = head;
        ElementL<I> current;

        while (lastSorted.next != null) {
            current = lastSorted.next;
            if (current.inhalt.compareTo(lastSorted.inhalt) >= 0) {
                lastSorted = current;
            } else {
                lastSorted.next = current.next;
                if (head.inhalt.compareTo(current.inhalt) >= 0) {
                    current.next = head;
                    head = current;
                } else {
                    ElementL<I> help = head;
                    while ((help.next != null) && help.next.inhalt.compareTo(current.inhalt) < 0) {
                        help = help.next;
                    }
                    current.next = help.next;
                    help.next = current;
                }
            }

        }
    }

    public ElementL<I> insert(I o) {   // am Anfang einf�gen
        ElementL<I> newEl = new ElementL<I>(o);
        if (head == null) { // Liste ist noch leer
            head = newEl;
        } else {
            newEl.next = head;
            head = newEl;
        }
        return newEl;
    }

    public ElementL<I> insert(I o, ElementL<I> pred) { // nach pred (Vorg�nger) einf�gen
        ElementL<I> newEl = new ElementL<I>(o);
        if (pred == null) { // am Anfang einf�gen
            newEl.next = head;
            head = newEl;
        } else {  // nach pred (Vorg�nger) einf�gen
            newEl.next = pred.next;
            pred.next = newEl;
        }
        return newEl;
    }

    public void remove(ElementL<I> pred) {  // Element nach pred (Vorg�nger) l�schen
        if (pred == null) // erstes Element l�schen
            head = head.next;
        else if (pred.next != null)  // Element nach pred (Vorg�nger) l�schen
            pred.next = pred.next.next;
    }

    public String toString() {
        String s = "(";
        ElementL<I> help = head;
        while (help != null && help.next != null) {
            s = s + help.inhalt + ", ";
            help = help.next;
        }
        if (help != null)
            s = s + help.inhalt;
        return s + ")";
    }

    // Test

    public static void main(String[] args) {
        ListeL<Integer> l = new ListeL<Integer>();
        l.insert(0);
        ElementL<Integer> eins = l.insert(new Integer(1));
        l.insert(3);
        l.insert(2, eins);  // nach eins einf�gen
        l.remove(eins);  // Nachfolger von eins l�schen
        l.insert(4);
        l.insert(2);
        System.out.println(l);

        System.out.println("Suchen:");
        System.out.println(l.find1(0));

        System.out.println("Selectionsort:");
        l.sort1();
        System.out.println(l);

        System.out.println("Bubblesort:");
        l.sort2();
        System.out.println(l);

        System.out.println("Insertionsort:");
        l.sort3();
        System.out.println(l);
    }

}
