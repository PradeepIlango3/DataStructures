public class LinkedList<E> {
    Node head;

    class Node {
        Object data;
        Node next;

        Node(E data) {
            this.data = data;
        }
    }

    public void add( E data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
        } else {
            Node last = this.head;
            while (last.next != null) {
                last = last.next;
            }
            last.next = newNode;
        }
    }

    public void printList() {
        Node head = this.head;
        System.out.println("Linked List: ");
        while (head!=null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String [] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.printList();
        list.printList();
    }
}
