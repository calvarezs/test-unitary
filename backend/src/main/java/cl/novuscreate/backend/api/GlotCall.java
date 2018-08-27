package cl.novuscreate.backend.api;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


public class GlotCall {

    private String language;
    private String code;


    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public GlotCall(String language, String code) {
        this.language = language;
        this.code = code;
    }

    public String runCode(){
        try {
            URL url = new URL("https://run.glot.io/languages/"+getLanguage()+"/latest");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Authorization","Token 13af198e-e3e1-4547-9476-65f3d7c63b9e");

//            String input = "{\n" +
//                    "  \"files\": [\n" +
//                    "    {\n" +
//                    "      \"name\": \"main.py\",\n" +
//                    "      \"content\": \"print(42)\"\n" +
//                    "    }\n" +
//                    "  ]\n" +
//                    "}";

            String input = "{\n" +
                    "  \"files\": [\n" +
                    "    {\n" +
                    "      \"name\": \"main.py\",\n" +
                    "      \"content\": \""+getCode()+"\"\n" +
                    "    }\n" +
                    "  ]\n" +
                    "}";

            System.out.println(input);

            OutputStream outputStream = connection.getOutputStream();
            outputStream.write(input.getBytes());
            outputStream.flush();

            if (connection.getResponseCode() != HttpURLConnection.HTTP_OK) {
                throw new RuntimeException("Please check your inputs : HTTP error code : "+ connection.getResponseCode());
            }

            BufferedReader bufferedReader;
            bufferedReader = new BufferedReader(new InputStreamReader(
                    (connection.getInputStream())));

            String output;
            String err;
            String salida ="";
            System.out.println("Output from Glot .... \n");
            String[] splitted;
            String[] splittedAux;

            while ((output = bufferedReader.readLine()) != null) {
                System.out.println(output);
                splitted = output.split(",");
                System.out.println(splitted[0]);
                splittedAux = splitted[1].split(":");
                splitted = splitted[0].split(":");

                System.out.println("******///");
                System.out.println(splittedAux[1]);
                if(splittedAux[1].length() > 3){
                    return splittedAux[1];
                }
                System.out.println("******///");

                System.out.println(splitted[1]);
                splitted = (splitted[1]).split("\\\\n");
                System.out.println(splitted[0]);
                System.out.println(splitted[0].substring(1));

                salida = splitted[0].substring(1);


            }

            connection.disconnect();
            return salida;

        } catch (MalformedURLException e) {
            e.printStackTrace();
            return "";
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }

    }




}
