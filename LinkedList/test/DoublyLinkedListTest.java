import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DoublyLinkedListTest {

    @Test
    void append() {
        DoublyLinkedList<String> list = new DoublyLinkedList<String>();
        assertEquals(0, list.size());
        assertTrue(list.isEmpty());

        list.append("apple");
        assertEquals(1, list.size());
        assertTrue(list.contains("apple"));
        assertEquals("[null<-apple->null]", list.printLinks());

        list.append("banana");
        assertEquals(2, list.size());
        assertTrue(list.contains("banana"));
        assertEquals("[null<-apple->banana], [apple<-banana->null]", list.printLinks());

        list.append("coconut");
        list.append("durian");
        assertEquals(4, list.size());
        assertEquals("[null<-apple->banana], [apple<-banana->coconut], [banana<-coconut->durian], [coconut<-durian->null]", list.printLinks());
    }

    @Test
    void delete() {
        DoublyLinkedList<String> list = new DoublyLinkedList<String>();
        list.append("elderberry");
        list.append("fig");
        list.append("guava");
        list.append("honeydew");
        assertEquals("[elderberry,fig,guava,honeydew]", list.print());
        assertEquals("[null<-elderberry->fig], [elderberry<-fig->guava], [fig<-guava->honeydew], [guava<-honeydew->null]", list.printLinks());
        assertTrue(list.contains("fig"));

        // delete middle
        list.delete("fig");
        assertFalse(list.contains("fig"));
        assertEquals("[null<-elderberry->guava], [elderberry<-guava->honeydew], [guava<-honeydew->null]", list.printLinks());
        assertEquals(3, list.size());

        // delete end
        list.delete("honeydew");
        assertEquals("[null<-elderberry->guava], [elderberry<-guava->null]", list.printLinks());
        assertEquals(2, list.size());

        // delete head
        list.delete("elderberry");
        assertEquals("[null<-guava->null]", list.printLinks());
        assertEquals(1, list.size());

        // delete all
        list.delete("guava");
        assertEquals("", list.printLinks());
        assertEquals(0, list.size());
        assertTrue(list.isEmpty());
    }



}