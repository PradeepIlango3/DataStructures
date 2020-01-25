import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class HelloWorld {
    public static void main(String [] args) {
        System.out.println("Hello World");
        List<Integer> list = new ArrayList<>(5);
        list.add(1);
        list.add(2);
        list.get(0);
        list.remove(0);
        list.remove(new Integer(2));
        System.out.println(list.size());

        List<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(5);
        linkedList.add(1,4);
        linkedList.clear();
        System.out.println(linkedList.size());
        Object a = new Object();
        a = test(a);
        System.out.println(a);
    }

    public static Object test(Object a) {
        a = null;
        return a;
    }
}