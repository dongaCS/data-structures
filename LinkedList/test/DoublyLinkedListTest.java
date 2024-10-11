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


    @Test
    void prepend() {
        DoublyLinkedList<String> list = new DoublyLinkedList<String>();
        list.prepend("fig");
        list.prepend("pear");
        list.prepend("apple");
        list.append("tomato");
        assertEquals("[apple,pear,fig,tomato]", list.print());
        assertEquals(4, list.size());
        assertEquals("[null<-apple->pear], [apple<-pear->fig], [pear<-fig->tomato], [fig<-tomato->null]", list.printLinks());

    }

    @Test
    void removeFirst() {
        DoublyLinkedList<String> list = new DoublyLinkedList<String>();
        // making sure nothing breaks if called on empty list
        list.removeFirst();
        assertEquals(0, list.size());
        assertEquals("",list.printLinks());
        assertTrue(list.isEmpty());

        list.append("apple");
        list.append("banana");
        list.append("coconut");

        list.removeFirst();
        assertEquals(2, list.size());
        assertEquals("[null<-banana->coconut], [banana<-coconut->null]", list.printLinks());

        list.removeFirst();
        assertEquals(1, list.size());
        assertEquals("[null<-coconut->null]", list.printLinks());

        list.removeFirst();
        assertEquals(0, list.size());
        assertEquals("",list.printLinks());
        assertTrue(list.isEmpty());
    }

    @Test
    void removeLast() {
        DoublyLinkedList<String> list = new DoublyLinkedList<String>();
        // making sure nothing breaks if called on empty list
        list.removeLast();
        assertEquals(0, list.size());
        assertEquals("", list.printLinks());
        assertTrue(list.isEmpty());

        list.append("apple");
        list.append("banana");
        list.append("coconut");

        list.removeLast();
        assertEquals(2, list.size());
        assertEquals("[null<-apple->banana], [apple<-banana->null]", list.printLinks());

        list.removeLast();
        assertEquals(1, list.size());
        assertEquals("[null<-apple->null]", list.printLinks());

        list.removeLast();
        assertEquals(0, list.size());
        assertEquals("", list.printLinks());
        assertTrue(list.isEmpty());
    }

    @Test
    void reverse() {
        DoublyLinkedList<String> list = new DoublyLinkedList<String>();
        list.append("apple");
        DoublyLinkedList<String> rev = list.reverse();
        assertEquals(list.printLinks(), rev.printLinks());

        list.prepend("banana");
        rev = list.reverse();
        assertEquals("[null<-apple->banana], [apple<-banana->null]", rev.printLinks());

        list.append("coconut");
        rev = list.reverse();
        assertEquals("[coconut,apple,banana]", rev.print());
        assertEquals("[null<-coconut->apple], [coconut<-apple->banana], [apple<-banana->null]", rev.printLinks());
        assertEquals(3, rev.size());
    }

    @Test
    void testFloat() {
        DoublyLinkedList<Float> list = new DoublyLinkedList<Float>();
        list.append(1.0f);
        list.append(2.0f);
        list.append(3.0f);
        list.prepend(0.5f);
        list.prepend(0.4f);
        list.append(4.0f);
        list.removeFirst();
        list.removeLast();

        assertTrue(list.contains(1.0f));
        assertEquals(4, list.size());
        assertEquals("[0.5,1.0,2.0,3.0]", list.print());
        assertEquals("[null<-0.5->1.0], [0.5<-1.0->2.0], [1.0<-2.0->3.0], [2.0<-3.0->null]", list.printLinks());

        DoublyLinkedList<Float> rev = list.reverse();
        assertEquals("[null<-3.0->2.0], [3.0<-2.0->1.0], [2.0<-1.0->0.5], [1.0<-0.5->null]", rev.printLinks());


    }
}