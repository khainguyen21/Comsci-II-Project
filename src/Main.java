import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        HashMap<Long, Student> dataBase = new HashMap<Long, Student>();

        final String WEB_APP_URL = "https://script.google.com/macros/s/AKfycbyNyz7yR-cZBLiXn0MJOmEfNd6Y7IRwQT1vUW8YKks41KtflOq98Q-PFQe-i_XjY_M/exec";

        List<Student> listStudents = GoogleFormsFetcher.listStudents(WEB_APP_URL);
        System.out.println(listStudents);

    while(true)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select filter option:");
        System.out.println("1. Filter by Age");
        System.out.println("2. Filter by Major");
        System.out.println("3. Filter by Hobby");
        System.out.println("4. Filter by Interest");
        System.out.println("5. Search by student ID");
        System.out.println("6. Show all students");


        int choice = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        List<Student> filteredStudents = new ArrayList<>();

        switch (choice) {
            case 1:
                System.out.print("Enter age to filter by: ");
                int age = scanner.nextInt();
                filteredStudents = StudentFilter.filterByAge(listStudents, age);
                StudentFilter.printStudents(filteredStudents);

                break;
            case 2:
                System.out.print("Enter major to filter by: ");
                String major = scanner.nextLine();
                filteredStudents = StudentFilter.filterByMajor(listStudents, major);
                StudentFilter.printStudents(filteredStudents);

                break;
            case 3:
                System.out.print("Enter hobby to filter by: ");
                String hobby = scanner.nextLine();
                filteredStudents = StudentFilter.filterByHobby(listStudents, hobby);
                StudentFilter.printStudents(filteredStudents);

                break;
            case 4:
                System.out.print("Enter interest to filter by: ");
                String interest = scanner.nextLine();
                filteredStudents = StudentFilter.filterByInterest(listStudents, interest);
                StudentFilter.printStudents(filteredStudents);
                break;

            case 5:
                System.out.println("Enter the student id number: ");
                int id = scanner.nextInt();
                Student student = SearchByStudentID.addStudentByID(listStudents, id);
                System.out.println(student);
                break;

            case 6:
                filteredStudents = listStudents;
                StudentFilter.printStudents(filteredStudents);

                break;

            default:
                System.out.println("Invalid choice.");
        }
        System.out.println();
    }


        // Step 3: Print filtered results


    }
}
