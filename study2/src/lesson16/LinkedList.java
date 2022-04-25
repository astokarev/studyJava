package lesson16;

import java.util.HashSet;

public class LinkedList {

    public Node head;

    public LinkedList() {
    }

    public void addNode(int d) {
        if (head == null) {
            head = new Node(d);
        } else {
            Node n = head;
            while (n.next != null) {
                n = n.next;
            }
            n.next = new Node(d);
        }
    }

    public void show() {
        head.showAll();
    }

    public void deleteDubs() {
        HashSet set = new HashSet();
        Node prev = null;
        Node n = head;
        while (n.next != null) {
            if (set.contains(n.data)) {
                //prev = prev;
                prev.next = n.next;
            } else {
                prev = n;
                set.add(n.data);
            }
            n = n.next;
        }
    }

    public void deleteDubs2() {
        Node n = head;
        while (n != null) {
            Node runner = n;
            while (runner.next != null) {
                if (runner.next.data == n.data) {
                    runner.next = runner.next.next;
                } else {
                    runner = runner.next;
                }
            }
            n = n.next;
        }
    }

    public int findK(int k) {
        Node runner1 = head;
        Node runner2 = head;

        for (int i = 0; i < k; i++) {
            if (runner1 == null) return 0;
            runner1 = runner1.next;
        }

        while (runner1 != null) {
            runner1 = runner1.next;
            runner2 = runner2.next;
        }
        return runner2.data;
    }

    public int recursiveK(Node n, int k) {
        if (n == null) {
            return 0;
        }
        int index = recursiveK(n.next, k);
        if (index == k) {
            System.out.println(k + "th element is" + n.data);
        }
        return index;
    }

    public boolean deleteThis() {
        Node n = head;
        if (n == null || n.next == null){
            return false;
        }
        Node next = n.next;
        n.data = next.data;
        n.next = next.next;
        return true;
    }

    Node partition(Node node, int x){
        Node beforeStart = null;
        Node beforeEnd = null;
        Node afterStart = null;
        Node afterEnd = null;

        while(node != null){
            Node next = node.next;
            node.next = null;
            if(node.data <x){
                if(beforeStart == null){
                    beforeStart = node;
                    beforeEnd = beforeStart;
                }else {
                    beforeEnd.next = node;
                    beforeEnd = node;
                }
            } else {
               if(afterStart == null){
                   afterStart = node;
                   afterEnd = afterStart;
               } else {
                   afterEnd.next = node;
                   afterEnd = node;
               }
            }
            node = next;
        }
        if (beforeStart == null){
            return afterStart;
        }
        beforeEnd.next = afterStart;
        return beforeStart;
    }


}
