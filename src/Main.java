import mvc.Group;
import mvc.Model;
import mvc.Student;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException, ParseException {

        Model model = new Model("D:\\myFiles\\study\\netCracker\\java\\infoSystem\\src\\student.json");

        for (int i = 1; i <= 2; i++) {
            System.out.println(model.getGroup(BigInteger.valueOf(i)));
        }

        for (int i = 1; i <= 2; i++) {
            System.out.println(model.getStudent(BigInteger.valueOf(i)));
        }

        Group g1 = new Group(2, "someFac");

        model.addGroup(g1);

        model.write("D:\\myFiles\\study\\netCracker\\java\\infoSystem\\src\\student.json");
    }
}