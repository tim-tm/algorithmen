package stack.sort;

import stack.Stack;

public class StackSort {
    public static int pollMin(Stack<Integer> stack, Stack<Integer> stack2) {
        int min = Integer.MAX_VALUE;
        while (!stack.isEmpty()) {
            if (stack.top() < min) {
                min = stack.top();
            }
            stack2.push(stack.top());
            stack.pop();
        }

        while (!stack2.isEmpty()) {
            if (stack2.top() != min) {
                stack.push(stack2.top());
            }
            stack2.pop();
        }
        return min;
    }

    public static void sort(Stack<Integer> stack, Stack<Integer> stack3) {
        Stack<Integer> stack2 = new Stack<>();
        while (!stack.isEmpty()) {
            stack3.push(pollMin(stack, stack2));
        }
    }

    public static void main(String[] args) {
        Stack<Integer> input = new Stack<>();
        input.push(1);
        input.push(5);
        input.push(4);
        input.push(2);
        input.push(1);
        input.push(7);

        Stack<Integer> output = new Stack<>();
        sort(input, output);

        while (!output.isEmpty()) {
            System.out.printf("%s\n", output.top());
            output.pop();
        }
    }
}
