class MinStack {
    // The main stack to store the elements
    private Stack<Integer> stack;
    // The min_stack to store the minimum element at each level of the stack
    private Stack<Integer> minStack;

    // Constructor to initialize the stack and minStack
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    // Push the element onto the stack
    public void push(int val) {
        stack.push(val);
        // If minStack is empty or the new value is smaller or equal to the current minimum, push it onto minStack
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }

    // Pop the element from the stack
    public void pop() {
        // If the popped value is the same as the current minimum, pop it from minStack as well
        if (stack.peek().equals(minStack.peek())) {
            minStack.pop();
        }
        stack.pop();
    }

    // Get the top element of the stack
    public int top() {
        return stack.peek();
    }

    // Get the minimum element in the stack
    public int getMin() {
        return minStack.peek();
    }
}
