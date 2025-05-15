import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

    public static List<Student> getModeAge(List<Student> students) {
        Map<Long, Long> ageCounts = students.stream()
                .collect(Collectors.groupingBy(Student::getAge, Collectors.counting()));

        long maxCount = Collections.max(ageCounts.values());

        return students.stream()
                .filter(student -> ageCounts.get(student.getAge()) == maxCount)
                .toList();
    }

    public static double getMeanAge(List<Student> students) {
        return students.stream()
                .mapToLong(Student::getAge)
                .average()
                .orElse(0.0); // Return 0.0 if the list is empty (avoids errors)
    }

    public static double getMedianAge(List<Student> students) {
        List<Long> sortedAges = students.stream()
                .map(Student::getAge) // Get ages
                .sorted() // Sort in ascending order
                .toList(); // Convert to a list

        int size = sortedAges.size();
        if (size == 0) return 0.0; // Handle empty list

        return (size % 2 == 0)
                ? (sortedAges.get(size / 2 - 1) + sortedAges.get(size / 2)) / 2.0 // Average of two middle elements
                : sortedAges.get(size / 2); // Middle element
    }

    public static List<Student> getMajorMode(List<Student> students) {
        Map<String, Long> majorCounts = students.stream()
                .collect(Collectors.groupingBy(Student::getMajor, Collectors.counting()));

        long maxCount = Collections.max(majorCounts.values());

        return students.stream()
                .filter(student -> majorCounts.get(student.getMajor()) == maxCount)
                .toList();
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
                System.out.println();
            }
        }
    }



}
