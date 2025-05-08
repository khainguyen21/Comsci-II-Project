import com.fasterxml.jackson.databind.ObjectMapper;
import java.net.*;
import java.io.*;

public class GoogleFormsFetcher {
    private static final String WEB_APP_URL = "https://script.google.com/macros/s/AKfycbyfj24E8Vn1ElepPx0lDWvCu8gdf6tiDLvMqw4oMlU8fSvhYg-5LNn-Xd-VVRih8sD-/exec";

    public static void main(String[] args) {
        try {
            System.out.println("Fetching URL: " + WEB_APP_URL);
            String rawResponse = fetchApiResponse(WEB_APP_URL);

            System.out.println("--- RAW RESPONSE START ---");
            System.out.println(rawResponse);
            System.out.println("--- RAW RESPONSE END ---");

            ObjectMapper mapper = new ObjectMapper();
            Student[] students = mapper.readValue(rawResponse, Student[].class);

            System.out.println("\nSuccessfully parsed " + students.length + " students:");
            for (Student student : students) {
                System.out.println(student.toString()); // Explicitly call toString()
            }
        } catch (Exception e) {
            System.err.println("Error occurred:");
            e.printStackTrace();
        }
    }

    private static String fetchApiResponse(String urlString) throws Exception{

        URL url = new URL(urlString);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(conn.getInputStream()))) {
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            return response.toString();
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

}