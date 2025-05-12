
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

        List<Student> listStudent = new ArrayList<>();

        try {
            HttpURLConnection conn = fetchApiResponse(WEB_APP_URL);

            assert conn != null;
            if (conn.getResponseCode() != 200)
            {
                System.out.println("Error: Could not connect to API");
            }
            else {
                StringBuilder resultJson = new StringBuilder();

                Scanner scanner = new Scanner(conn.getInputStream());

                while(scanner.hasNext())
                {
                    resultJson.append(scanner.nextLine());
                }

                scanner.close();

                conn.disconnect();

                JSONParser parser = new JSONParser();

                JSONArray jsonArray = (JSONArray) parser.parse(resultJson.toString());

                for (Object obj : jsonArray)
                {
                    JSONObject info  = (JSONObject) obj;

                    String name = (String) info.get("Name");
                    long age = (long) info.get("Age");
                    String major = (String) info.get("Major");
                    String hobby = (String) info.get("Hobby");
                    String interest = (String) info.get("Interest");

                    Student student = new Student(name, age, major, hobby, interest);

                    listStudent.add(student);
                }

                System.out.println(listStudent.get(2).getName());
            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }


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

//        try
//        {
//            // Create a URL
//            URL url = new URL(urlString);
//
//            // Attempt to open the connection using url
//            HttpURLConnection connection =(HttpURLConnection)url.openConnection();
//
//            // Set the request method get, meaning just to get data from api
//            connection.setRequestMethod("GET");
//
//            connection.connect();
//
//            return connection;
//
//
//        }catch (IOException e)
//        {
//            e.printStackTrace();
//        }
//        return null;
}

