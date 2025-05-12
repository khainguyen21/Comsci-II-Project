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

    private static HttpURLConnection fetchApiResponse(String urlString) {
        try {
            // Cast string to url
            URL url = new URL(urlString);

            // Open the connection using url
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            // set the requested method to get (meaning just getting data)
            conn.setRequestMethod("GET");
            conn.connect();

            return conn;
        }catch (IOException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    public static List<Student> listStudents (String urlString) {

        // Initialize the list to store students
        List<Student> listStudent = new ArrayList<>();

        try {
            // try to open the connection through api
            HttpURLConnection conn = fetchApiResponse(urlString);

            assert conn != null;

            if (conn.getResponseCode() != 200) {
                System.out.println("Error: Could not connect to API");

            } else {
                StringBuilder resultJson = new StringBuilder();

                Scanner scanner = new Scanner(conn.getInputStream());

                // Read the all line in the response
                while (scanner.hasNext()) {
                    resultJson.append(scanner.nextLine());
                }

                scanner.close();

                conn.disconnect();

                // Create a JSON parser
                JSONParser parser = new JSONParser();

                // Because the json response start with [ then we need to convert into JSON Array
                JSONArray jsonArray = (JSONArray) parser.parse(resultJson.toString());

                // Integrate through the JSON Array
                for (Object obj : jsonArray) {

                    // Cast into JSON Object
                    JSONObject info = (JSONObject) obj;

                    // Obtain student information
                    String name = (String) info.get("Name");
                    long age = (long) info.get("Age");
                    String major = (String) info.get("Major");
                    String hobby = (String) info.get("Hobby");
                    String interest = (String) info.get("Interest");

                    // Create student object
                    Student student = new Student(name, age, major, hobby, interest);

                    // Add into the array list
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

