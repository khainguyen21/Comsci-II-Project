import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {

        final String WEB_APP_URL = "https://script.google.com/macros/s/AKfycby3dx8n43fIDHEzHxYa5ARc00TOm3ppeK6v3Va4icfqmSqpL5rAUW1nUYPh3X5f_XAW/exec";

        List<Student> listStudents = GoogleFormsFetcher.listStudents(WEB_APP_URL);

        boolean playing = true;

        while(playing)
        {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Select filter option:");
            System.out.println("1. Filter by Age");
            System.out.println("2. Filter by Major");
            System.out.println("3. Filter by Hobby");
            System.out.println("4. Filter by Interest");
            System.out.println();
            System.out.println("5. Search by student ID");
            System.out.println();
            System.out.println("6. Get mode age");
            System.out.println("7. Get mean age");
            System.out.println("8. Get median age");
            System.out.println("9. Get mode major");
            System.out.println();
            System.out.println("10: Sort by age (Using Merge Sort)");
            System.out.println("11: Sorted by student ID (Using Merge Sort)");
            System.out.println();
            System.out.println("12. Show all students");
            System.out.println("13. STOP THE PROGRAM");

            System.out.println();

            int choice = -1;
            while(true)
            {
                System.out.print("Enter your option: ");

                if (scanner.hasNextInt()) {
                    choice = scanner.nextInt();
                    scanner.nextLine(); // Consume the "enter" key because after we type 2 and hit enter (2 keys on keyboard got pressed therefore we need to clean that up)
                    break;
                }
                else {
                    System.out.println("Invalid input. Please try those numbers in the filter option only!");
                    scanner.next(); // Consume the invalid, prepare for the next input from users
                }

            }


            List<Student> filteredStudents;
            switch (choice)
            {
                case 1:
                    System.out.print("Enter age to filter by: ");
                    int age = scanner.nextInt();
                    assert listStudents != null;
                    filteredStudents = StudentFilter.filterByAge(listStudents, age);
                    StudentFilter.printStudents(filteredStudents);
                    break;

                case 2:
                    System.out.print("Enter major to filter by: ");
                    String major = scanner.nextLine();
                    assert listStudents != null;
                    filteredStudents = StudentFilter.filterByMajor(listStudents, major);
                    StudentFilter.printStudents(filteredStudents);
                    break;

                case 3:
                    System.out.print("Enter hobby to filter by: ");
                    String hobby = scanner.nextLine();
                    assert listStudents != null;
                    filteredStudents = StudentFilter.filterByHobby(listStudents, hobby);
                    StudentFilter.printStudents(filteredStudents);
                    break;

                case 4:
                    System.out.print("Enter interest to filter by: ");
                    String interest = scanner.nextLine();
                    assert listStudents != null;
                    filteredStudents = StudentFilter.filterByInterest(listStudents, interest);
                    StudentFilter.printStudents(filteredStudents);
                    break;

                case 5:
                    System.out.print("Enter the student id number: ");
                    int id = scanner.nextInt();
                    assert listStudents != null;
                    Student student = SearchByStudentID.addStudentByID(listStudents, id);
                    System.out.println(student);
                    break;

                case 6:
                    assert listStudents != null;
                    filteredStudents = StudentFilter.getModeAge(listStudents);
                    StudentFilter.printStudents(filteredStudents);
                    break;

                case 7:
                    assert listStudents != null;
                    System.out.println("The average age is " + Math.round(StudentFilter.getMeanAge(listStudents)));
                    break;

                case 8:
                    assert listStudents != null;
                    System.out.println("The median of age is " + Math.round(StudentFilter.getMedianAge(listStudents)));
                    break;

                case 9:
                    assert listStudents != null;
                    filteredStudents = StudentFilter.getMajorMode(listStudents);
                    StudentFilter.printStudents(filteredStudents);

                case 10:
                    assert listStudents != null;
                    StudentSorter.sortByAge(listStudents, 0, listStudents.size() - 1 );
                    StudentFilter.printStudents(listStudents);


                case 11:
                    assert listStudents != null;
                    StudentSorter.sortByID(listStudents, 0, listStudents.size() - 1);
                    StudentFilter.printStudents(listStudents);

                case 12:
                    filteredStudents = listStudents;
                    assert filteredStudents != null;
                    StudentFilter.printStudents(filteredStudents);
                    break;

                case 13:
                    playing = false;
                    System.out.println("Thank you for using our program!");
                    break;

                default:
                    System.out.println("Invalid choice.");
                    break;
            }
            System.out.println();
        }
    }
}
