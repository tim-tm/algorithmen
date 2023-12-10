package stack;

public class OStack {
    static class Content {
        public Object data;
        public Content next;
    }

    private Content top;

    public OStack() {
        top = null;
    }

    public boolean isEmpty() {
        return (top == null);
    }

    public Object top() {
        if (isEmpty()) return null;
        return top.data;
    }

    public void push(Object obj) {
        Content c = new Content();
        c.data = obj;
        c.next = top;
        top = c;
    }

    public void pop() {
        if (isEmpty()) return;
        top = top.next;
    }

    public static void main(String[] args) {
        OStack s = new OStack();
        s.push("Hello");
        s.push("World");

        System.out.println(s.top());
        s.pop();
        System.out.println(s.top());
        s.pop();
    }
}
