package lesson17;

import java.util.Stack;

public class StackMin extends Stack<Integer>{
    Stack<Integer> stack;
    public StackMin(){
        stack = new Stack<Integer>();
    }

    public void push(int value) {
        if (value <= min()) {
            stack.push(value);
        }
        super.push(value);
    }

    public Integer pop() {
        int value = super.pop();
        if(value == min()) {
            stack.pop();
        }
        return value;
    }

    public int min() {
        if (stack.isEmpty()) {
            return Integer.MAX_VALUE;
        } else {
            return stack.peek();
        }
    }
}
