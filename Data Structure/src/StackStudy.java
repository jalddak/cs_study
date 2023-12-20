public class StackStudy {
    static class Node {
        Object data;
        Node next;
        Node before;

        public Node(Object data) {
            this.data = data;
            this.next = null;
            this.before = null;
        }

        @Override
        public String toString(){
            return String.valueOf(data);
        }
    }

    static class Stack {
        Node head;
        Node top;

        public Stack() {
            head = null;
            top = null;
        }

        public void append(Node node) {
            if (head == null) {
                head = node;
            } else {
                top.next = node;
                node.before = top;
            }
            top = node;
        }

        public Node pop() {
            Node result = top;
            if (head == top){
                head = null;
                top = null;
            } else{
                Node nextTop = head;
                while (nextTop.next != top){
                    nextTop = nextTop.next;
                }
                top = nextTop;
            }
            return result;
        }

        public boolean isEmpty(){
            if (head == null && top == null) return true;
            return false;
        }

        public Node getTop(){
            return top;
        }

        public int getSize(){
            if (isEmpty()) return 0;
            Node current = head;
            int size = 1;
            while (current.next != null){
                current = current.next;
                size++;
            }
            return size;
        }


    }

    public static void main(String[] args) {
        Stack stack = new Stack();
        System.out.println("stack.pop() = " + stack.pop());
        stack.append(new Node(0));
        System.out.println("stack.pop() = " + stack.pop());
        System.out.println("stack.isEmpty() = " + stack.isEmpty());
        System.out.println("stack.getSize() = " + stack.getSize());
        System.out.println("stack.getTop() = " + stack.getTop());
        System.out.println("stack.pop() = " + stack.pop());
        System.out.println("stack.isEmpty() = " + stack.isEmpty());
        System.out.println("stack.getSize() = " + stack.getSize());
        System.out.println("stack.getTop() = " + stack.getTop());
        stack.append(new Node(6));
        stack.append(new Node(5));
        stack.append(new Node(4));
        stack.append(new Node(3));
        stack.append(new Node(2));
        stack.append(new Node(1));
        System.out.println("stack.isEmpty() = " + stack.isEmpty());
        System.out.println("stack.getSize() = " + stack.getSize());
        System.out.println("stack.getTop() = " + stack.getTop());
        System.out.println("stack.pop() = " + stack.pop());
        System.out.println("stack.pop() = " + stack.pop());
        System.out.println("stack.pop() = " + stack.pop());
        System.out.println("stack.pop() = " + stack.pop());
        System.out.println("stack.pop() = " + stack.pop());
        System.out.println("stack.pop() = " + stack.pop());
        System.out.println("stack.pop() = " + stack.pop());
    }
}
