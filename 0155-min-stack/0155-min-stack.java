import java.util.*;

class MinStack {
    Stack<Long> stack;
    long min;

    public MinStack() {
        stack = new Stack<>();
    }

    public void push(int val) {
        if (stack.isEmpty()) {
            stack.push((long) val);
            min = val;
        } else if (val >= min) {
            stack.push((long) val);
        } else {
            stack.push(2L * val - min);
            min = val;
        }
    }

    public void pop() {
        long x = stack.pop();

        if (x < min) {
            min = 2 * min - x;
        }
    }

    public int top() {
        long x = stack.peek();

        if (x < min) {
            return (int) min;
        }

        return (int) x;
    }

    public int getMin() {
        return (int) min;
    }
}