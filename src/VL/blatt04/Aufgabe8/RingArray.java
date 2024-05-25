package VL.blatt04.Aufgabe8;

public class RingArray<T> {
    private T[] list;
    private int firstIndex, count;
    public RingArray(int len) {
        list = (T[]) new Object[len];
        firstIndex = 0;
        count = 0;
    }

    public void insert(T input) {
        if(count == list.length) {
            throw new RuntimeException("List is full");
        } else if (list[firstIndex] == null) {
            list[firstIndex] = input;
            count++;
        } else if (list[firstIndex] == null) {
            list[firstIndex] = input;
            count++;
        } else {
            list[firstIndex + count] = input;
            count++;
        }
    }

    public void remove() {
        if(count == 0) {
            throw new RuntimeException("List is empty");
        }
        list[firstIndex % list.length] = null;
        count--;
    }

    public String toString(){
        String s = "(";
        for(int i = 0; i < count; i++) s = s + list[i];
        return s;
    }

    public static void main(String[] args) {
        RingArray<String> ring = new RingArray<String>(6);
        ring.insert("abc");
        ring.insert("def");
        System.out.println(ring);
        ring.remove();
        System.out.println(ring);
        ring.insert("ghi");
        System.out.println(ring);
    }
}
