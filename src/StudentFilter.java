import java.util.ArrayList;
import java.util.List;

public class StudentFilter {

    // Filter the list of student by age
    public static List<Student> filterByAge (List<Student> list, long age)
    {
        List<Student> filterStudents = new ArrayList<>();

        for (Student student : list)
        {
            if (student.getAge() == age)
            {
                filterStudents.add(student);
            }
        }
        return filterStudents;
    }
    // Filter the list of student by major
    public static List<Student> filterByMajor (List<Student> list, String major)
    {
        List<Student> filterStudents = new ArrayList<>();

        for (Student student : list)
        {
            if (student.getMajor().equalsIgnoreCase(major))
            {
                filterStudents.add(student);
            }
        }
        return filterStudents;
    }

    // Filter the list of student by hobby
    public static List<Student> filterByHobby (List<Student> list, String hobby)
    {
        List<Student> filterStudents = new ArrayList<>();

        for (Student student : list)
        {
            if (student.getMajor().equalsIgnoreCase(hobby))
            {
                filterStudents.add(student);
            }
        }
        return filterStudents;
    }

    // Filter the list of student by interest
    public static List<Student> filterByInterest (List<Student> list, String interest)
    {
        List<Student> filterStudents = new ArrayList<>();

        for (Student student : list)
        {
            if (student.getMajor().equalsIgnoreCase(interest))
            {
                filterStudents.add(student);
            }
        }
        return filterStudents;
    }

    // Print out the list of student
    public static void printStudents(List<Student> students)
    {
        if (students.isEmpty())
        {
            System.out.println("No students found");
        }
        else {
            for (Student student : students)
            {
                System.out.println(student);
            }
        }
    }



}
