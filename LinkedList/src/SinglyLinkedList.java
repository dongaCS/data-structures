
public class SinglyLinkedList<E> {

    private static class Node<E> {
        E data;
        Node<E> next;

        Node(E data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node<E> head;
    SinglyLinkedList() {
        this.head = null;
    }


    /*****************
     * METHODS
     *****************/
    // add element to end of list
    void append(E data) {
        if (head == null) { // if head is null, then it's a new list
            head = new Node<>(data);
            return;
        }
        // traverse through list until we find the end
        Node<E> curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = new Node<>(data); // append Node to end of list
    }

    // delete said the element from list
    void delete(E data) {
        if (head == null) { // if head is null there's nothing to delete
            return;
        }
        if (head.data.equals(data)) { // check if head is data we're looking for
            head = head.next;
            return;
        }
        // traverse through list looking for data
        Node<E> curr = head;
        while (curr.next != null && !curr.next.data.equals(data)) {
            curr = curr.next;
        }
        if (curr.next != null) { // if we find the data, remove reference to it
            curr.next = curr.next.next;
        }
        // else data was never in list to begin with
    }

    // prints the list
    void print() {
        Node<E> curr = head;
        StringBuilder str = new StringBuilder("[");
        while (curr != null) {
            str.append(curr.next == null ? curr.data + "" : curr.data + ",");
            curr = curr.next;
        }
        str.append("]");
        System.out.println(str);
    }

    // add element to start of list
    void prepend(E data) {
        Node<E> newNode = new Node<>(data);
        newNode.next = head;
        head = newNode;
    }
}

