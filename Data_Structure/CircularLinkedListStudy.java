package Data_Structure;

public class CircularLinkedListStudy {
    static class CircularLinkedList {
        Node head;

        CircularLinkedList(Node node) {
            head = node;
            head.nextNode = head;
            head.prevNode = head;
        }

        public void append(Node node) {
            System.out.println("append node: " + node);
            Node tail = head.prevNode;
            head.prevNode = node;
            tail.nextNode = node;
            node.prevNode = tail;
            node.nextNode = head;
        }

        public Node get(int index) {
            System.out.print("get index: " + index);
            Node current = head;
            while (current != null && index > 0) {
                current = current.nextNode;
                index--;
            }
            System.out.println(", " + current);
            return current;
        }

        public void delete(Node node) {
            System.out.println("delete node: " + node);
            if (head == node) {
                head.prevNode.nextNode = node.nextNode;
                head.nextNode.prevNode = node.prevNode;
                head = node.nextNode;
            } else {
                    node.prevNode.nextNode = node.nextNode;
                    node.nextNode.prevNode = node.prevNode;
            }
        }

        public void insertAfter(Node before, Node newNode) {
            System.out.println("insert node: " + newNode + ", between " + before + " <-> " + before.nextNode);
            newNode.nextNode = before.nextNode;
            newNode.prevNode = before;
            before.nextNode.prevNode = newNode;
            before.nextNode = newNode;

        }

        public void allSearch() {
            Node current = head;
            while (current.nextNode != head) {
                System.out.print(current + " / ");
                current = current.nextNode;
            }
            System.out.println(current);
        }

    }

    static class Node {
        Object data;
        Node prevNode;
        Node nextNode;

        public Node(Object data) {
            this.data = data;
            this.prevNode = null;
            this.nextNode = null;
        }

        @Override
        public String toString() {
            return "" + data;
        }
    }

    public static void main(String[] args) {
        Node head = new Node("zero");
        CircularLinkedList circularLinkedList = new CircularLinkedList(head);
        circularLinkedList.append(new Node("one"));
        circularLinkedList.append(new Node("two"));
        circularLinkedList.append(new Node("three"));
        circularLinkedList.append(new Node("four"));
        circularLinkedList.append(new Node("five"));
        circularLinkedList.append(new Node("six"));

        Node getNode = circularLinkedList.get(6);
        System.out.println(getNode.data + ", " + getNode.prevNode + ", " + getNode.nextNode);
        circularLinkedList.allSearch();

        getNode = circularLinkedList.get(4);
        System.out.println(getNode.data + ", " + getNode.prevNode + ", " + getNode.nextNode);
        circularLinkedList.allSearch();

        circularLinkedList.delete(getNode);
        getNode = circularLinkedList.get(4);
        System.out.println(getNode.data + ", " + getNode.prevNode + ", " + getNode.nextNode);
        circularLinkedList.allSearch();

        circularLinkedList.insertAfter(circularLinkedList.get(2), new Node("insertNode"));
        circularLinkedList.allSearch();
    }
}
