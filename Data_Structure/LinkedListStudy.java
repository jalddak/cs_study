package Data_Structure;

public class LinkedListStudy {
    static class LinkedList {
        Node head;

        LinkedList(Node node) {
            head = node;
        }

        public void append(Node node) {
            System.out.println("append node: " + node);
            Node tail = head;
            while (tail.nextNode != null) {
                tail = tail.nextNode;
            }
            tail.nextNode = node;
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
            } else {
                Node current = head;
                while (current != null && current.nextNode != node) {
                    current = current.nextNode;
                }
                if (current != null) {
                    current.nextNode = node.nextNode;
                }
            }
        }

        // 책에 나온대로 구현한 insert 인데, head를 바꾸면서 삽입하는 것은 안된다.
        public void insertAfter(Node before, Node newNode) {
            System.out.println("insert node: " + newNode + ", between " + before + " <-> " + before.nextNode);
            newNode.nextNode = before.nextNode;
            before.nextNode = newNode;
        }

        public void insert(int index, Node node) {
            System.out.println("insert node: " + node + ", at index:" + index);
            if (index == 0) {
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
        Node nextNode;

        public Node(Object data) {
            this.data = data;
            this.nextNode = null;
        }

        @Override
        public String toString() {
            return String.valueOf(data);
        }
    }

    public static void main(String[] args) {
        Node head = new Node("zero");
        LinkedList linkedList = new LinkedList(head);
        linkedList.append(new Node("one"));
        linkedList.append(new Node("two"));
        linkedList.append(new Node("three"));
        linkedList.append(new Node("four"));
        linkedList.append(new Node("five"));
        linkedList.append(new Node("six"));

        Node getNode = linkedList.get(5);
        linkedList.allSearch();
        linkedList.delete(getNode);
        linkedList.allSearch();
//        linkedList.delete(linkedList.get(0));
//        linkedList.allSearch();
        linkedList.insertAfter(linkedList.get(2), new Node("insertNode"));
        linkedList.allSearch();
        linkedList.insert(1, new Node("insertIndex 1"));
        linkedList.allSearch();
        linkedList.insert(2, new Node("insertIndex 2"));
        linkedList.allSearch();
        linkedList.insert(0, new Node("insertIndex 0"));
        linkedList.allSearch();
        linkedList.insert(10, new Node("insertIndex 10"));
        linkedList.allSearch();
    }

}
