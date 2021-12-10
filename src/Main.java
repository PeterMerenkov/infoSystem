import mvc.Model;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException, ParseException {
        /*JSONParser parser = new JSONParser();
        FileReader reader = new FileReader("test.json");

        JSONObject jsonObject = (JSONObject) parser.parse(reader);

        String modelName = (String) jsonObject.get("name");
        BigInteger modelId1 = BigInteger.valueOf((Long) jsonObject.get("id"));
        BigInteger modelId2 = BigInteger.valueOf((Long)((JSONObject)jsonObject.get("group")).get("id"));
        Integer modelNumber = ((Long)((JSONObject)jsonObject.get("group")).get("number")).intValue();
        String modelDate = (String) jsonObject.get("date");


        System.out.println(modelName);

        reader.close();*/

        Model model = new Model("D:\\myFiles\\study\\netCracker\\java\\infoSystem\\src\\student.json");

        for (int i = 1; i <= 2; i++) {
            System.out.println(model.getGroup(BigInteger.valueOf(i)));
        }

        for (int i = 1; i <= 2; i++) {
            System.out.println(model.getStudent(BigInteger.valueOf(i)));
        }
    }
}