import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SinglyLinkedListTest {

    @Test
    void append() {
        SinglyLinkedList<String> list = new SinglyLinkedList<>();
        assertTrue(list.isEmpty());

        list.append("happy");
        assertEquals("[happy]", list.print());
        assertEquals(1, list.size());
        assertFalse(list.isEmpty());

        list.append("sad");
        assertEquals("[happy,sad]", list.print());
        assertEquals(2, list.size());

        list.append("angry");
        assertEquals("[happy,sad,angry]", list.print());
        assertEquals(3, list.size());
    }

    @Test
    void delete() {
        SinglyLinkedList<String> list = new SinglyLinkedList<>();
        list.append("happy");
        list.append("sad");

        list.delete("fearful");
        assertEquals("[happy,sad]", list.print());
        assertEquals(2, list.size());

        list.delete("happy");
        assertEquals("[sad]", list.print());
        assertEquals(1, list.size());

        list.delete("sad");
        assertTrue(list.isEmpty());
        assertEquals(0, list.size());

        list.delete("potato");
        assertTrue(list.isEmpty());
        assertEquals(0, list.size());
    }

    @Test
    void prepend() {
        SinglyLinkedList<String> list = new SinglyLinkedList<>();
        list.prepend("happy");
        assertEquals("[happy]", list.print());
        assertEquals(1, list.size());

        list.prepend("sad");
        assertEquals("[sad,happy]", list.print());
        assertEquals(2, list.size());
    }

    @Test
    void contains() {
        SinglyLinkedList<String> list = new SinglyLinkedList<>();
        list.prepend("happy");
        list.prepend("sad");
        list.append("joy");
        list.append("calm");
        assertTrue(list.contains("joy"));

        list.delete("joy");
        assertFalse(list.contains("joy"));
        assertEquals("[sad,happy,calm]", list.print());
        assertEquals(3, list.size());
    }

    @Test
    void reverse() {
        SinglyLinkedList<String> list = new SinglyLinkedList<>();
        list.prepend("happy");
        assertEquals("[happy]", list.reverse().print());

        list.prepend("sad");
        list.append("joy");
        list.append("calm");
        assertEquals("[calm,joy,happy,sad]", list.reverse().print());
        assertEquals(4, list.size());
    }

    @Test
    void removeFirst() {
        SinglyLinkedList<String> list = new SinglyLinkedList<>();
        list.append("happy");
        assertEquals("happy", list.nodeToString(list.removeFirst()));
        assertEquals("[]", list.print());
        assertTrue(list.isEmpty());

        assertNull(list.removeFirst());

        list.append("sad");
        list.append("shy");
        list.append("silly");
        assertEquals(3, list.size());
        list.removeFirst();
        assertEquals("[shy,silly]", list.print());
        assertEquals(2, list.size());
    }

    @Test
    void removeLast() {
        SinglyLinkedList<String> list = new SinglyLinkedList<>();
        list.append("happy");
        list.append("sad");
        list.append("sleepy");
        assertEquals("sleepy", list.nodeToString(list.removeLast()));
        assertEquals("sad", list.nodeToString(list.removeLast()));
        assertEquals("happy", list.nodeToString(list.removeLast()));
    }
}