package by.tms.lesson29сollection.task4;

public class TestLinkedList {

    public static void main(String[] args) {

        UserLinkedList<String> linkedList = new UserLinkedList<>();

        linkedList.add("a").add("b").add("c");

        linkedList.forEach(System.out::println);

        linkedList.add("r",2);

        System.out.println(linkedList.indexOf("c"));













        //System.out.println(linkedList.get(0));

        //System.out.println(linkedList.size());


    }
}
