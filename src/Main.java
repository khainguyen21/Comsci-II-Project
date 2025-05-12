import java.net.HttpURLConnection;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        final String WEB_APP_URL = "https://script.google.com/macros/s/AKfycbyfj24E8Vn1ElepPx0lDWvCu8gdf6tiDLvMqw4oMlU8fSvhYg-5LNn-Xd-VVRih8sD-/exec";

        List<Student> listStudents = GoogleFormsFetcher.listStudents(WEB_APP_URL);
        System.out.println(listStudents);

        List<Student> filteredStudents = StudentFilter.filterByMajor(listStudents, "Computer Science");
        StudentFilter.printStudents(filteredStudents);

    }
}
