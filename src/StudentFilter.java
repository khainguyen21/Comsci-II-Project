import java.util.ArrayList;
import java.util.List;

public class StudentFilter {

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
