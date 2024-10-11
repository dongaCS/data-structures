public class DoublyLinkedList<E> {
    private static class Node<E> {
        E data;
        Node<E> next;
        Node<E> prev;

        Node(E data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    private Node<E> head;
    private int size;
    DoublyLinkedList() {
        this.head = null;
        this.size = 0;
    }

    void append(E data) {
        size++;
        if(this.head == null) {
           this.head = new Node<>(data);
           return;
        }

        Node<E> curr = this.head;
        while(curr.next != null) {
            curr = curr.next;
        }
        curr.next = new Node<>(data);
        curr.next.prev = curr;
    }

    void delete(E data) {
        if(this.head == null) {
            return;
        }

        if(this.head.data.equals(data)) {
            size--;
            this.head = this.head.next;
            if(this.head != null) this.head.prev = null;
            return;
        }

        Node<E> curr = this.head.next;
        Node<E> prevHolder = this.head;

        while(curr != null) {
            if(curr.data.equals(data)) {
                prevHolder.next = curr.next;
                if(curr.next != null) curr.next.prev = prevHolder;
                size--;
                return;
            } else {
                prevHolder = curr;
                curr = curr.next;
            }
        }
    }

    String print() {
        Node<E> curr = this.head;
        StringBuilder str = new StringBuilder("[");

        while(curr != null) {
            str.append(curr.next == null ? curr.data + "" : curr.data + "," );
            curr = curr.next;
        }
        str.append("]");
        return str.toString();
    }

    String printLinks() {
        Node<E> curr = this.head;
        StringBuilder str = new StringBuilder();
        while(curr != null) {
            str.append(curr.prev == null ? "[" + null : "[" + curr.prev.data);
            str.append("<-");
            str.append(curr.data);
            str.append("->");
            str.append(curr.next == null ? null + "]" : curr.next.data + "], ");
            curr = curr.next;
        }
        return str.toString();
    }

    int size() {
        return this.size;
    }

    boolean isEmpty() {
        return head == null;
    }

    boolean contains(E data) {
        Node<E> curr = this.head;
        while(curr != null) {
            if(curr.data.equals(data)) {
                return true;
            } else {
                curr = curr.next;
            }
        }
        return false;
    }

    void prepend(E data) {
        Node<E> n = new Node<>(data);
        if(this.head != null) {
            n.next = this.head;
            this.head.prev = n;
        }
        this.head = n;
        size++;
    }

    void removeFirst() {
        if(this.head != null) {
            if(this.head.next != null) {
                this.head.next.prev = null;
                this.head = this.head.next;
            } else {
                this.head = null;
            }
            size--;
        }
    }

    void removeLast() {
        if(this.head != null) {
            if(this.size == 1) { // only head node
                this.head = null;
            } else {
                Node<E> curr = this.head;
                while (curr.next != null) {
                    curr = curr.next;
                }
                curr.prev.next = null;
            }
            size--;
        }
    }

    DoublyLinkedList<E> reverse() {
        DoublyLinkedList<E> list = new DoublyLinkedList<>();
        if(this.head == null) {
            return list;
        }
        return reverseHelper(this.head, list);
    }

    private DoublyLinkedList<E> reverseHelper(Node<E> n, DoublyLinkedList<E> list) {
        if (n != null) {
            reverseHelper(n.next, list);
            list.append(n.data);
        }
        return list;
    }


} // end of class
