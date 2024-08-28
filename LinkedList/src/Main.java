public class Main {
    public static void main(String[] args) {
        SinglyLinkedList<String> list = new SinglyLinkedList<>();
        list.append("happy");
        list.append("happy");
        list.append("day");
        list.append("today");
        System.out.println("size " + list.size());
        System.out.println(list.isEmpty());
        list.print();

        list.delete("today");
        list.delete("none");
        list.delete("happy");
        list.delete("day");
        list.delete("day");
        list.delete("happy");
        System.out.println("size " + list.size());
        System.out.println(list.isEmpty());
        list.print();

        list.prepend("new");
        list.prepend("before");
        list.append("");
        System.out.println("size " + list.size());
        list.print();

        System.out.println(list.contains("happy"));
        System.out.println(list.contains("before"));
        System.out.println("size " + list.size());

        SinglyLinkedList<String> list2 = list.reverse();
        list2.print();
        list2.removeFirst();
        System.out.println("size " + list2.size());
        list2.print();
        list2.removeFirst();
        System.out.println("size " + list2.size());
        list2.print();
        list2.removeFirst();
        System.out.println("size " + list2.size());
        list2.print();
        list2.removeFirst();
        System.out.println("size " + list2.size());
        list2.print();

        list.print();
        list.removeLast();
        list.print();
        System.out.println("size " + list.size());
        list.removeLast();
        list.print();
        System.out.println("size " + list.size());
        list.removeLast();
        list.print();
        System.out.println("size " + list.size());
        list.removeLast();
        list.print();
        System.out.println("size " + list.size());



    }
}