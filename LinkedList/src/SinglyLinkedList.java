
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
    private int size;

    SinglyLinkedList() {
        this.head = null;
        this.size = 0;
    }


    /*****************
     * METHODS
     *****************/
    // add element to end of list
    void append(E data) {
        size++;
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
            size--;
            return;
        }
        // traverse through list looking for data
        Node<E> curr = head;
        while (curr.next != null && !curr.next.data.equals(data)) {
            curr = curr.next;
        }
        if (curr.next != null) { // if we find the data, remove reference to it
            size--;
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
        size++;
    }

    // check if element exist in the list
    boolean contains(E data) {
        if (head == null) {
            return false;
        }
        if (head.data.equals(data)) {
            return true;
        }
        Node<E> curr = head;
        while (curr.next != null && !curr.next.data.equals(data)) {
            curr = curr.next;
        }
        return curr.next != null;
    }

    // returns the size of the list
    int size() {
        return size;
    }

    // returns if list is empty
    boolean isEmpty() {
        return head == null;
    }

    // returns a new list in reverse order
    SinglyLinkedList<E> reverse() {
        SinglyLinkedList<E> list = new SinglyLinkedList<>();
        if (head == null) {
            return list;
        }
        reverseHelper(list, head);
        list.size = size;
        return list;
    }
    void reverseHelper(SinglyLinkedList<E> list, Node<E> node) {
        if (node.next == null) {
            list.append(node.data);
        } else {
            reverseHelper(list, node.next);
            list.append(node.data);
        }
    }

    // removes the first element from the list
    void removeFirst() {
        if (head != null) {
            head = head.next;
            size--;
        }
    }

    // removes the last element from the list
    void removeLast() {
        if (head != null) {
            if (head.next == null) {
                head = null;
            } else {
                Node<E> prev = head;
                Node<E> curr = head.next;
                while (curr.next != null) {
                    prev = curr;
                    curr = curr.next;
                }
                prev.next = null;
            }
            size--;
        }
    }





} // end of class

