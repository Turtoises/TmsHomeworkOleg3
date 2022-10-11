package by.tms.lesson28ClassObject.task1;

public class TestUser {

    public static void main(String[] args) {

        User ivan1 = new User("Ivan", "Ivanov", 18, Gender.MAN,
                new Adress("Lenina", 20, 8));
        User ivan2 = new User("Ivan", "Ivanov", 18, Gender.MAN,
                new Adress("Lenina", 20, 8));

        System.out.println(ivan1.equals(ivan2));
        System.out.println("ivan1 hashCode: " + ivan1.hashCode());
        System.out.println("ivan2 hashCode: " + ivan2.hashCode());

        User tana = new User("Tana", "Petrova", 22, Gender.WOMAN,
                new Adress("Lenina", 20, 8));

        System.out.println(ivan1.equals(tana));
        System.out.println("ivan1 hashCode: " + ivan1.hashCode());
        System.out.println("tana hashCode: " + tana.hashCode());
    }
}
