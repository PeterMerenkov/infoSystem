import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException, ParseException {
        String mainStr = "add 1 Пупкин Василий Иванович 2 4 ИАИТ 26.11.2021";

        int index = 0;
        String temp = "";

        while(mainStr.charAt(index) != ' ') {
            temp += mainStr.charAt(index);
            index++;
        }
        String command = temp;

        index++;
        temp = "";

        while(mainStr.charAt(index) != ' ') {
            temp += mainStr.charAt(index);
            index++;
        }
        BigInteger id1 = new BigInteger(temp);

        index++;
        temp = "";

        while(mainStr.charAt(index) != ' ') {
            temp += mainStr.charAt(index);
            index++;
        }
        String surname = temp;

        index++;
        temp = "";

        while(mainStr.charAt(index) != ' ') {
            temp += mainStr.charAt(index);
            index++;
        }
        String firstname = temp;

        index++;
        temp = "";

        while(mainStr.charAt(index) != ' ') {
            temp += mainStr.charAt(index);
            index++;
        }
        String patronymic = temp;

        index++;
        temp = "";

        while(mainStr.charAt(index) != ' ') {
            temp += mainStr.charAt(index);
            index++;
        }
        BigInteger id2 = new BigInteger(temp);

        index++;
        temp = "";

        while(mainStr.charAt(index) != ' ') {
            temp += mainStr.charAt(index);
            index++;
        }
        Integer number = Integer.parseInt(temp);

        index++;
        temp = "";

        while(mainStr.charAt(index) != ' ') {
            temp += mainStr.charAt(index);
            index++;
        }
        String faculty = temp;

        index++;
        temp = "";

        while(mainStr.charAt(index) != '.') {
            temp += mainStr.charAt(index);
            index++;
        }
        Integer day = Integer.parseInt(temp);

        index++;
        temp = "";

        while(mainStr.charAt(index) != '.') {
            temp += mainStr.charAt(index);
            index++;
        }
        Integer month = Integer.parseInt(temp);

        index++;
        temp = "";

        while(mainStr.length() != index) {
            temp += mainStr.charAt(index);
            index++;
        }
        Integer year = Integer.parseInt(temp);

        System.out.println(command + " " + id1 + " " + surname + " "
                + firstname + " " + patronymic + " " + id2 + " " + number
                + " " + faculty + " " + day + "." + month + "." + year);

        //-------------------------------------------------------------------------

        JSONParser parser = new JSONParser();
        FileReader reader = new FileReader("test.json");

        JSONObject jsonObject = (JSONObject) parser.parse(reader);

        String modelName = (String) jsonObject.get("name");
        BigInteger modelId1 = BigInteger.valueOf((Long) jsonObject.get("id"));
        BigInteger modelId2 = BigInteger.valueOf((Long)((JSONObject)jsonObject.get("group")).get("id"));
        Integer modelNumber = ((Long)((JSONObject)jsonObject.get("group")).get("number")).intValue();
        String modelDate = (String) jsonObject.get("date");


        System.out.println(modelName);

        reader.close();
    }
}