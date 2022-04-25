package lesson17;

public class Test {
    public static void main(String[] args) {
        StackMin test = new StackMin();
        test.push(3);
        test.push(4);
        test.push(-7);
        test.push(8);
        test.push(9);
        test.push(-5);
        System.out.println(test.min());
    }
}
