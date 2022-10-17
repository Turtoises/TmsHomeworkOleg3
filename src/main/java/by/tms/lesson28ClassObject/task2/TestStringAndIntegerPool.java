package by.tms.lesson28ClassObject.task2;

public class TestStringAndIntegerPool {

    public static void main(String[] args) {

        String str1 = "Hello";
        String str2 = "Hello";
        String str3 = new String("Hello");
        System.out.println("str1=str2 is " + (str1 == str2));
        System.out.println("str2=str3 is " + (str2 == str3));
        System.out.println("str2=str3 is " + str2.equals(str3));
        System.out.println();

        Integer a = 1;
        Integer b = Integer.valueOf(1);
        Integer c = new Integer(1);
        System.out.println("a=b is " + (a == b));
        System.out.println("a=c is " + (a == c));
        System.out.println("a=c is " + a.equals(c));
        System.out.println();

        Integer aa = 130;
        Integer bb = Integer.valueOf(130);
        Integer cc = new Integer(130);
        System.out.println("a=b is " + (aa == bb));
        System.out.println("a=c is " + (aa == cc));
        System.out.println("a=c is " + aa.equals(cc));

    }
}
