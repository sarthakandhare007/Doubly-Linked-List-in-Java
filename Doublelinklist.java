class Node {
    int data;
    Node next;
    Node prev;

    Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

class DoublyLinkedList {
    Node head;

    // Insert at the end
    public void insert(int data) {
        Node newNode = new Node(data);
        if(head == null) {
            head = newNode;
        } else {
            Node curr = head;
            while(curr.next != null) {
                curr = curr.next;
            }
            curr.next = newNode;
            newNode.prev = curr;
        }
        System.out.println(data + " inserted.");
    }

    // Delete by value
    public void delete(int data) {
        if(head == null) {
            System.out.println("List is empty.");
            return;
        }
        Node curr = head;
        while(curr != null && curr.data != data) {
            curr = curr.next;
        }
        if(curr == null) {
            System.out.println(data + " not found.");
            return;
        }
        if(curr.prev != null)
            curr.prev.next = curr.next;
        else
            head = curr.next;

        if(curr.next != null)
            curr.next.prev = curr.prev;

        System.out.println(data + " deleted.");
    }

    // Display forward
    public void displayForward() {
        Node curr = head;
        System.out.print("Forward: ");
        while(curr != null) {
            System.out.print(curr.data + " <-> ");
            curr = curr.next;
        }
        System.out.println("null");
    }

    // Display backward
    public void displayBackward() {
        if(head == null) {
            System.out.println("List is empty.");
            return;
        }
        Node curr = head;
        while(curr.next != null) {
            curr = curr.next;
        }
        System.out.print("Backward: ");
        while(curr != null) {
            System.out.print(curr.data + " <-> ");
            curr = curr.prev;
        }
        System.out.println("null");
    }
}
