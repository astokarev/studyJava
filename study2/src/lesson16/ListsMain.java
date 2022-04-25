package lesson16;

public class ListsMain {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.addNode(1);
        list.addNode(4);
        list.addNode(6);
        list.addNode(8);
        list.addNode(6);
        list.addNode(2);
        list.addNode(5);
        //list.show();
        //System.out.println();
        //list.deleteDubs2();
        list.show();
        System.out.println();
       //System.out.println(list.findK(4));
        //list.recursiveK(list.head, 2);
        list.partition(list.head, 6);
        list.show();
    }
}
