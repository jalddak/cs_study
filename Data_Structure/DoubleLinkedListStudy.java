package Data_Structure;

public class DoubleLinkedListStudy {
    static class DoubleLinkedList {
        Node head;

        DoubleLinkedList(Node node) {
            head = node;
        }

        public void append(Node node) {
            System.out.println("append node: " + node);
            Node tail = head;
            while (tail.nextNode != null) {
                tail = tail.nextNode;
            }
            tail.nextNode = node;
            node.prevNode = tail;
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
                head = node.nextNode;
                head.prevNode = null;
            } else {
                if (node.prevNode != null){
                    node.prevNode.nextNode = node.nextNode;
                }
                if (node.nextNode != null){
                    node.nextNode.prevNode = node.prevNode;
                }
            }
        }

        // 책에 나온대로 구현한 insert 인데, head를 바꾸면서 삽입하는 것은 안된다.
        public void insertAfter(Node before, Node newNode) {
            System.out.println("insert node: " + newNode + ", between " + before + " <-> " + before.nextNode);
            newNode.nextNode = before.nextNode;
            newNode.prevNode = before;

            if (before.nextNode != null){
                before.nextNode.prevNode = newNode;
                before.nextNode = newNode;
            }

        }

        public void insert(int index, Node node) {
            System.out.println("insert node: " + node + "at index:" + index);
            if (index == 0) {
                head.prevNode = node;
                node.nextNode = head;
                head = node;

            } else {
                index--;
                Node before = head;
                while (before.nextNode != null && index > 0) {
                    before = before.nextNode;
                    index--;
                }
                if (before.nextNode != null) {
                    node.nextNode = before.nextNode;
                    before.nextNode.prevNode = node;
                    node.prevNode = before;
                    before.nextNode = node;
                }
            }
        }

        public void allSearch() {
            Node current = head;
            while (current.nextNode != null) {
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
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList(head);
        doubleLinkedList.append(new Node("one"));
        doubleLinkedList.append(new Node("two"));
        doubleLinkedList.append(new Node("three"));
        doubleLinkedList.append(new Node("four"));
        doubleLinkedList.append(new Node("five"));
        doubleLinkedList.append(new Node("six"));

        Node getNode = doubleLinkedList.get(4);
        System.out.println(getNode.data + ", " + getNode.prevNode + ", " + getNode.nextNode);
        doubleLinkedList.allSearch();

        doubleLinkedList.delete(getNode);
        getNode = doubleLinkedList.get(4);
        System.out.println(getNode.data + ", " + getNode.prevNode + ", " + getNode.nextNode);
        doubleLinkedList.allSearch();

        doubleLinkedList.insertAfter(doubleLinkedList.get(2), new Node("insertNode"));
        doubleLinkedList.allSearch();

        doubleLinkedList.insert(1, new Node("insertIndex 1"));
        doubleLinkedList.allSearch();
        doubleLinkedList.insert(2, new Node("insertIndex 2"));
        doubleLinkedList.allSearch();
        doubleLinkedList.insert(0, new Node("insertIndex 0"));
        doubleLinkedList.allSearch();
        doubleLinkedList.insert(10, new Node("insertIndex 10"));
        doubleLinkedList.allSearch();
    }
}
