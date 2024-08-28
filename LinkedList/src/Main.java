public class Main {
    public static void main(String[] args) {
        SinglyLinkedList<String> list = new SinglyLinkedList<>();
        list.append("happy");
        list.append("happy");
        list.append("day");
        list.append("today");
        list.print();

        list.delete("today");
        list.delete("none");
        list.delete("happy");
        list.delete("day");
        list.delete("day");
        list.delete("happy");
        list.print();

        list.prepend("new");
        list.prepend("before");
        list.append("");
        list.print();
    }
}