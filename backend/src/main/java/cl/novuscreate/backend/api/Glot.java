package cl.novuscreate.backend.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Glot {
    public static void main(String args[]) {

        String clientId = "YourClientID"; //Replace with your client ID
        String clientSecret = "YourClientSecret"; //Replace with your client Secret
        String script = "";
        String language = "php";
        String versionIndex = "0";

//        try {
//            URL url = new URL("https://run.glot.io/languages/python/latest");
//            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//            connection.setDoOutput(true);
//            connection.setRequestMethod("POST");
//            connection.setRequestProperty("Content-Type", "application/json");
//            connection.setRequestProperty("Authorization","Token 13af198e-e3e1-4547-9476-65f3d7c63b9e");
//
//            String input = "{\n" +
//                    "  \"files\": [\n" +
//                    "    {\n" +
//                    "      \"name\": \"main.py\",\n" +
//                    "      \"content\": \"print(42)\"\n" +
//                    "    }\n" +
//                    "  ]\n" +
//                    "}";
//
//            System.out.println(input);
//
//            OutputStream outputStream = connection.getOutputStream();
//            outputStream.write(input.getBytes());
//            outputStream.flush();
//
//            if (connection.getResponseCode() != HttpURLConnection.HTTP_OK) {
//                throw new RuntimeException("Please check your inputs : HTTP error code : "+ connection.getResponseCode());
//            }
//
//            BufferedReader bufferedReader;
//            bufferedReader = new BufferedReader(new InputStreamReader(
//                    (connection.getInputStream())));
//
//            String output;
//            System.out.println("Output from Glot .... \n");
//            String[] splitted;
//            while ((output = bufferedReader.readLine()) != null) {
//                System.out.println(output);
//                splitted = output.split(",");
//                System.out.println(splitted[0]);
//                splitted = splitted[0].split(":");
//                System.out.println(splitted[1]);
//                splitted = (splitted[1]).split("\\\\n");
//                System.out.println(splitted[0]);
//                System.out.println(splitted[0].substring(1));
//
//
//
//            }
//
//            connection.disconnect();
//
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}
