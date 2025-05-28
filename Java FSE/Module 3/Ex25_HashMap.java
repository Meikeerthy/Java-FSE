import java.util.HashMap;
import java.util.Scanner;

public class Ex25_HashMap {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<Integer, String> studentMap = new HashMap<>();

        System.out.println("How many students do you want to add? ");
        int n = sc.nextInt();
        sc.nextLine();
        
        for (int i = 0; i < n; i++) {
            System.out.println("Enter student ID (integer): ");
            int id = sc.nextInt();
            sc.nextLine(); 

            System.out.println("Enter student name: ");
            String name = sc.nextLine();

            studentMap.put(id, name);
        }

        System.out.println("Enter a student ID to retrieve the name: ");
        if (sc.hasNextInt()) {
            int lookupId = sc.nextInt();
            if (studentMap.containsKey(lookupId)) {
                System.out.println("Student Name: " + studentMap.get(lookupId));
            } else {
                System.out.println("No student found with ID: " + lookupId);
            }
        } else {
            System.out.println("Invalid input. Please enter a numeric student ID.");
        }

        sc.close();
    }
}
