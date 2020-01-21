import java.util.ArrayList;
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
    }
}