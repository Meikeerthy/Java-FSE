import java.util.ArrayList;
import java.util.Scanner;

public class Ex24_ArrayList {
    public static void main(String[] args) {
        ArrayList<String> studentNames = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter student names (type 'done' to finish):");

        while (true) {
            System.out.println("Enter name: ");
            String name = sc.nextLine();
            if (name.equalsIgnoreCase("done")) {
                break;
            }
            studentNames.add(name);
        }

        System.out.println("\nStudent names entered:");
        for (String student : studentNames) {
            System.out.println(student);
        }

        sc.close();
    }
}
