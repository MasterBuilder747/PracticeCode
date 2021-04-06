package LeetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class MinStack {
    Stack<Integer> s;
    ArrayList<Integer> a;

    public MinStack() {
        this.s = new Stack<>();
        this.a = new ArrayList<>();
    }

    public void push(int val) {
        this.s.push(val);
        this.a.add(val);
        Collections.sort(a);
    }

    public void pop() {
        int t = this.s.pop();
        this.a.remove(t);
    }

    public int top() {
        return this.s.peek();
    }

    public int getMin() {
        return this.s.get(0);
    }
}
