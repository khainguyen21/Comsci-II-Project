
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.json.simple.parser.JSONParser;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class GoogleFormsFetcher {
    private static final String WEB_APP_URL = "https://script.google.com/macros/s/AKfycbyfj24E8Vn1ElepPx0lDWvCu8gdf6tiDLvMqw4oMlU8fSvhYg-5LNn-Xd-VVRih8sD-/exec";

    public static void main(String[] args) {

        HttpURLConnection connection = fetchApiResponse(WEB_APP_URL);

        List<Student> listStudents = listStudents(connection);

        List<Student> filterbyMajor = StudentFilter.filterByMajor(listStudents, "Computer Science");

        StudentFilter.printStudents(filterbyMajor);
    }
    private static HttpURLConnection fetchApiResponse(String urlString) {
        try {

            URL url = new URL(urlString);

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("GET");

            conn.connect();

            return conn;


        }catch (IOException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    private static List<Student> listStudents (HttpURLConnection conn) {
        List<Student> listStudent = new ArrayList<>();

        try {
            conn = fetchApiResponse(WEB_APP_URL);

            assert conn != null;
            if (conn.getResponseCode() != 200) {
                System.out.println("Error: Could not connect to API");
            } else {
                StringBuilder resultJson = new StringBuilder();

                Scanner scanner = new Scanner(conn.getInputStream());

                while (scanner.hasNext()) {
                    resultJson.append(scanner.nextLine());
                }

                scanner.close();

                conn.disconnect();

                JSONParser parser = new JSONParser();

                JSONArray jsonArray = (JSONArray) parser.parse(resultJson.toString());

                for (Object obj : jsonArray) {
                    JSONObject info = (JSONObject) obj;

                    String name = (String) info.get("Name");
                    long age = (long) info.get("Age");
                    String major = (String) info.get("Major");
                    String hobby = (String) info.get("Hobby");
                    String interest = (String) info.get("Interest");

                    Student student = new Student(name, age, major, hobby, interest);

                    listStudent.add(student);
                }
                return listStudent;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}

