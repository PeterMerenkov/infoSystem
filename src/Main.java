import mvc.*;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException, ParseException {

        Model model = new Model("D:\\myFiles\\study\\netCracker\\java\\infoSystem\\src\\student.json");
        View view = new View();

        Controller controller = new Controller(model, view);

        controller.start();
    }
}