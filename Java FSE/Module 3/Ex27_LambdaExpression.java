import java.util.*;

public class Ex27_LambdaExpression {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Zara");
        names.add("John");
        names.add("Amit");
        names.add("Becky");
        names.add("Charlie");

        Collections.sort(names, (s1, s2) -> s1.compareTo(s2));

        System.out.println("Sorted names:");
        for (String name : names) {
            System.out.println(name);
        }
    }
}
