package lesson16;

public class Node {
    public Node next;
    public int data;

    public Node(int d) {
        data = d;
    }



    public void showAll() {
        System.out.print(data + " ");
        if (next!=null) {
            next.showAll();
        }
    }
}


